package gui.awt.culwin.ch7


import java.applet.Applet
import java.awt.*
import java.awt.event.ActionListener

class CommandLineTuttleInterface extends Panel {

    ActionListener sendToHere
    TextArea commandFeedback
    TextField commandArea

    CommandLineTuttleInterface(Applet myApplet) {
        sendToHere = myApplet
        commandFeedback = new TextArea(6, 60)
        commandFeedback.setEditable(false)

        commandArea = new TextField(60)
        commandArea.addActionListener(sendToHere)

        this.add(commandFeedback, "Center")
        this.add(commandArea, "South")
    }

    def clearCommandArea() {
        commandArea.setText("")
    }

    def appendFeedback(toAppend) {
        commandFeedback.append(toAppend)
    }

}
