package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*

class CanvasExample extends Applet {
    Doodle doodle

    void init() {
        doodle = new Doodle(400, 300)

        this.setLayout(new FlowLayout())

        this.add(doodle)
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new CanvasExample()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
