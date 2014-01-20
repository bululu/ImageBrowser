package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import javax.swing.JPanel;
import model.Image;

class ImagePanel extends JPanel {
    
    private Image image;
    private int initialX;
    private int offset;

    public ImagePanel(Image image) throws IOException {
        super();
        this.image=image;
        this.offset=0;
        this.hookEvenets();
    }

    private void hookEvenets() {
        this.hookMouseListener();
        this.hookMouseMotionListener();
    }
    
    public void setImage(Image image){
        this.image=image;
        repaint();
    }
    
    @Override
    public void paint(Graphics graphics){
        if (image == null)
            return;
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawImage(image.getBufferedImage(), offset, 0, null);
        if (offset==0)
            return;
        if (offset<0)
            graphics.drawImage(image.getNext().getBufferedImage(), image.getBufferedImage().getWidth()+offset, 0, null);
        else
            graphics.drawImage(image.getPrev().getBufferedImage(), offset-image.getBufferedImage().getWidth(), 0, null);
            
    }

    private void hookMouseListener() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked"+e.getX());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("pressed"+e.getX());
                initialX=e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("released"+e.getX());
                if (offset > image.getBufferedImage().getWidth()/2)
                    image=image.getPrev();
                if (offset < -image.getBufferedImage().getWidth()/2)
                    image=image.getNext();
                offset=0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("entered"+e.getX());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("exited");
            }
        });
    }

    private void hookMouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragging"+e.getX());
                offset=e.getX()-initialX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moving"+e.getX());
            }
        });
        
    }
}
