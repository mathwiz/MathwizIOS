package gui.awt.culwin.ch7

import gui.awt.culwin.tuttles.TextTuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class TextMenuTuttle extends Applet implements KeyListener {
    final static int STEPS = 25
    final static int TURN_SIZE = 15

    TextTuttle theTuttle
    Label feedbackLabel = new Label()
    Panel feedbackPanel = new Panel()
    Panel tuttlePanel = new Panel()
    TextMenuTuttleInterface theInterface

    void init() {
        this.setLayout(new BorderLayout())
        this.setFont(new Font("TimesRoman", Font.PLAIN, 14))
        this.setBackground(Color.WHITE)

        feedbackPanel.add(feedbackLabel)

        theTuttle = new TextTuttle(this, 500, 500)
        tuttlePanel.add(theTuttle)

        theInterface = new TextMenuTuttleInterface(this)

        this.setLayout(new BorderLayout())
        this.add(feedbackPanel, "North")
        this.add(tuttlePanel, "Center")
        this.add(theInterface, "South")

        this.feedback()
        theInterface.setMenuState(TextMenuTuttleInterface.TOP_LEVEL_MENU)
    }

    def feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }


    @Override
    void keyPressed(KeyEvent keyEvent) {
        char pressed = event.getKeyChar()
        println "Key pressed: ${pressed}"
    }

    @Override
    void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    void keyTyped(KeyEvent event) {
        char pressed = event.getKeyChar()
        int newMenu = TextMenuTuttleInterface.TOP_LEVEL_MENU
        int menuState = theInterface.menuStateIs()

        if (menuState == "goForward") {
            theTuttle.forward(STEPS)
        } else if (menuState == "goBackward") {
            theTuttle.backward(STEPS)
        } else if (menuState == "turnLeft") {
            theTuttle.turnLeft(TURN_SIZE)
        } else if (menuState == "turnRight") {
            theTuttle.turnRight(TURN_SIZE)
        } else if (menuState == "clear") {
            theTuttle.clearTuttleArea()
        } else if (menuState == "reset") {
            theTuttle.resetTuttle()
        } else if (menuState == "clearAndReset") {
            theTuttle.clearAndReset()
        } else if (menuState == "penUp") {
            theTuttle.setPenUp()
        } else if (menuState == "penDown") {
            theTuttle.setPenDown()
        } else if (menuState == "backgroundRed") {
            theTuttle.setBackground(Color.RED)
        } else if (menuState == "backgroundBlue") {
            theTuttle.setBackground(Color.BLUE)
        } else if (menuState == "backgroundGreen") {
            theTuttle.setBackground(Color.GREEN)
        } else if (menuState == "backgroundYellow") {
            theTuttle.setBackground(Color.YELLOW)
        } else if (menuState == "backgroundWhite") {
            theTuttle.setBackground(Color.WHITE)
        } else if (menuState == "backgroundBlack") {
            theTuttle.setBackground(Color.BLACK)
        } else if (menuState == "foregroundRed") {
            theTuttle.setForeground(Color.RED)
        } else if (menuState == "foregroundBlue") {
            theTuttle.setForeground(Color.BLUE)
        } else if (menuState == "foregroundGreen") {
            theTuttle.setForeground(Color.GREEN)
        } else if (menuState == "foregroundYellow") {
            theTuttle.setForeground(Color.YELLOW)
        } else if (menuState == "foregroundWhite") {
            theTuttle.setForeground(Color.WHITE)
        } else if (menuState == "foregroundBlack") {
            theTuttle.setForeground(Color.BLACK)
        }

        this.feedback()
    }

    static void main(String[] args) {
        def frame = new Frame("Demonstration")
        def theInterface = new TextMenuTuttle()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
