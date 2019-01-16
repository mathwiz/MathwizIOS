package gui.awt.culwin.c2

import java.awt.AWTEvent
import java.awt.Canvas
import java.awt.Graphics
import java.awt.event.MouseEvent


class Doodle extends Canvas {
    int lastX, lastY
    Graphics context

    Doodle(int width, int height) {
        this.setSize(width, height)
        this.enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK)
    }

    void addNotify() {
        super.addNotify()
        context = this.getGraphics().create()
    }

    void processMouseEvent(MouseEvent event) {
        if (event.getID() == MouseEvent.MOUSE_PRESSED) {
            println "Mouse pressed at (${event.getX()}, ${event.getY()})"
            lastX = event.getX()
            lastY = event.getY()
        } else if (event.getID() == MouseEvent.MOUSE_RELEASED) {
            println "Mouse released at (${event.getX()}, ${event.getY()})"
        }
    }

    void processMouseMotionEvent(MouseEvent event) {
        if (event.getID() == MouseEvent.MOUSE_DRAGGED) {
            println "Mouse dragged to (${event.getX()}, ${event.getY()})"
            context.drawLine(lastX, lastY, event.getX(), event.getY())
            lastX = event.getX()
            lastY = event.getY()
        }
    }
}