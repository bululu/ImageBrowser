package control;

import java.awt.event.ActionEvent;
//import ui.ImageViewer;

public class NextImageCommand implements Command{
    //private final ImageViewer viewer;

    public NextImageCommand() {
  //      this.viewer = viewer;
    }
    
    @Override
    public void execute() {
      //  viewer.setImage(viewer.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

}
