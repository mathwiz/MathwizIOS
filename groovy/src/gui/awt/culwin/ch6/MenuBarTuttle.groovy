package gui.awt.culwin.ch6


import gui.awt.culwin.c5.SemiDirectTuttleInterface
import gui.awt.culwin.tuttles.Tuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class MenuBarTuttle extends Applet implements ActionListener {
    final static int STEPS = 25
    final static int TURN_SIZE = 15

    Tuttle theTuttle
    Label feedbackLabel = new Label()
    Panel feedbackPanel = new Panel()
    Panel tuttlePanel = new Panel()
    Frame tuttleFrame = new Frame()
    MenuBarTuttleInterface theInterface

    ExitDialog exitDialog
    VersionDialog versionDialog
    MenuBarTuttleHelpDialog helpDialog

    void init() {

        tuttleFrame.setTitle("Menu Bar Tuttle Interface")
        tuttleFrame.setBackground(Color.WHITE)
        tuttleFrame.setFont(new Font("TimesRoman", Font.PLAIN, 16))

        feedbackPanel.add(feedbackLabel)

        theTuttle = new Tuttle(this, 500, 500)
        tuttlePanel.add(theTuttle)

        theInterface = new MenuBarTuttleInterface(tuttleFrame, this)
        initInterface(theInterface)

        tuttleFrame.add(feedbackPanel, "South")
        tuttleFrame.add(tuttlePanel, "Center")
        tuttleFrame.setSize(tuttleFrame.getPreferredSize())

        this.feedback()
        tuttleFrame.setVisible(true)

//        helpDialog
//        exitDialog
//        versionDialog
    }

    def initInterface(myInterface) {
        myInterface.setForegroundCheckmark("blue")
        myInterface.setBackgroundCheckmark("yellow")
        myInterface.setPenUpCheckmark(false)
    }

    def feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }

    void actionPerformed(ActionEvent event) {
        def cmd = event.getActionCommand()
        println "Command: ${cmd}"

        def arg = null

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
        } else if (cmd == "Exit ...") {
            arg = "please"
            if (arg == "show") {
                //todo show exit dialog
            } else if (arg == "please") {
                System.exit(0)
            }
        }

        this.feedback()
    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new MenuBarTuttle()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
