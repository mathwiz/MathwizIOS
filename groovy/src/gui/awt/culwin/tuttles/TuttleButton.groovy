package gui.awt.culwin.tuttles

import javax.imageio.ImageIO
import java.applet.Applet
import java.awt.AWTEvent
import java.awt.AWTEventMulticaster
import java.awt.Canvas
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent

class TuttleButton extends Canvas {
    private static final int BORDER_WIDTH = 2
    private static final Color DEFAULT_BORDER_COLOR = new Color(0x80, 0x80, 0x80)

    Image buttonImage
    String imageSource
    int buttonWidth = -1
    int buttonHeight = -1
    boolean pressed = false
    Color borderColor
    String actionCommand
    ActionListener myListener
    Applet myApplet

    TuttleButton(String filename, Applet applet) {
        this(filename, applet, DEFAULT_BORDER_COLOR)
    }

    TuttleButton(String filename, Applet applet, Color color) {
        imageSource = "gui/awt/culwin/tuttles/${filename}"
        myApplet = applet
        setForeground(color)
        enableEvents(AWTEvent.MOUSE_EVENT_MASK)
    }

    void addNotify() {
        super.addNotify()
        def imageFile = this.class.getClassLoader().getResource(imageSource)
        buttonImage = ImageIO.read(imageFile)

        if (buttonImage == null ||
                buttonImage.getWidth(this) < 1 ||
                buttonImage.getHeight(this) < 1) {
            println "Empty image...exiting"
            System.exit(-1)
        }

        buttonWidth = buttonImage.getWidth(this) + BORDER_WIDTH * 2
        buttonHeight = buttonImage.getHeight(this) + BORDER_WIDTH * 2
        setSize(buttonWidth, buttonHeight)
    }

    Dimension getMinimumSize() {
        new Dimension(buttonWidth, buttonHeight)
    }

    Dimension getPreferredSize() {
        getMinimumSize()
    }

    void update(Graphics graphicsContext) {
        paint(graphicsContext)
    }

    void paint(Graphics graphicsContext) {
        graphicsContext.drawImage(buttonImage, BORDER_WIDTH, BORDER_WIDTH, this)
        for (int index = 0; index < BORDER_WIDTH; index++) {
            graphicsContext.draw3DRect(index, index, buttonWidth - index - 1, buttonHeight - index - 1, !pressed)
        }
    }

    void processMouseEvent(MouseEvent event) {
        switch (event.getID()) {
            case MouseEvent.MOUSE_EXITED:
                pressed = false
                break
            case MouseEvent.MOUSE_PRESSED:
                pressed = true
                break
            case MouseEvent.MOUSE_RELEASED:
                if (pressed && myListener != null) {
                    myListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getActionCommand()))
                }
                break
        }
        repaint()
    }

    String getActionCommand() {
        actionCommand ?: "Tuttle Button"
    }

    void addActionListener(ActionListener actionListener) {
        myListener = AWTEventMulticaster.add(myListener, actionListener)
    }

    void removeActionListener(ActionListener actionListener) {
        myListener = AWTEventMulticaster.remove(myListener, actionListener)
    }
}
