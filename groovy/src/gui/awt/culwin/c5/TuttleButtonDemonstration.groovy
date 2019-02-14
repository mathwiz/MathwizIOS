package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.TuttleButton
import org.fusesource.jansi.Ansi

import java.applet.Applet
import java.awt.Color
import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleButtonDemonstration extends Applet implements ActionListener {

    void init() {
        setBackground(Color.YELLOW)

        TuttleButton left = new TuttleButton("block-tuttle.gif", this)
        left.setActionCommand("Left Button")
        left.addActionListener(this)
        add(left)

        TuttleButton right = new TuttleButton("block-tuttle.gif", this)
        right.setActionCommand("Right Button")
        right.addActionListener(this)
        add(right)
    }

    void actionPerformed(ActionEvent event) {
        println "${event.actionCommand} pressed."
    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new TuttleButtonDemonstration()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
