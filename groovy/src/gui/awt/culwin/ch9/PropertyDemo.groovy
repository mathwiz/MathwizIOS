package gui.awt.culwin.ch9

import java.applet.Applet
import java.awt.Frame

class PropertyDemo extends Applet {
    OutputStream out = System.out

    void init() {
        System.getProperties().list(out)
    }

    static void main(String[] args) {
        Frame frame = new Frame("Property Demo")
        PropertyDemo demo = new PropertyDemo()
        demo.init()
        frame.add(demo, "Center")
        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
