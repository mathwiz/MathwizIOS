package gui.awt.culwin.c3

import java.awt.BorderLayout
import java.awt.Button
import java.awt.Panel
import java.awt.TextArea

class StikNoteWindow {
    TextArea theMessage

    StikNoteWindow(StikNote applet) {
        Panel buttonPanel = new Panel()
        Button stikNoteButton = new Button("Post It")

        theMessage = new TextArea(10,20)

        stikNoteButton.addActionListener(applet)
        buttonPanel.add(stikNoteButton)

        applet.setLayout(new BorderLayout())
        applet.add(theMessage, "Center")
        applet.add(buttonPanel, "South")
    }

    String getMessage() {
        theMessage.getText().trim()
    }

    void clearMessage() {
        theMessage.setText("")
    }
}
