package gui.awt.culwin.tuttles

import java.applet.Applet
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

class Tuttle extends Canvas {
    private static final int SCREEN_STEPS = 500

    Image tuttleImage, theCursor
    Graphics tuttleGraphics
    TuttleCursor rotatingCursor
    Applet myApplet
    int xLocation
    int yLocation
    int direction
    int screenX
    int screenY
    int screenWidth
    int screenHeight
    double horizontalScale
    double verticalScale
    boolean penDown = true
    Color currentForeground = Color.BLUE
    Color currentBackground = Color.YELLOW

    Tuttle(Applet applet, int width, int height) {
        setSize(width, height)
        myApplet = applet
    }

    void addNotify() {
        super.addNotify()
        initializeTuttle()
        initializeCursor()
    }

    void initializeTuttle() {
        screenWidth = getSize().width
        screenHeight = getSize().height
        tuttleImage = createImage(screenWidth, screenHeight)
        tuttleGraphics = tuttleImage.getGraphics()
        tuttleGraphics.setColor(currentBackground)
        tuttleGraphics.fillRect(0, 0, screenWidth, screenHeight)
        tuttleGraphics.setColor(currentForeground)
        tuttleGraphics.translate(Math.floorDiv(screenWidth, 2), Math.floorDiv(screenHeight, 2))
        horizontalScale = screenWidth / (SCREEN_STEPS * 2)
        verticalScale = screenHeight / (SCREEN_STEPS * 2)
    }

    void initializeCursor() {

    }

    void update(Graphics g) {
        paint(g)
    }

    void paint(Graphics g) {
        g.drawImage(tuttleImage, 0, 0, this)
        int cursorCenterX = calcCursorPos(screenWidth)
        int cursorCenterY = calcCursorPos(screenHeight)
        g.drawImage(theCursor, cursorCenterX, cursorCenterY, this)
    }

    void forward(int steps) {

    }

    void backward(int steps) {

    }

    void turnRight(int degrees) {

    }

    void turnLeft(int degrees) {

    }

    void clearTuttleArea() {

    }

    void resetTuttle() {

    }

    void setForeground(Color c) {

    }

    void setBackground(Color c) {

    }

    void setPenUp() {

    }

    void setPenDown() {

    }

    String getPenState() {
        penDown ? "pen down" : "pen up"
    }

    String getDetails() {
        "X: ${xLocation}  Y: ${yLocation}  D: ${direction}  ${penState}"
    }

    private int calcCursorPos(int screenLocation) {
        (Math.floorDiv(screenLocation, 2) + screenX) -
                Math.floorDiv(theCursor.getWidth(this), 2)
    }
}
