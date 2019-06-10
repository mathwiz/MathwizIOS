package gui.awt.culwin.ch8

import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleOpenErrorDialog extends TuttleBaseDialog {
    TuttleOpenErrorDialog(Frame parentFrame, ActionListener listener) {
        super(parentFrame, listener, "Tuttle Open Error!")
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {

    }
}
