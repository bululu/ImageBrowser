package persistence;

import java.awt.image.BufferedImage;
import model.Image;

public class ProxyImage implements Image {

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }
    
    private final ImageLoader loader;
    private Image next;
    private Image prev;
    private Image realImage;
    
    @Override
    public BufferedImage getBufferedImage() {
        checkLoaded();
        return realImage.getBufferedImage();
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image image) {
        next=image;
    }

    @Override
    public void setPrev(Image image) {
        prev=image;
    }

    private void checkLoaded() {
        if (realImage==null)
            realImage=loader.load();
    }

}
