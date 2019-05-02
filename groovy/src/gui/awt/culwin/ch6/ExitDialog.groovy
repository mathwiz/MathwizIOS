package gui.awt.culwin.ch6

import gui.awt.culwin.MessageCanvas

import java.awt.Button
import java.awt.Color
import java.awt.Dialog
import java.awt.Dimension
import java.awt.Frame
import java.awt.Panel
import java.awt.Point
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
        messageCanvas.setBackground(Color.WHITE)

        yesButton = new Button("yes")
        yesButton.setActionCommand("yes")
        yesButton.addActionListener(this)
        buttonPanel.add(yesButton)

        noButton = new Button("no")
        noButton.setActionCommand("no")
        noButton.addActionListener(this)
        buttonPanel.add(noButton)

        this.add(messageCanvas, "Center")
        this.add(buttonPanel, "South")
        this.pack()
    }

    void setVisible(boolean showIt) {
        Point loc = new Point()
        Point parentLoc = parentWindow.getLocationOnScreen()
        Dimension parentSize = parentWindow.getSize()
        if (showIt) {
            loc.x = parentLoc.x + parentSize.width/2 - this.getSize().width/2
            loc.y = parentLoc.y + parentSize.height/2 - this.getSize().height/2
        }
        super.setVisible(showIt)
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {

    }
}
