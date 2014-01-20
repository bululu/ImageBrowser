package model;

import java.awt.image.BufferedImage;

public interface Image {
    public BufferedImage getBufferedImage();
    public Image getNext();
    public Image getPrev();
    
    public void setNext(Image image);
    public void setPrev(Image image);
}
