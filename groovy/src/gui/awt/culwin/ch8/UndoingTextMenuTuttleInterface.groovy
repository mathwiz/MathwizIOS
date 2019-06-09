package gui.awt.culwin.ch8


import java.applet.Applet
import java.awt.*

class UndoingTextMenuTuttleInterface extends Panel {
    static final int TOP_LEVEL_MENU = 0
    static final int MOVE_MENU = 1
    static final int MOVE_FORWARD_MENU = 2
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
    static final int UNDO_MENU = 14

    private static final String topLevelMenu = "(M)ove (T)urn (C)olors (P)en (S)creen (H)elp (U)ndo (E)xit"
    private static final String moveMenu = "\n\tMove: (F)orwards (B)ackwards"
    private static final String moveForwardsMenu = "\n\t\tMove Forwards: 10 20 50"
    private static final String moveBackwardsMenu = "\n\t\tMove Backwards: 10 20 50"
    private static final String turnMenu = "\n\tTurn: (L)eft (R)ight"
    private static final String turnLeftMenu = "\n\t\tTurn Left: 5 45 90"
    private static final String turnRightMenu = "\n\t\tTurn Right: 5 45 90"
    private static final String colorMenu = "\n\tColors: (F)oreground (B)ackground"
    private static final String colorForegroundMenu = "\n\t\tColors Foreground: Blac(k) (W)hite (R)ed (G)reen (Y)ellow (B)lue"
    private static final String colorBackgroundMenu = "\n\t\tColors Background: Blac(k) (W)hite (R)ed (G)reen (Y)ellow (B)lue"
    private static final String penMenu = "\n\tPen: (U)p (D)own"
    private static final String screenMenu = "\n\tSCreen: (C)lear (R)eset Clear(A)ndReset"
    private static final String helpMenu = "\n\tHelp; (H)elp (V)ersion"
    private static final String exitMenu = "\n\tExit: (Y)es (N)o"
    private final String undoMenu = "\n\tUndo ${undoCommand}: (Y)es (N)o"

    private int menuState = TOP_LEVEL_MENU

    Applet sendToHere
    TextArea menuArea
    String undoCommand = ""

    UndoingTextMenuTuttleInterface(Applet myApplet) {
        sendToHere = myApplet
        menuArea = new TextArea(5, 60)
        menuArea.setEditable(false)
        menuArea.addKeyListener(sendToHere)
        this.add(menuArea)
    }

    void setUndoCommand(String cmd) {
        undoCommand = cmd
    }

    void setMenuState(int newState) {
        menuState = newState
        switch (menuState) {
            case TOP_LEVEL_MENU:
                menuArea.setText(topLevelMenu)
                break
            case MOVE_MENU:
                menuArea.setText(topLevelMenu + moveMenu)
                break
            case MOVE_BACKWARD_MENU:
                menuArea.setText(topLevelMenu + moveMenu + moveBackwardsMenu)
                break
            case MOVE_FORWARD_MENU:
                menuArea.setText(topLevelMenu + moveMenu + moveForwardsMenu)
                break
            case TURN_MENU:
                menuArea.setText(topLevelMenu + turnMenu)
                break
            case TURN_LEFT_MENU:
                menuArea.setText(topLevelMenu + turnMenu + turnLeftMenu)
                break
            case TURN_RIGHT_MENU:
                menuArea.setText(topLevelMenu + turnMenu + turnRightMenu)
                break
            case COLOR_MENU:
                menuArea.setText(topLevelMenu + colorMenu)
                break
            case FOREGROUND_COLOR_MENU:
                menuArea.setText(topLevelMenu + colorMenu + colorForegroundMenu)
                break
            case BACKGROUND_COLOR_MENU:
                menuArea.setText(topLevelMenu + colorMenu + colorBackgroundMenu)
                break
            case PEN_MENU:
                menuArea.setText(topLevelMenu + penMenu)
                break
            case SCREEN_MENU:
                menuArea.setText(topLevelMenu + screenMenu)
                break
            case HELP_MENU:
                menuArea.setText(topLevelMenu + helpMenu)
                break
            case EXIT_MENU:
                menuArea.setText(topLevelMenu + exitMenu)
                break
            case UNDO_MENU:
                if (undoCommand) {
                    menuArea.setText(topLevelMenu + undoMenu)
                } else {
                    menuArea.setText(topLevelMenu + "\n\tUndo is not available")
                }
                break
        }
    }

    int menuStateIs() {
        return menuState
    }
}
