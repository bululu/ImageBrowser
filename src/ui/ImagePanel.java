package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
    
    private BufferedImage image;
    private int initialX;
    private int offset;
    private BufferedImage nextImage;
    private BufferedImage prevImage;

    public ImagePanel() throws IOException {
        super();
        this.offset=0;
        this.hookEvenets();
        this.nextImage= ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\jellyfish.jpg"));
        this.prevImage= ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\koala.jpg"));
    }

    private void hookEvenets() {
        this.hookMouseListener();
        this.hookMouseMotionListener();
    }
    
    public void setImage(BufferedImage image){
        this.image=image;
        repaint();
    }
    
    @Override
    public void paint(Graphics graphics){
        if (image == null)
            return;
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawImage(image, offset, 0, null);
        if (offset==0)
            return;
        if (offset<0)
            graphics.drawImage(nextImage, image.getWidth()+offset, 0, null);
        else
            graphics.drawImage(prevImage, offset-image.getWidth(), 0, null);
            
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
                if (offset > image.getWidth()/2)
                    image=prevImage;
                if (offset < -image.getWidth()/2)
                    image=nextImage;
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
