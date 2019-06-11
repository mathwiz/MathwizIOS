package gui.awt.culwin.ch9

import java.applet.Applet
import java.awt.*

class DialogDemo extends Applet {
    OutputStream out = System.out

    void init() {
        Properties preset = System.getProperties()
        String lang = preset.getProperty("user.language")
        println "Language: ${lang}"
    }

    static void main(String[] args) {
        Frame frame = new Frame("Dialog Demo")
        DialogDemo demo = new DialogDemo()
        demo.init()
        frame.add(demo, "Center")
        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
