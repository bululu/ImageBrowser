package ui;

import control.Command;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame{

        private HashMap<String,Command> commandMap;

    public ApplicationFrame(HashMap commandMap, ImagePanel panel) throws IOException {
        super("Image Viewer");
        this.commandMap=commandMap;
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents(panel);
        drawNextImage();
        this.setVisible(true);
    }

    private void createComponents(ImagePanel panel) throws IOException {
        this.add(panel);
        this.add(CreateToolbar(), BorderLayout.SOUTH);
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
        Command prevc=commandMap.get("prev");
        prevc.execute();
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
        Command nextc= commandMap.get("next");
        nextc.execute();
    }

   
}
