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

    private static String identifyColorAsString(Color c) {
        if (c.equals(Color.BLACK)) {
            return "black"
        } else if (c.equals(Color.WHITE)) {
            return "white"
        } else if (c.equals(Color.RED)) {
            return "red"
        } else if (c.equals(Color.GREEN)) {
            return "green"
        } else if (c.equals(Color.YELLOW)) {
            return "yellow"
        } else if (c.equals(Color.BLUE)) {
            return "blue"
        } else {
            return "unknown color"
        }
    }

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
        commandBuffer.get(commandBuffer.size()-1)
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
        commandBuffer.join("|")
    }

    def save(String file) {
        String reply = ""
        try {
            def saveHere = new PrintWriter(new FileOutputStream(file))
            saveHere.println(identifyColorAsString(startBackground))
            saveHere.println("fg " + identifyColorAsString(startForeground))
            saveHere.println("pu")
            saveHere.println("tr 90")
            saveHere.println("fd " + startX)
            saveHere.println("tl 90")
            saveHere.println("fd " + startY)
            saveHere.println("tr " + startDirection)
            saveHere.println(startPenStatus ? "pd" : "pu")
            commandBuffer.each {
                saveHere.println(it)
            }
            saveHere.close()
        } catch (IOException e) {
            reply = "The drawing could not be saved: " + e.getMessage()
        }
        reply
    }

    def load(String file) {
        String reply = ""
        try {
            def saveHere = new PrintWriter(new FileOutputStream(file))
            saveHere.println(identifyColorAsString(startBackground))
            saveHere.println("fg " + identifyColorAsString(startForeground))
            saveHere.println("pu")
            saveHere.println("tr 90")
            saveHere.println("fd " + startX)
            saveHere.println("tl 90")
            saveHere.println("fd " + startY)
            saveHere.println("tr " + startDirection)
            saveHere.println(startPenStatus ? "pd" : "pu")
            commandBuffer.each {
                saveHere.println(it)
            }
            saveHere.close()
        } catch (IOException e) {
            reply = "The drawing could not be saved: " + e.getMessage()
        }
        reply
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
                if (tokenizer.countTokens() == 1) {
                    reply = save(tokenizer.nextToken())
                } else {
                    reply = "save must be followed by only a filename"
                }
            } else if (thisCommand == LOAD) {
                if (tokenizer.countTokens() == 1) {
                    reply = load(tokenizer.nextToken())
                } else {
                    reply = "load must be followed by only a filename"
                }
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
