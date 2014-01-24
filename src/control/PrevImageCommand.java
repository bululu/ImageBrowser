package control;

import ui.ImageViewer;


public class PrevImageCommand implements Command{
    
    private ImageViewer viewer;

    public PrevImageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        viewer.setImage(viewer.getImage().getPrev());
    }

}
