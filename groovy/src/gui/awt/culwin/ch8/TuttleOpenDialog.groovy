package gui.awt.culwin.ch8

import java.awt.Dimension
import java.awt.FileDialog
import java.awt.Frame
import java.awt.Point
import java.awt.Window
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleOpenDialog extends FileDialog {
    protected Window itsParentWindow
    protected ActionListener itsListener

    private String openFilename
    private String openDirname

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

            setDirectory("")
            setFile("")
            super.setVisible(true)

            String tempDirname = getDirectory()
            if (tempDirname) {
                openDirname = tempDirname
            }

            String tempFilename = getFile()
            if (tempFilename) {
                openFilename = tempFilename
                itsListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "loadit"))
            }
        }
        super.setVisible(false)
    }

    boolean isFilenameAvailable() {
        openFilename != null
    }

    String filenameIs() {
        openFilename
    }

    String dirnameIs() {
        openDirname
    }

    String fullFilenameIs() {
        "${openDirname}/${openDirname}"
    }
}
