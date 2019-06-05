package gui.awt.culwin.ch6

import java.awt.Dialog
import java.awt.Dimension
import java.awt.Frame
import java.awt.Point
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class VersionDialog extends Dialog implements ActionListener {

    VersionDialog(Frame parentFrame, String message) {
        super(parentFrame, "Version", false)
    }

    void setVisible(boolean showIt) {
        Point loc = new Point()
        Point parentLoc = parentWindow.getLocationOnScreen()
        Dimension parentSize = parentWindow.getSize()
        if (showIt) {
            loc.x = parentLoc.x + parentSize.width / 2 - this.getSize().width / 2
            loc.y = parentLoc.y + parentSize.height / 2 - this.getSize().height / 2
            this.setLocation(loc)
        }
        super.setVisible(showIt)
    }


    @Override
    void actionPerformed(ActionEvent actionEvent) {

    }
}
