package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*

class ScrollPaneExample extends Applet {
    Doodle doodle
    ScrollPane scrollPane

    void init() {
        doodle = new CrossDoodle(500, 550)
        scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS)
        scrollPane.setSize(400, 300)
        scrollPane.add(doodle)

        this.setLayout(new FlowLayout())

        this.add(scrollPane)
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new ScrollPaneExample()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
