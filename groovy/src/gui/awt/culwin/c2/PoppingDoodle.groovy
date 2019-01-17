package gui.awt.culwin.c2

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent

class PoppingDoodle extends Doodle implements ActionListener {
    PopupMenu popup
    MenuItem clearItem, invertItem

    PoppingDoodle(int width, int height) {
        super(width, height)
        this.enableEvents(AWTEvent.MOUSE_MOTION_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.ACTION_EVENT_MASK)
        popup = new PopupMenu()
        this.add(popup)

        clearItem = new MenuItem("Clear")
        clearItem.setActionCommand("Clear")
        clearItem.addActionListener(this)
        popup.add(clearItem)

        invertItem = new MenuItem("Invert")
        invertItem.setActionCommand("Invert")
        invertItem.addActionListener(this)
        popup.add(invertItem)
    }

    void processMouseEvent(MouseEvent event) {
        super.processMouseEvent(event)
        if (event.getID() == MouseEvent.MOUSE_PRESSED) {
            if (event.getClickCount() == 2) {
                println "Mouse double-clicked at (${event.getX()}, ${event.getY()})"
                popup.show(this, event.getX(), event.getY())
            }
        }
    }

    void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand()
        Color hold

        if (cmd.equals("Clear")) {
            this.repaint()
        } else if (cmd.equals("Invert")) {
            hold = this.getBackground()
            this.setBackground(this.getForeground())
            this.setForeground(hold)
            context.setColor(hold)
            this.repaint()
        }
    }
}