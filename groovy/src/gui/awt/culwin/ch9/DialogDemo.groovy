package gui.awt.culwin.ch9

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class DialogDemo extends Applet {
    OutputStream out = System.out
    ResourceExitDialog dialog

    void init() {
        Properties preset = System.getProperties()
        String lang = preset.getProperty("user.language")
        println "Language: ${lang}"
    }

    def makeListener() {
        new ActionListener() {
            @Override
            void actionPerformed(ActionEvent actionEvent) {
                String cmd = actionEvent.getActionCommand()
                println "Received ${cmd}"
                if (cmd == "yes") {
                    dialog.setVisible(false)
                } else if (cmd == "no") {
                    dialog.setTitle("No pressed")
                }
            }
        }
    }

    static void main(String[] args) {
        Frame frame = new Frame("Dialog Demo")
        DialogDemo demo = new DialogDemo()
        demo.init()
        frame.add(demo, "Center")
        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())

        demo.dialog = new ResourceExitDialog(frame, demo.makeListener())
        demo.dialog.setVisible(true)
    }
}
