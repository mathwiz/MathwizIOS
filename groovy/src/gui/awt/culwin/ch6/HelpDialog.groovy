package gui.awt.culwin.ch6

import gui.awt.culwin.MessageCanvas

import java.awt.Button
import java.awt.Dialog
import java.awt.Dimension
import java.awt.Frame
import java.awt.Panel
import java.awt.Point
import java.awt.Window
import java.awt.event.ActionListener

class HelpDialog extends Dialog {
    Window parentWindow
    ActionListener myListener
    Panel buttonPanel
    Button yesButton, noButton


    HelpDialog(Frame frame, ActionListener listener) {
        super(frame, "Help", false)
        this.setFont(parent.getFont())
        this.setBackground(parent.getBackground())
        parentWindow = parent as Window
        myListener = listener


        buttonPanel = new Panel()
        buttonPanel.setBackground(Color.WHITE)

        okButton = new Button("ok")
        okButton.setActionCommand("ok")
        okButton.addActionListener(this)
        buttonPanel.add(okButton)

        this.add(messageCanvas, "Center")
        this.add(buttonPanel, "South")
        this.pack()
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
}
