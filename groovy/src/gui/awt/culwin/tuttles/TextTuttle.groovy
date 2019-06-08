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

    public static final String[] commands = [
            "fd", "bd", "tr", "tl",
            "fg", "bg", "pu", "pd",
            "cl", "rs", "cr", "exit"
    ]

    String messageState

    TextTuttle(Applet applet, int width, int height) {
        super(applet, width, height)
    }

    String getDetails() {
        super.getDetails() + " Memo: ${messageState}"
    }

    String doCommand(String theCommand) {
        println "Received command ${theCommand}"
        StringTokenizer tokenizer = new StringTokenizer(theCommand)
        String firstTerm
        String reply
        int thisCommand

        if (tokenizer.hasMoreTokens()) {
            firstTerm = tokenizer.nextToken().toLowerCase()
            thisCommand = identifyCommand(firstTerm)
            println "Identified command ${thisCommand}"

            if (thisCommand == UNKNOWN) {
                reply = "The command ${firstTerm} is not known!"
            } else {
                reply = dispatchCommand(thisCommand, tokenizer)
            }
        } else {
            reply = "There does not seem to be a command given!"
        }

        messageState = reply
        return reply
    }

    int identifyCommand(String cmd) {
        println "Identifying ${cmd}"
        int thisCommand = MAX_COMMANDS
        int identified = UNKNOWN
        while (identified == UNKNOWN && thisCommand != UNKNOWN) {
            if (cmd == commands[thisCommand]) {
                identified = thisCommand
            } else {
                thisCommand--
            }
        }
        println "Identified command ${identified}"
        identified
    }

    def dispatchCommand(int commandId, StringTokenizer arguments) {
        def resp = ""
        def processed = false
        println "dispatchCommand received: ${commandId}"
        switch (commandId) {
            case FORWARD:
            case BACKWARD:
            case TURN_LEFT:
            case TURN_RIGHT:
                if (arguments.countTokens() == 1) {
                    int toStepOrTurn
                    try {
                        toStepOrTurn = Integer.parseInt(arguments.nextToken())
                        println "toSTepOrTurn ${toStepOrTurn}"
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
                    resp += commands[commandId]
                    resp += (" should be followed by a single number.")
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
                    resp += (commands[commandId])
                    resp += (" should not be followed by anything.")
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
                    resp += (commands[commandId])
                    resp += (" should only be followed by")
                    resp += (" white, black, red, blue, green, or yellow.")
                }
                break
            default:
                resp += ("What?")
        }

        println "dispatchCommand returning message ${resp}"
        resp
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
