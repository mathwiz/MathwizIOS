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

        if (menuState == TextMenuTuttleInterface.TOP_LEVEL_MENU) {
            newMenu = topLevelMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.MOVE_MENU) {
            newMenu = moveMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.MOVE_BACKWARD_MENU) {
            newMenu = moveBackwardMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.MOVE_FORWARD_MENU) {
            newMenu = moveForwardMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.TURN_MENU) {
            newMenu = turnMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.TURN_LEFT_MENU) {
            newMenu = turnLeftMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.TURN_RIGHT_MENU) {
            newMenu = turnRightMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.PEN_MENU) {
            newMenu = penMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.SCREEN_MENU) {
            newMenu = screenMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.HELP_MENU) {
            newMenu = helpMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.EXIT_MENU) {
            newMenu = exitMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.COLOR_MENU) {
            newMenu = colorMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.FOREGROUND_COLOR_MENU) {
            newMenu = moveForegroundColorMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.BACKGROUND_COLOR_MENU) {
            newMenu = moveBackgroundColorMenu(pressed)
        }

        theInterface.setMenuState(newMenu)
        this.feedback()
    }

    private static int topLevelMenu(char key) {
        Map<Character, Integer> menus = [
                'M': TextMenuTuttleInterface.MOVE_MENU,
                'm': TextMenuTuttleInterface.MOVE_MENU,
                'T': TextMenuTuttleInterface.TURN_MENU,
                't': TextMenuTuttleInterface.TURN_MENU,
                'C': TextMenuTuttleInterface.COLOR_MENU,
                'c': TextMenuTuttleInterface.COLOR_MENU,
                'P': TextMenuTuttleInterface.PEN_MENU,
                'p': TextMenuTuttleInterface.PEN_MENU,
                'S': TextMenuTuttleInterface.SCREEN_MENU,
                's': TextMenuTuttleInterface.SCREEN_MENU,
                'H': TextMenuTuttleInterface.HELP_MENU,
                'h': TextMenuTuttleInterface.HELP_MENU,
                'E': TextMenuTuttleInterface.EXIT_MENU,
                'e': TextMenuTuttleInterface.EXIT_MENU
        ]
        menus[key] ?: TextMenuTuttleInterface.TOP_LEVEL_MENU
    }

    private static int moveMenu(char key) {
        Map<Character, Integer> menus = [
                KeyEvent.VK_ESCAPE: TextMenuTuttleInterface.TOP_LEVEL_MENU,
                'F': TextMenuTuttleInterface.MOVE_FORWARD_MENU,
                'f': TextMenuTuttleInterface.MOVE_FORWARD_MENU,
                'B': TextMenuTuttleInterface.MOVE_BACKWARD_MENU,
                'b': TextMenuTuttleInterface.MOVE_BACKWARD_MENU
        ]
        menus[key] ?: TextMenuTuttleInterface.MOVE_MENU
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
