package gui.awt.culwin.ch7

import gui.awt.culwin.tuttles.TextTuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class TextMenuTuttle extends Applet implements KeyListener {
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
    }

    @Override
    void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    void keyTyped(KeyEvent event) {
        char pressed = event.getKeyChar()
        println "Key typed: ${pressed}"

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
            newMenu = foregroundColorMenu(pressed)
        } else if (menuState == TextMenuTuttleInterface.BACKGROUND_COLOR_MENU) {
            newMenu = backgroundColorMenu(pressed)
        }

        println "New menu is ${newMenu}"
        theInterface.setMenuState(newMenu)
        this.feedback()
    }

    private static int topLevelMenu(char c) {
        char key = Character.toLowerCase(c)
        int newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
        switch (key) {
            case 'm':
                newMenuState = TextMenuTuttleInterface.MOVE_MENU
                break
            case 't':
                newMenuState = TextMenuTuttleInterface.TURN_MENU
                break
            case 'c':
                newMenuState = TextMenuTuttleInterface.COLOR_MENU
                break
            case 'p':
                newMenuState = TextMenuTuttleInterface.PEN_MENU
                break
            case 's':
                newMenuState = TextMenuTuttleInterface.SCREEN_MENU
                break
            case 'h':
                newMenuState = TextMenuTuttleInterface.HELP_MENU
                break
            case 'e':
                newMenuState = TextMenuTuttleInterface.EXIT_MENU
                break
        }
        newMenuState
    }

    private static int moveMenu(char c) {
        char key = Character.toLowerCase(c)
        int newMenuState = TextMenuTuttleInterface.MOVE_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'f':
                newMenuState = TextMenuTuttleInterface.MOVE_FORWARD_MENU
                break
            case 'b':
                newMenuState = TextMenuTuttleInterface.MOVE_BACKWARD_MENU
        }
        newMenuState
    }

    int moveForwardMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.MOVE_FORWARD_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.MOVE_MENU
                break
            case '1':
                theTuttle.doCommand("fd 10")
                break
            case '2':
                theTuttle.doCommand("fd 20")
                break
            case '5':
                theTuttle.doCommand("fd 50")
                break
        }
        this.feedback()
        newMenuState
    }

    int moveBackwardMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.MOVE_BACKWARD_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.MOVE_MENU
                break
            case '1':
                theTuttle.doCommand("bd 10")
                break
            case '2':
                theTuttle.doCommand("bd 20")
                break
            case '5':
                theTuttle.doCommand("bd 50")
                break
        }
        this.feedback()
        newMenuState
    }

    private static int turnMenu(char c) {
        char key = Character.toLowerCase(c)
        int newMenuState = TextMenuTuttleInterface.TURN_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'l':
                newMenuState = TextMenuTuttleInterface.TURN_LEFT_MENU
                break
            case 'r':
                newMenuState = TextMenuTuttleInterface.TURN_RIGHT_MENU
                break
        }
        newMenuState
    }

    int turnLeftMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.TURN_LEFT_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TURN_MENU
                break
            case '5':
                theTuttle.doCommand("tl 5")
                break
            case '4':
                theTuttle.doCommand("tl 45")
                break
            case '9':
                theTuttle.doCommand("tl 90")
                break
        }
        this.feedback()
        newMenuState
    }

    int turnRightMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.TURN_RIGHT_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TURN_MENU
                break
            case '5':
                theTuttle.doCommand("tr 5")
                break
            case '4':
                theTuttle.doCommand("tr 45")
                break
            case '9':
                theTuttle.doCommand("tr 90")
                break
        }
        this.feedback()
        newMenuState
    }

    private static int colorMenu(char c) {
        char key = Character.toLowerCase(c)
        int newMenuState = TextMenuTuttleInterface.COLOR_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'b':
                newMenuState = TextMenuTuttleInterface.BACKGROUND_COLOR_MENU
                break
            case 'f':
                newMenuState = TextMenuTuttleInterface.FOREGROUND_COLOR_MENU
                break
        }
        newMenuState
    }

    int backgroundColorMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.BACKGROUND_COLOR_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.COLOR_MENU
                break
            case 'K':
            case 'k':
                theTuttle.doCommand("bg black")
                break
            case 'W':
            case 'w':
                theTuttle.doCommand("bg white")
                break
            case 'R':
            case 'r':
                theTuttle.doCommand("bg red")
                break
            case 'G':
            case 'g':
                theTuttle.doCommand("bg green")
                break
            case 'Y':
            case 'y':
                theTuttle.doCommand("bg yellow")
                break
            case 'B':
            case 'b':
                theTuttle.doCommand("bg blue")
                break
        }
        this.feedback()
        newMenuState
    }

    int foregroundColorMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.FOREGROUND_COLOR_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.COLOR_MENU
                break
            case 'K':
            case 'k':
                theTuttle.doCommand("fg black")
                break
            case 'W':
            case 'w':
                theTuttle.doCommand("fg white")
                break
            case 'R':
            case 'r':
                theTuttle.doCommand("fg red")
                break
            case 'G':
            case 'g':
                theTuttle.doCommand("fg green")
                break
            case 'Y':
            case 'y':
                theTuttle.doCommand("fg yellow")
                break
            case 'B':
            case 'b':
                theTuttle.doCommand("fg blue")
                break
        }
        this.feedback()
        newMenuState
    }

    int penMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.PEN_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'U':
            case 'u':
                theTuttle.doCommand("pu")
                break
            case 'D':
            case 'd':
                theTuttle.doCommand("pd")
                break
        }
        this.feedback()
        newMenuState
    }

    int screenMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.SCREEN_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'C':
            case 'c':
                theTuttle.doCommand("cl")
                break
            case 'R':
            case 'r':
                theTuttle.doCommand("rs")
                break
            case 'A':
            case 'a':
                theTuttle.doCommand("cr")
                break
        }
        this.feedback()
        newMenuState
    }

    int helpMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.HELP_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'H':
            case 'h':
                println "Show Help"
                break
            case 'V':
            case 'v':
                println "Show Version"
                break
        }
        this.feedback()
        newMenuState
    }

    int exitMenu(char key) {
        int newMenuState = TextMenuTuttleInterface.EXIT_MENU
        switch (key) {
            case (KeyEvent.VK_ESCAPE):
            case '~':
            case 'N':
            case 'n':
                newMenuState = TextMenuTuttleInterface.TOP_LEVEL_MENU
                break
            case 'Y':
            case 'y':
                System.exit(0)
                break
        }
        this.feedback()
        newMenuState
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
