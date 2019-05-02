package gui.awt.culwin.ch6

import gui.awt.culwin.MessageCanvas

import javax.swing.Action
import java.awt.Button
import java.awt.Dialog
import java.awt.Frame
import java.awt.Panel
import java.awt.Window
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ExitDialog extends Dialog implements ActionListener {
    Window parentWindow
    ActionListener myListener
    Panel buttonPanel
    MessageCanvas messageCanvas
    Button yesButton, noButton

    protected ExitDialog(Frame parent, ActionListener listener) {
        super(parent, "Exit", true)
        this.setFont(parent.getFont())
        this.setBackground(parent.getBackground())
        parentWindow = parent as Window
        myListener = listener

        messageCanvas = new MessageCanvas(("Are you sure\n you want to exit?"))
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {

    }
}
