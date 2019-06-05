package gui.awt.culwin.tuttles

import java.applet.Applet
import java.awt.*

class TextTuttle extends Tuttle {
    static final int UNKNOWN = -1
    static final int FORWARD = 0
    static final int BACKWARD = 1
    static final int TURN_RIGHT = 2
    static final int TURN_LEFT = 3
    static final int FOREGROUND = 4
    static final int BACKGROUND = 5
    static final int PEN_UP = 6
    static final int PEN_DOWN = 7
    static final int CLEAR = 8
    static final int RESET = 9
    static final int CLEAR_AND_RESET = 10
    static final int EXIT = 11
    static final int MAX_COMMANDS = 11

    private static final String[] commands = [
            "fd", "bd", "tr", "tl",
            "fg", "bd", "pu", "pd",
            "cl", "rs", "cr", "exit"
    ]

    TextTuttle(Applet applet, int width, int height) {
        super(applet, width, height)
    }

    String doCommand(String theCommand) {
        StringTokenizer tokenizer = new StringTokenizer(theCommand)
        String firstTerm = null
        String reply = null
        int thisCommand = UNKNOWN

        if (tokenizer.hasMoreTokens()) {
            firstTerm = tokenizer.nextToken().toLowerCase()
            thisCommand = identifyCommand(firstTerm)
            if (thisCommand == UNKNOWN) {
                reply = "The command ${firstTerm} is not known!"
            } else {
                reply = dispatchCommand(thisCommand, tokenizer)
            }
        } else {
            reply = "There does not seem to be a command given!"
        }

        return reply
    }

    String identifyCommand(String cmd) {
        int thisCommand = MAX_COMMANDS
        int identified = UNKNOWN
        while (identified == UNKNOWN && thisCommand != UNKNOWN) {
            if (cmd == commands[thisCommand]) {
                identified = thisCommand
            } else {
                thisCommand--
            }
        }
        return identified
    }

    String dispatchCommand(int commandId, StringTokenizer arguments) {
        StringBuffer response = new StringBuffer()
        boolean processed = false
        switch (commandId) {
            case FORWARD:
            case BACKWARD:
            case TURN_LEFT:
            case TURN_RIGHT:
                if (arguments.countTokens() == 1) {
                    int toStepOrTurn
                    try {
                        toStepOrTurn = Integer.parseInt(arguments.nextToken())
                        switch (commandId) {
                            case FORWARD:
                                this.forward(toStepOrTurn)
                                break
                            case BACKWARD:
                                this.backward(toStepOrTurn)
                                break
                            case TURN_LEFT:
                                this.turnLeft(toStepOrTurn)
                                break
                            case TURN_RIGHT:
                                this.turnRight(toStepOrTurn)
                                break
                        }
                        processed = true
                    } catch (NumberFormatException e) {
                        processed = false
                    }
                }
                if (!processed) {
                    response.append(commands[commandId])
                    response.append(" should be followed by a single number.")
                }
                break
            case PEN_DOWN:
            case PEN_UP:
            case RESET:
            case CLEAR:
            case CLEAR_AND_RESET:
                if (arguments.countTokens() == 0) {
                    switch (commandId) {
                        case PEN_UP:
                            this.setPenUp()
                            break
                        case PEN_DOWN:
                            this.setPenDown()
                            break
                        case RESET:
                            this.resetTuttle()
                            break
                        case CLEAR:
                            this.clearTuttleArea()
                            break
                        case CLEAR_AND_RESET:
                            this.clearAndReset()
                            break
                    }
                    processed = true
                }
                if (!processed) {
                    response.append(commands[commandId])
                    response.append(" should not be followed by anything.")
                }
                break
            case FOREGROUND:
            case BACKGROUND:
                if (arguments.countTokens() == 1) {
                    Color c = identifyColor(arguments.nextToken().toLowerCase())
                    if (c != null) {
                        if (commandId == FOREGROUND) {
                            this.setForeground(c)
                        } else {
                            this.setBackground(c)
                        }
                        processed = true
                    }
                }
                if (!processed) {
                    response.append(commands[commandId])
                    response.append(" should only be followed by")
                    response.append(" white, black, red, blue, green, or yellow.")
                }
                break
            default:
                response.append("What?")
        }

        return response.toString()
    }

    Color identifyColor(String color) {
        Color c = null
        if (color == "black") {
            c = Color.BLACK
        } else if (color == "white") {
            c = Color.WHITE
        } else if (color == "yellow") {
            c = Color.YELLOW
        } else if (color == "green") {
            c = Color.GREEN
        } else if (color == "red") {
            c = Color.RED
        } else if (color == "blue") {
            c = Color.BLUE
        }
        return c
    }
}
