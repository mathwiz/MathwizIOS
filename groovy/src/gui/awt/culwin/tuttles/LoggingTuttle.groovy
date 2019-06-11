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
        private static final int SECONDS_PER_MIN = 60
        private static final int SECONDS_PER_HOUR = SECONDS_PER_MIN * 60
        private static final int INVALID_TIME = -1

        private int theStamp = INVALID_TIME

        TimeStamp() {
            this.stamp()
        }

        TimeStamp(boolean toStampNow) {
            if (toStampNow) {
                this.stamp()
            }
        }

        synchronized void stamp() {
            def now = new GregorianCalendar()
            theStamp = now.get(GregorianCalendar.HOUR_OF_DAY) * SECONDS_PER_HOUR
            theStamp += now.get(GregorianCalendar.MINUTE) * SECONDS_PER_MIN
            theStamp += now.get(GregorianCalendar.SECOND)
        }

        int elapsed(TimeStamp other) {
            if (other.theStamp == INVALID_TIME || this.theStamp == INVALID_TIME) {
                return INVALID_TIME
            } else {
                return other.theStamp - this.theStamp
            }
        }

        boolean isValid() {
            theStamp != INVALID_TIME
        }

        String toString() {
            def theTime = "**:**:**"
            if (isValid()) {
                int hours = theStamp / SECONDS_PER_HOUR
                int secs = theStamp % SECONDS_PER_MIN
                int mins = (theStamp - hours*SECONDS_PER_HOUR) / SECONDS_PER_MIN
                theTime += pad(hours)
                theTime += ":" + pad(mins)
                theTime += ":" + pad(secs)
            }
            theTime
        }

        String pad(int num) {
            (num < 10 ? "0" : "") + num
        }
    }
}
