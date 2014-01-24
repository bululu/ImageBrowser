package imagebrowser;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Image;
import model.RealImage;
import persistence.ImageLoader;
import persistence.ProxyImage;
import ui.ApplicationFrame;
import ui.ImagePanel;
import ui.ImageViewer;

public class ImageBrowser {

    public static void main(String[] args) throws IOException {
        new ImageBrowser().execute();
    }

    private void execute() throws IOException {
        Image[] images= linkImages(createImages());
        ImagePanel panel= new ImagePanel(images[0]);
        CreateApplicationFrame(createCommands(panel),panel);        
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

    private void CreateApplicationFrame(HashMap commandMap, ImagePanel panel) throws IOException {
        ApplicationFrame frame= new ApplicationFrame(commandMap, panel);
    }

    private HashMap createCommands(ImageViewer viewer) throws IOException {
        HashMap<String,Command> commandMap= new HashMap<>();
        commandMap.put("next", new NextImageCommand(viewer));
        commandMap.put("prev", new PrevImageCommand(viewer));
        return commandMap;
        
        
    }

    
            
}
