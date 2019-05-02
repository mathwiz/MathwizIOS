package gui.awt.culwin.ch6

import java.awt.Dialog
import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class VersionDialog extends Dialog implements ActionListener {

    VersionDialog(Frame parentFrame, String message) {
        super(parentFrame, "Version", false)
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {

    }
}
