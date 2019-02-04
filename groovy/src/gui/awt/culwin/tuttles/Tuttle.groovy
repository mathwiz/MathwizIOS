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
}
