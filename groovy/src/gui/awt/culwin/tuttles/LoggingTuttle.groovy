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

    String doCommand(String theCommand) {
        logCommand(theCommand)
        super.doCommand(theCommand)
    }

    void logCommand(String theCommand) {
        if (loggingActive) {
            TimeStamp stamp = new TimeStamp(true)
            logFile.println("${stamp} ${theCommand}")
        }
    }

    class TimeStamp {
        private int theStamp

        TimeStamp() {
            this.stamp()
        }

        TimeStamp(boolean toStampNow) {
            if (toStampNow) {
                this.stamp()
            }
        }

        void stamp() {

        }

        String toString() {

        }
    }
}
