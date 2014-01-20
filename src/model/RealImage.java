package model;

import java.awt.image.BufferedImage;


public class RealImage implements Image{
    
    private final BufferedImage image;

    public RealImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return image;
    }

    @Override
    public Image getNext() {
        return null;
    }

    @Override
    public Image getPrev() {
        return null;
    }

    @Override
    public void setNext(Image image) {
    }

    @Override
    public void setPrev(Image image) {
    }

}
