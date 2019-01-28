package gui.awt.culwin.c3.datepanel

import java.awt.AWTEvent
import java.awt.Canvas
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent

class DayBox extends Canvas {
    int ordinal = -1
    int dayNumber = 0
    boolean isHighlighted = false
    boolean isBordered = false
    boolean isPrimed = false
    ActionListener sendToHere

    DayBox(int itsLocation, ActionListener listener) {
        ordinal = itsLocation
        enableEvents(AWTEvent.MOUSE_EVENT_MASK)
        sendToHere = listener
    }

    void setHighlight() {
        isHighlighted = true
        repaint()
    }

    void clearHighlight() {
        isHighlighted = false
        repaint()
    }

    void paint(Graphics context) {
        def location = getSize()
        context.setColor(getBackground())
        context.fillRect(0, 0, location.width - 1, location.height - 1)
        context.setColor(getForeground())

        if (dayNumber != 0) {
            def numString = Integer.toString(dayNumber)
            def metrics = getFontMetrics(getFont())
            def stringHeight = metrics.getHeight()
            def stringWidth = metrics.stringWidth(numString)
            context.drawString(numString, (location.width - stringWidth).intdiv(2), stringHeight + 2)
            if (isHighlighted) {
                context.drawRect(2, 2, location.width - 4, location.height - 4)
                context.drawRect(3, 3, location.width - 6, location.height - 6)
            }
            if (isBordered) {
                context.drawRect(1, 1, location.width - 2, location.height - 2)
            }
        }
    }

    void processMouseEvent(MouseEvent event) {
        if (dayNumber != 0) {
            switch (event.getID()) {
                case MouseEvent.MOUSE_ENTERED:
                    isBordered = true
                    repaint()
                    break
                case MouseEvent.MOUSE_EXITED:
                    isBordered = true
                    isPrimed = false
                    repaint()
                    break
                case MouseEvent.MOUSE_PRESSED:
                    isPrimed = true
                    break
                case MouseEvent.MOUSE_RELEASED:
                    if (isPrimed) {
                        sendToHere.actionPerformed(
                                new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "DateSelected"))
                    }
                    break
            }
        }
    }
}
