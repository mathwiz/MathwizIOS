package gui.awt.culwin.ch7

import gui.awt.culwin.tuttles.TextTuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent

class CommandLineTuttle extends Applet implements ActionListener {
    TextTuttle theTuttle
    Label feedbackLabel = new Label()
    Panel feedbackPanel = new Panel()
    Panel tuttlePanel = new Panel()
    CommandLineTuttleInterface theInterface

    void init() {
        this.setLayout(new BorderLayout())
        this.setFont(new Font("TimesRoman", Font.PLAIN, 14))
        this.setBackground(Color.WHITE)

        feedbackPanel.add(feedbackLabel)

        theTuttle = new TextTuttle(this, 500, 500)
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
    void actionPerformed(ActionEvent event) {
        def cmd = event.getActionCommand()
        println "Action: ${cmd}"

        def (first, second) = cmd.tokenize(" ")

        def resp = ""
        switch (first) {
            case "help":
                resp = obtainHelp(second)
                break
            case "exit":
                resp = checkExit(second)
                break
        }

        theInterface.appendFeedback("\n> ${cmd}")
        if (resp) {
            theInterface.appendFeedback("\n${ resp}")
        }
        this.feedback()
    }

    def obtainHelp(aString) {

    }

    def checkExit(aString) {

    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new CommandLineTuttle()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
