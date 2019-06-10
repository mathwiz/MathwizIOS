package gui.awt.culwin.ch8

import java.awt.Dimension
import java.awt.FileDialog
import java.awt.Frame
import java.awt.Point
import java.awt.Window
import java.awt.event.ActionListener

class TuttleOpenDialog extends FileDialog {
    protected Window itsParentWindow
    protected ActionListener itsListener

    TuttleOpenDialog(Frame parentFrame, ActionListener listener) {
        super(parentFrame, "Tuttle Open", FileDialog.LOAD)
        itsParentWindow = parentFrame as Window
        itsListener = listener
    }

    @Override
    void setVisible(boolean showIt) {
        if (showIt) {
            Point itsParentsLocation = itsParentWindow.getLocationOnScreen()
            Dimension itsParentsSize = itsParentWindow.getSize()
            Dimension itsSize = this.getSize()
            Point itsLocation = new Point()

            itsLocation.x = itsParentsLocation.x + itsParentsSize.width/2 - itsSize.width/2
            itsLocation.y = itsParentsLocation.y + itsParentsSize.height/2 - itsSize.height/2
            setLocation(itsLocation)
        }
        super.setVisible(showIt)
    }

}
