package gui.awt.culwin.ch8

import com.sun.javafx.util.Logging
import gui.awt.culwin.ch7.CommandLineTuttleInterface
import gui.awt.culwin.tuttles.BufferedTuttle
import gui.awt.culwin.tuttles.LoggingTuttle
import gui.awt.culwin.tuttles.TextTuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

class LoggingCommandLineTuttle extends Applet implements ActionListener, MouseListener {
    LoggingTuttle theTuttle
    Label feedbackLabel = new Label()
    Panel feedbackPanel = new Panel()
    Panel tuttlePanel = new Panel()
    CommandLineTuttleInterface theInterface

    void init() {
        this.setLayout(new BorderLayout())
        this.setFont(new Font("TimesRoman", Font.PLAIN, 14))
        this.setBackground(Color.WHITE)

        feedbackPanel.add(feedbackLabel)

        theTuttle = new LoggingTuttle(this, this, 500, 500)
        tuttlePanel.add(theTuttle)

        theInterface = new CommandLineTuttleInterface(this)

        this.add(feedbackPanel, "North")
        this.add(tuttlePanel, "Center")
        this.add(theInterface, "South")

        this.feedback()
        theInterface.clearCommandArea()
    }

    def feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }

    @Override
    void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.isControlDown()) {
            if (theTuttle.isLoggingActive()) {
                theTuttle.stopLogging()
            } else {
                theTuttle.startLogging()
            }
            this.feedback()
        }
    }

    @Override
    void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    void actionPerformed(ActionEvent event) {
        def cmd = event.getActionCommand()
        println "Action: ${cmd}"

        def (first, second) = cmd.tokenize(" ")

        def resp = ""
        switch (first) {
            case "help":
                theTuttle.logCommand(cmd)
                resp = obtainHelp(second)
                break
            case "exit":
                theTuttle.logCommand(cmd)
                resp = checkExit(second)
                break
            default:
                resp = theTuttle.doCommand(cmd)
        }

        theInterface.clearCommandArea()
        theInterface.appendFeedback("\n> ${cmd}")
        if (resp) {
            theInterface.appendFeedback("\n${resp}")
        }

        this.feedback()
    }

    def obtainHelp(String what) {
        def theHelp = ""

        if (what) {
            def helpFor = theTuttle.identifyCommand(what.toLowerCase())
            switch (helpFor) {
                case TextTuttle.FORWARD:
                    theHelp += "fd is Forward, followed by a number"
                    break
                case TextTuttle.BACKWARD:
                    theHelp += "bd is Backward, followed by a number"
                    break
                case TextTuttle.TURN_LEFT:
                    theHelp += "tl is Turn Left, followed by a number"
                    break
                case TextTuttle.TURN_RIGHT:
                    theHelp += "tr is Turn Right, followed by a number"
                    break
                case TextTuttle.BACKGROUND:
                    theHelp += "bg is Change Background, followed by a color"
                    break
                case TextTuttle.FOREGROUND:
                    theHelp += "fg is Change Foreground, followed by a color"
                    break
                case TextTuttle.PEN_DOWN:
                    theHelp += "pd is Pen Down"
                    break
                case TextTuttle.PEN_UP:
                    theHelp += "pu is Pen Up"
                    break
                case TextTuttle.CLEAR:
                    theHelp += "cl is Clear"
                    break
                case TextTuttle.CLEAR_AND_RESET:
                    theHelp += "cr is Clear and Reset"
                    break
                case TextTuttle.RESET:
                    theHelp += "rs is Reset"
                    break
                case TextTuttle.EXIT:
                    theHelp += "Use 'exit please'"
                    break
                case BufferedTuttle.UNDO:
                    theHelp += "undo reverses the last command"
                default:
                    theHelp += "Sorry that command is not valid."
            }
        } else {
            theHelp += "help is available for these commands: ${TextTuttle.commands}"
        }
        theHelp
    }

    def checkExit(String term) {
        if (term == "please") {
            if (theTuttle.isLoggingActive()) {
                theTuttle.stopLogging()
            }
            System.exit(0)
        }
        "Use 'exit please' to quit"
    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new LoggingCommandLineTuttle()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
