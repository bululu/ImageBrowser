package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame{

        private static final String root= "C:\\Users\\Public\\Pictures\\Sample Pictures";
        private String[] images= {"chrysanthemum.jpg","desert.jpg","hydrangeas.jpg","jellyfish.jpg","koala.jpg","lighthouse.jpg","penguins.jpg","tulips.jpg"};
        private int imageIndex=-1;
        private ImagePanel imagePanel;

    public ApplicationFrame() {
        super("Image Viewer");
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        drawNextImage();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(CreateImagePanel());
        this.add(CreateToolbar(), BorderLayout.SOUTH);
    }

    private JPanel CreateImagePanel() {
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
                drawPrevImage();
            }
        });
        return button;
    }
    
    private void drawPrevImage(){
        imageIndex= (imageIndex - 1 + images.length ) % images.length;
        setCurrentImage(imageIndex);
    }

    private JButton CreateNextButton() {
        JButton button= new JButton("next");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawNextImage();
            }
        });
        return button;
    }
    
    private void drawNextImage(){
        imageIndex= (imageIndex + 1) % images.length;
        setCurrentImage(imageIndex);
    }

    private void setCurrentImage(int index) {
        
    }
   
}
