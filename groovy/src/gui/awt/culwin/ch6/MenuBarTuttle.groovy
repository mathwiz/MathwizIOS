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
        exitDialog = new ExitDialog(tuttleFrame, this)
//        versionDialog
    }

    def initInterface(myInterface) {
        myInterface.setForegroundCheckmark("Blue")
        myInterface.setBackgroundCheckmark("Yellow")
        myInterface.setPenUpCheckmark(false)
    }

    def feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }

    void actionPerformed(ActionEvent event) {
        def input = event.getActionCommand()
        def tokenizer = new StringTokenizer(input)
        def cmd = tokenizer.nextToken()
        println "Command: ${cmd}"

        def arg1 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null
        println "Arg 1: ${arg1}"

        def arg2 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null
        println "Arg 2: ${arg2}"

        if (cmd == "Forward") {
            theTuttle.forward(arg1 as Integer)
        } else if (cmd == "Backward") {
            theTuttle.backward(arg1 as Integer)
        } else if (cmd == "Turn" && arg1 == "Left") {
            theTuttle.turnLeft(arg2 as Integer)
        } else if (cmd == "Turn" && arg1 == "Right") {
            theTuttle.turnRight(arg2 as Integer)
        } else if (cmd == "Screen" && arg1 == "Clear" && arg2 == "and") {
            theTuttle.clearAndReset()
        } else if (cmd == "Screen" && arg1 == "Clear") {
            theTuttle.clearTuttleArea()
        } else if (cmd == "Screen" && arg1 == "Reset") {
            theTuttle.resetTuttle()
        } else if (cmd == "Screen" && arg1 == "Pen" && arg2 == "Up") {
            theTuttle.setPenUp()
        } else if (cmd == "Screen" && arg1 == "Pen" && arg2 == "Down") {
            theTuttle.setPenDown()
        } else if (cmd == "Background" && arg1 == "Red") {
            theTuttle.setBackground(Color.RED)
        } else if (cmd == "Background" && arg1 == "Blue") {
            theTuttle.setBackground(Color.BLUE)
        } else if (cmd == "Background" && arg1 == "Green") {
            theTuttle.setBackground(Color.GREEN)
        } else if (cmd == "Background" && arg1 == "Yellow") {
            theTuttle.setBackground(Color.YELLOW)
        } else if (cmd == "Background" && arg1 == "White") {
            theTuttle.setBackground(Color.WHITE)
        } else if (cmd == "Background" && arg1 == "Black") {
            theTuttle.setBackground(Color.BLACK)
        } else if (cmd == "Foreground" && arg1 == "Red") {
            theTuttle.setForeground(Color.RED)
        } else if (cmd == "Foreground" && arg1 == "Blue") {
            theTuttle.setForeground(Color.BLUE)
        } else if (cmd == "Foreground" && arg1 == "Green") {
            theTuttle.setForeground(Color.GREEN)
        } else if (cmd == "Foreground" && arg1 == "Yellow") {
            theTuttle.setForeground(Color.YELLOW)
        } else if (cmd == "Foreground" && arg1 == "White") {
            theTuttle.setForeground(Color.WHITE)
        } else if (cmd == "Foreground" && arg1 == "Black") {
            theTuttle.setForeground(Color.BLACK)
        } else if (cmd == "File") {
            if (arg1 == "Exit") {
                println "showing exit dialog"
                exitDialog.setVisible(true)
            }
        } else if (cmd == "exit") {
            if (arg1 == "please") {
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
