package imagebrowser;

import control.NextImageCommand;
import control.PrevImageCommand;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Image;
import model.RealImage;
import persistence.ImageLoader;
import persistence.ProxyImage;
import ui.ApplicationFrame;
import ui.ImageViewer;

public class ImageBrowser {

    public static void main(String[] args) throws IOException {
        new ImageBrowser().execute();
    }

    private void execute() throws IOException {
        Image[] images= linkImages(createImages());
        //ImageViewer viewer= createImageViewer(images[0]);
       // createApplicationFrame(createCommands(viewer));
        new ApplicationFrame(images);
    }

    private Image[] createImages() {
        Image[] images= new Image[8];
        for (int i=0; i< images.length; i++){
            images[i]=createImage(i);
        }
        return images;
    }

    private Image createImage(final int index) {
        final String root= "C:\\Users\\Public\\Pictures\\Sample Pictures\\";
        final String[] images= {"chrysanthemum.jpg","desert.jpg","hydrangeas.jpg","jellyfish.jpg","koala.jpg","lighthouse.jpg","penguins.jpg","tulips.jpg"};
        return new ProxyImage(new ImageLoader() {

            @Override
            public Image load() {               
                try {
                    return new RealImage(ImageIO.read(new File(root+images[index])));
                } catch (IOException ex) {
                    Logger.getLogger(ImageBrowser.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
               
            }
        });
    }

    private Image[] linkImages(Image[] images) {
        for (int i=0; i< images.length; i++){
            Image image= images[i];
            Image next= images[(i+1)%images.length];
            Image prev= images[(i+images.length-1) % images.length];
            image.setNext(next);
            image.setPrev(prev);
        }
        return images;
    }

    private ImageViewer createImageViewer(Image image) {
        ImageViewer viewer= new ImageViewer() {

            @Override
            public void refresh() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        viewer.setImage(image);
        return viewer;
    }    
    
            
}
