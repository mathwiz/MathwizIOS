package gui.awt.culwin.ch9

import gui.awt.culwin.MessageCanvas

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ResourceExitDialog extends Dialog implements ActionListener {
    Window parentWindow
    ActionListener myListener
    Panel buttonPanel
    MessageCanvas messageCanvas
    Button yesButton, noButton
    ResourceBundle resources

    ResourceExitDialog(Frame parent, ActionListener listener) {
        super(parent, true)
        parentWindow = parent as Window
        myListener = listener

        this.setFont(parent.getFont())
        this.setBackground(parent.getBackground())

        resources = ResourceBundle.getBundle("ExitDialogResources")

        messageCanvas = new MessageCanvas(resources.getObject("exitDialogQuestion") as String)
        messageCanvas.setBackground(Color.WHITE)

        buttonPanel = new Panel()
        buttonPanel.setBackground(Color.WHITE)

        yesButton = new Button(resources.getObject("exitDialogYes") as String)
        yesButton.setActionCommand("yes")
        yesButton.addActionListener(this)
        buttonPanel.add(yesButton)

        noButton = new Button(resources.getObject("exitDialogNo") as String)
        noButton.setActionCommand("no")
        noButton.addActionListener(this)
        buttonPanel.add(noButton)

        this.setTitle(resources.getObject("exitDialogTitle") as String)
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

    @Override
    void actionPerformed(ActionEvent actionEvent) {
        this.setVisible(false)
        if (actionEvent.getActionCommand() == "yes") {
            myListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "exit please"))
        } else {
            println "OK not exiting..."
        }
    }
}
