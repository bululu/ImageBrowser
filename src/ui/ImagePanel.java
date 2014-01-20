package ui;

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
    
    

}
