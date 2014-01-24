package control;

import ui.ImageViewer;


public class NextImageCommand implements Command{
    
    private ImageViewer viewer;

    public NextImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        viewer.setImage(viewer.getImage().getNext());
    }

}
