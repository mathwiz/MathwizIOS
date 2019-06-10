package gui.awt.culwin.tuttles

import java.applet.Applet
import java.awt.event.MouseListener

class LoggingTuttle extends BufferedTuttle {
    private boolean loggingActive = false
    private PrintWriter logFile

    LoggingTuttle(Applet applet, MouseListener listener, int witdth, int height) {
        super(applet, width, height)
        this.addMouseListener(listener)
    }
}
