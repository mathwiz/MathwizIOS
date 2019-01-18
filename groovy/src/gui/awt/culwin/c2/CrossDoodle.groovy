package gui.awt.culwin.c2

import java.awt.*
import java.awt.event.MouseEvent

class CrossDoodle extends Doodle {
    int lastX, lastY
    Graphics context

    CrossDoodle(int width, int height) {
        super(width, height)
    }

    void paint(Graphics context) {
        int w = this.getBounds().width.intValue()
        int h = this.getBounds().height.intValue()

        context.drawLine(0, 0, w, h)
        context.drawLine(0, h, w, 0)
        context.drawLine(intValue(w / 2), 0, intValue(w / 2), h)
        context.drawLine(0, intValue(h / 2), w, intValue(h / 2))
    }

    private intValue(x) {
        Math.round(x).intValue()
    }
}