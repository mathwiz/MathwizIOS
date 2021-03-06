package gui.awt.culwin.ch8

import gui.awt.culwin.MessageCanvas

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleSaveErrorDialog extends TuttleBaseDialog {
    private Button okButton
    private Panel buttonPanel
    private MessageCanvas message

    TuttleSaveErrorDialog(Frame parentFrame, ActionListener listener) {
        super(parentFrame, listener, "Tuttle Save Error!")
        okButton = new Button("OK")
        okButton.addActionListener(this)
        buttonPanel = new Panel()
        buttonPanel.setBackground(Color.WHITE)
        buttonPanel.add(okButton)
        this.add(buttonPanel, "South")
        setVisible(false)
    }

    void setReason(String s) {
        message = new MessageCanvas(s)
        message.setBackground(Color.WHITE)
        this.add(message, "Center")
        this.pack()
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {
        setVisible(false)
        itsListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "saveas"))
    }
}
