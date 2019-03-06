package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.Tuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class SemiDirectTuttle extends Applet implements ActionListener {
    final static int STEPS = 25
    final static int TURN_SIZE = 15

    Tuttle theTuttle
    Label feedbackLabel = new Label()
    Panel feedbackPanel = new Panel()
    Panel tuttlePanel = new Panel()
    SemiDirectTuttleInterface theInterface

    void init() {
        this.setFont(new Font("TimesRoman", Font.PLAIN, 14))

        feedbackPanel.add(feedbackLabel)

        theTuttle = new Tuttle(this, 500, 500)
        tuttlePanel.add(theTuttle)

        theInterface = new SemiDirectTuttleInterface(this)

        this.setLayout(new BorderLayout())
        this.add(feedbackPanel, "North")
        this.add(tuttlePanel, "Center")
        this.add(theInterface, "South")

        this.feedback()
    }

    def feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }

    void actionPerformed(ActionEvent event) {
        def cmd = event.getActionCommand()
        println "Command: ${cmd}"

        if (cmd == "goForward") {
            theTuttle.forward(STEPS)
        } else if (cmd == "goBackward") {
            theTuttle.backward(STEPS)
        } else if (cmd == "turnLeft") {
            theTuttle.turnLeft(TURN_SIZE)
        } else if (cmd == "turnRight") {
            theTuttle.turnRight(TURN_SIZE)
        } else if (cmd == "clear") {
            theTuttle.clearTuttleArea()
        } else if (cmd == "reset") {
            theTuttle.resetTuttle()
        } else if (cmd == "clearAndReset") {
            theTuttle.clearAndReset()
        } else if (cmd == "penUp") {
            theTuttle.setPenUp()
        } else if (cmd == "penDown") {
            theTuttle.setPenDown()
        } else if (cmd == "backgroundRed") {
            theTuttle.setBackground(Color.RED)
        } else if (cmd == "backgroundBlue") {
            theTuttle.setBackground(Color.BLUE)
        } else if (cmd == "backgroundGreen") {
            theTuttle.setBackground(Color.GREEN)
        } else if (cmd == "backgroundYellow") {
            theTuttle.setBackground(Color.YELLOW)
        } else if (cmd == "backgroundWhite") {
            theTuttle.setBackground(Color.WHITE)
        } else if (cmd == "backgroundBlack") {
            theTuttle.setBackground(Color.BLACK)
        } else if (cmd == "foregroundRed") {
            theTuttle.setForeground(Color.RED)
        } else if (cmd == "foregroundBlue") {
            theTuttle.setForeground(Color.BLUE)
        } else if (cmd == "foregroundGreen") {
            theTuttle.setForeground(Color.GREEN)
        } else if (cmd == "foregroundYellow") {
            theTuttle.setForeground(Color.YELLOW)
        } else if (cmd == "foregroundWhite") {
            theTuttle.setForeground(Color.WHITE)
        } else if (cmd == "foregroundBlack") {
            theTuttle.setForeground(Color.BLACK)
        }

        this.feedback()
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
