package gui.awt.culwin.ch8

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleSaveDialog extends FileDialog {
    protected Window itsParentWindow
    protected ActionListener itsListener

    private String filename
    private String dirname

    TuttleSaveDialog(Frame parentFrame, ActionListener listener) {
        super(parentFrame, "Tuttle Save", FileDialog.SAVE)
        itsParentWindow = parentFrame as Window
        itsListener = listener
        setVisible(false)
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
                dirname = tempDirname
            }

            String tempFilename = getFile()
            if (tempFilename) {
                filename = tempFilename
                itsListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "save"))
            }
        }
        super.setVisible(false)
    }

    boolean isFilenameAvailable() {
        filename != null
    }

    String filenameIs() {
        filename
    }

    String dirnameIs() {
        dirname
    }

    String fullFilenameIs() {
        "${dirname}${filename}"
    }

    void setFullFilename(String path, String file) {
        dirname = path
        filename = file
    }

    void clearFullFilename() {
        dirname = null
        filename = null
    }
}
