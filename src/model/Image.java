package model;

public interface Image {
    public Dimension getDimension();
    public Image getNext();
    public Image getPrev();
    
    public void setNext(Image image);
    public void setPrev(Image image);
}
