package persistence;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {

    public BufferedImage load(String filename) throws IOException {
        return ImageIO.read(new File(filename));
    }

}