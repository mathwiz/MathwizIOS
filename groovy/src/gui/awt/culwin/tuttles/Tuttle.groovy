package gui.awt.culwin.tuttles

import javax.imageio.ImageIO
import java.applet.Applet
import java.awt.*
import java.awt.image.MemoryImageSource
import java.awt.image.PixelGrabber

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
        horizontalScale = screenWidth / (SCREEN_STEPS * 2) as double
        verticalScale = screenHeight / (SCREEN_STEPS * 2) as double
    }

    void initializeCursor() {
        def imageFile = this.class.getClassLoader().getResource("gui/awt/culwin/tuttles/turtle-sm.gif")
        theCursor = ImageIO.read(imageFile)

        if (theCursor == null ||
                theCursor.getWidth(this) < 1 ||
                theCursor.getHeight(this) < 1) {
            println "Empty image...exiting"
            System.exit(-1)
        }

        rotatingCursor = new TuttleCursor(theCursor, this)
        rotatingCursor.setCursorColor(currentForeground)
        theCursor = rotatingCursor.rotate(direction)
    }

    void update(Graphics g) {
        paint(g)
    }

    void paint(Graphics g) {
        g.drawImage(tuttleImage, 0, 0, this)
        int cursorCenterX = (Math.floorDiv(screenWidth, 2) + screenX) -
                Math.floorDiv(theCursor.getWidth(this), 2)
        int cursorCenterY = (Math.floorDiv(screenHeight, 2) + screenY) -
                Math.floorDiv(theCursor.getHeight(this), 2)
        g.drawImage(theCursor, cursorCenterX + screenX, cursorCenterY + screenY, this)
    }

    void forward(int steps) {
        int localDegrees = (direction + 270) % 360
        double radians = localDegrees / 180 * Math.PI
        int possibleNewX = xLocation + Math.round(Math.cos(radians) * steps)
        int possibleNewY = yLocation + Math.round(Math.sin(radians) * steps)

        if (possibleNewX >= -SCREEN_STEPS && possibleNewX <= SCREEN_STEPS &&
                possibleNewY >= -SCREEN_STEPS && possibleNewY <= SCREEN_STEPS) {
            int newX = Math.round(possibleNewX * horizontalScale)
            int newY = Math.round(possibleNewY * verticalScale)
            if (penDown) {
                tuttleGraphics.drawLine(screenX, screenY, newX, newY)
            }

            xLocation = possibleNewX
            yLocation = possibleNewY
            screenX = newX
            screenY = newY

            repaint()
        }
    }

    void backward(int steps) {
        forward(-steps)
    }

    void turnRight(int degrees) {
        direction += degrees
        while (direction < 360) {
            direction += 360
        }
        direction %= 360
        theCursor = rotatingCursor.rotate(direction)
        repaint()
    }

    void turnLeft(int degrees) {
        turnRight(-degrees)
    }

    void clearTuttleArea() {
        tuttleGraphics.setColor(currentBackground)
        tuttleGraphics.fillRect(
                -Math.floorDiv(screenWidth, 2),
                -Math.floorDiv(screenHeight, 2),
                screenWidth,
                screenHeight)
        tuttleGraphics.setColor(currentForeground)
        repaint()
    }

    void resetTuttle() {
        xLocation = 0
        yLocation = 0
        screenX = 0
        screenY = 0
        direction = 0
        theCursor = rotatingCursor.rotate(direction)
        repaint()
    }

    void clearAndReset() {
        resetTuttle()
        clearTuttleArea()
    }

    void setForeground(Color c) {
        currentForeground = c
        tuttleGraphics.setColor(c)
        rotatingCursor.setCursorColor(c)
        theCursor = rotatingCursor.rotate(direction)
        repaint()
    }

    void setBackground(Color c) {
        int[] pixels = new int[screenHeight * screenWidth]
        final int transparentMask = 0xFF000000
        final int newColorMask =
                transparentMask | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue()
        final int oldColorMask =
                transparentMask | (currentBackground.getRed() << 16) |
                        (currentBackground.getGreen() << 8) | currentBackground.getBlue()

        Image newImage = createImage(tuttleImage.getSource())
        PixelGrabber grabber = new PixelGrabber(newImage, 0, 0, screenWidth, screenHeight, pixels, 0, screenWidth)

        try {
            if (!grabber.grabPixels()) {
                throw new InterruptedException("Could not grab pixels")
            }
        } catch (Exception e) {
            System.err.println(e.getMessage())
            System.exit(-1)
        }

        for (int y = 0; y < screenHeight; y++) {
            for (int x = 0; x < screenWidth; x++) {
                if (pixels[(y * screenWidth) + x] == oldColorMask) {
                    pixels[(y * screenWidth) + x] = newColorMask
                }
            }
        }

        newImage = createImage(
                new MemoryImageSource(screenWidth, screenHeight, pixels, 0, screenWidth))
        tuttleGraphics
                .drawImage(newImage, -(Math.floorDiv(screenWidth, 2)), -(Math.floorDiv(screenHeight, 2)), this)
        currentBackground = c
        repaint()
    }

    void setPenUp() {
        penDown = false
    }

    void setPenDown() {
        penDown = true
    }

    String getPenState() {
        penDown ? "pen down" : "pen up"
    }

    String getDetails() {
        "X: ${xLocation}  Y: ${yLocation * -1}  D: ${direction}  ${penState}"
    }
}
