package control;

import java.awt.event.ActionEvent;
//import ui.ImageViewer;

public class PrevImageCommand implements Command{
    
  //  private final ImageViewer viewer;

    public PrevImageCommand() {
     //   this.viewer = viewer;
    }

    @Override
    public void execute() {
  //      viewer.setImage(viewer.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //    execute();
    }

}
