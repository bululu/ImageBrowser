package ui;

public class ConsoleImageViewer extends ImageViewer {

    @Override
    public void refresh() {
        System.out.println(getImage().getDimension().getWidth());
        System.out.println("x");
        System.out.println(getImage().getDimension().getHeight());
        System.out.println("y");
    }

}
