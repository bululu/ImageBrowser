package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Image;

public class ApplicationFrame extends JFrame{

        private int imageIndex=-1;
        private ImagePanel imagePanel;
        Image[] images;

    public ApplicationFrame(Image[] images) throws IOException {
        super("Image Viewer");
        this.images=images;
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        drawNextImage();
        this.setVisible(true);
    }

    private void createComponents() throws IOException {
        this.add(CreateImagePanel());
        this.add(CreateToolbar(), BorderLayout.SOUTH);
    }

    private JPanel CreateImagePanel() throws IOException {
        imagePanel = new ImagePanel();
        return imagePanel;
    }

    private JPanel CreateToolbar() {
        JPanel panel= new JPanel();
        panel.add(CreatePrevButton());
        panel.add(CreateNextButton());
        return panel;
    }

    private JButton CreatePrevButton() {
        JButton button= new JButton("prev");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drawPrevImage();
                } catch (IOException ex) {
                    Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return button;
    }
    
    private void drawPrevImage() throws IOException{
        imageIndex= (imageIndex - 1 + images.length ) % images.length;
        setCurrentImage(imageIndex);
    }

    private JButton CreateNextButton() {
        JButton button= new JButton("next");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drawNextImage();
                } catch (IOException ex) {
                    Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return button;
    }
    
    private void drawNextImage() throws IOException{
        imageIndex= (imageIndex + 1) % images.length;
        setCurrentImage(imageIndex);
    }

    private void setCurrentImage(int index) throws IOException {
        imagePanel.setImage(images[index].getBufferedImage());
    }
   
}
