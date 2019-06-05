package gui.awt.culwin.ch6


import gui.awt.culwin.MessageCanvas

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class VersionDialog extends Dialog implements ActionListener {
    Window parentWindow
    Panel buttonPanel
    MessageCanvas messageCanvas
    Button okButton

    VersionDialog(Frame parentFrame, String message) {
        super(parentFrame, "Version", false)
        this.setFont(parent.getFont())
        this.setBackground(parent.getBackground())
        parentWindow = parent as Window

        messageCanvas = new MessageCanvas(message)
        messageCanvas.setBackground(Color.WHITE)

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


    @Override
    void actionPerformed(ActionEvent actionEvent) {
        this.setVisible(false)
    }
}
