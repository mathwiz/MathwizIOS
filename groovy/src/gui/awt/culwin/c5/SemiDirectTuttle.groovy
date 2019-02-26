package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.TuttleButton

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class SemiDirectTuttle extends Applet implements ActionListener {
    TuttleButton left
    TuttleButton right

    void init() {
        setBackground(Color.YELLOW)

        left = new TuttleButton("turtle-sm.gif", this)
        left.setActionCommand("Left Button")
        left.addActionListener(this)
        add(left)

        right = new TuttleButton("turtle-sm.gif", this, Color.RED)
        right.setActionCommand("Right Button")
        right.addActionListener(this)
        add(right)
    }

    void actionPerformed(ActionEvent event) {
        println "${event.actionCommand} pressed."
    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new SemiDirectTuttle()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
