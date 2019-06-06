package gui.awt.culwin.ch7

import gui.awt.culwin.tuttles.TuttleButton

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionListener
import java.util.List

class TextMenuTuttleInterface extends Panel {
    static final int TOP_LEVEL_MENU = 0
    static final int MOVE_MENU = 1
    static final int MOVE_FOREWARD_MENU = 2
    static final int MOVE_BACKWARD_MENU = 3
    static final int TURN_MENU = 4
    static final int TURN_LEFT_MENU = 5
    static final int TURN_RIGHT_MENU = 6
    static final int COLOR_MENU = 7
    static final int FOREGROUND_COLOR_MENU = 8
    static final int BACKGROUND_COLOR_MENU = 9
    static final int PEN_MENU = 10
    static final int SCREEN_MENU = 11
    static final int HELP_MENU = 12
    static final int EXIT_MENU = 13


    private int menuState = TOP_LEVEL_MENU

    Applet sendToHere
    TextArea menuArea

    TextMenuTuttleInterface(Applet myApplet) {
        sendToHere = myApplet
        menuArea = new TextArea(5, 60)
        menuArea.setEditable(false)
        menuArea.addKeyListener(sendToHere)
        this.add(menuArea)
    }

    void setMenuState(int newState) {
        menuState = newState

    }
}
