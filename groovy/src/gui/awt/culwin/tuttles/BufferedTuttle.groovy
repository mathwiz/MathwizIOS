package gui.awt.culwin.tuttles

import java.applet.Applet
import java.awt.*

class BufferedTuttle extends TextTuttle {
    static final int UNKNOWN = -1
    static final int CLEAR = 8
    static final int RESET = 9
    static final int CLEAR_AND_RESET = 10
    static final int EXIT = 11
    static final int UNDO = 12
    static final int LOAD = 13
    static final int SAVE = 14
    static final int SHOW = 15
    static final int MAX_COMMANDS = 15

    private boolean tuttleShowing
    private int startX
    private int startY
    private int startDirection
    private Color startForeground
    private Color startBackground
    private boolean startPenStatus
    private final def commandBuffer = []

    BufferedTuttle(Applet applet, int width, int height) {
        super(applet, width, height)
        this.storeTuttleStatus()
        this.showTuttle()
    }

    @Override
    void update(Graphics g) {
        if (tuttleShowing) {
            super.update(g)
        }
    }

    def tuttleLocationIs() {
        new Point(xLocation, yLocation)
    }

    def tuttleDirectionIs() {
        this.direction
    }

    def tuttleForegroundIs() {
        this.currentForeground
    }

    def tuttleBackgroundIs() {
        this.currentBackground
    }

    def tuttlePenStatusIs() {
        this.penDown
    }

    def isUndoAvailable() {
        !commandBuffer.isEmpty()
    }

    def whatUndoIsAvailable() {
        commandBuffer.join("|")
    }

    def clearAndReset(Color c) {
        setBackground(c)
        clearAndReset()
    }

    def hideTuttle() {
        tuttleShowing = false
    }

    def showTuttle() {
        tuttleShowing = true
    }

    def undo() {
        String reply = ""
        int numCommands = commandBuffer.size()
        if (numCommands > 0) {
            def last = commandBuffer.get(numCommands-1)
            commandBuffer.remove(numCommands-1)
            reply += "undo " + last
            hideTuttle()
            restoreTuttleStatus()
            for (int it = 0; it < commandBuffer.size(); it++) {
                super.doCommand(commandBuffer[it])
            }
            showTuttle()
        } else {
            reply += "Nothing to undo!"
        }
        reply
    }

    def showCommands() {
        whatUndoIsAvailable()
    }

    def save(StringTokenizer what) {
        "save called"
    }

    def load(StringTokenizer what) {
        "load called"
    }

    def storeTuttleStatus() {
        def p = tuttleLocationIs()
        startX = p.x
        startY = p.y
        startDirection = tuttleDirectionIs()
        startForeground = tuttleForegroundIs()
        startBackground = tuttleBackgroundIs()
        startPenStatus = tuttlePenStatusIs()
        commandBuffer.removeAll()
    }

    def restoreTuttleStatus() {
        setForeground(startForeground)
        clearAndReset(startBackground)
        setPenUp()
        turnRight(90)
        forward(startX)
        turnLeft(90)
        forward(startY)
        turnRight(startDirection)
        if (startPenStatus) {
            setPenDown()
        } else {
            setPenUp()
        }
    }

    String doCommand(String theCommand) {
        StringTokenizer tokenizer = new StringTokenizer(theCommand)
        String reply
        int thisCommand = UNKNOWN

        if (tokenizer.hasMoreTokens()) {
            String firstTerm = tokenizer.nextToken().toLowerCase()
            thisCommand = identifyCommand(firstTerm)
            println "Identified command ${thisCommand}"

            if (thisCommand == UNDO) {
                reply = undo()
            } else if (thisCommand == SAVE) {
                reply = save(tokenizer)
            } else if (thisCommand == LOAD) {
                reply = load(tokenizer)
            } else if (thisCommand == SHOW) {
                reply = showCommands()
            } else {
                reply = super.doCommand(theCommand)
            }
        } else {
            reply = "There does not seem to be a command given!"
        }

        if (!reply) {
            if (thisCommand == CLEAR_AND_RESET || thisCommand == CLEAR) {
                storeTuttleStatus()
            } else if (thisCommand != CLEAR && thisCommand != CLEAR_AND_RESET
                    && thisCommand != SAVE && thisCommand != LOAD
                    && thisCommand != SHOW) {
                commandBuffer.add(theCommand)
            }
        }

        messageState = reply
        return reply
    }

    int identifyCommand(String cmd) {
        if (cmd == "undo") {
            return UNDO
        } else if (cmd == "save") {
            return SAVE
        } else if (cmd == "load") {
            return LOAD
        } else if (cmd == "show") {
            return SHOW
        } else {
            return super.identifyCommand(cmd)
        }
    }
}
