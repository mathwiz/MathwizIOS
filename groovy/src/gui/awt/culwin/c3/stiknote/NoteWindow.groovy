package gui.awt.culwin.c3.stiknote

import gui.awt.culwin.MessageCanvas

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class NoteWindow extends Frame implements ActionListener {
    Button dismissButton
    Panel buttonPanel

    MessageCanvas postedMessage

    Point parentLocation
    Dimension parentSize
    Point myLocation
    Dimension mySize

    NoteWindow(String contents, Component parent) {
        setTitle("Stik Note")
        setFont(parent.getFont())
        setBackground(parent.getBackground())
        setForeground(parent.getForeground())

        postedMessage = new MessageCanvas(contents)
        add(postedMessage, "Center")

        dismissButton = new Button("OK")
        dismissButton.addActionListener(this)

        buttonPanel = new Panel()
        buttonPanel.add(dismissButton)
        add(buttonPanel, "South")
        pack()

        parentLocation = parent.getLocationOnScreen()
        parentSize = parent.getSize()
        mySize = getSize()
        myLocation = new Point()
        myLocation.x = intValue(parentLocation.x + parentSize.width / 2 - mySize.width / 2)
        myLocation.y = intValue(parentLocation.y + parentSize.height / 2 - mySize.height / 2)

        setLocation(myLocation)
        setVisible(true)
    }

    private int intValue(x) {
        Math.round(x).intValue()
    }

    @Override
    void actionPerformed(ActionEvent e) {
        dispose()
    }
}
