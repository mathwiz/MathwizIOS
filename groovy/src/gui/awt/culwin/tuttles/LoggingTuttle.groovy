package gui.awt.culwin.tuttles

import java.applet.Applet
import java.awt.event.MouseListener

class LoggingTuttle extends BufferedTuttle {
    private boolean loggingActive = false
    private PrintWriter logFile

    LoggingTuttle(Applet applet, MouseListener listener, int width, int height) {
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

    void startLogging() {
        TimeStamp theTime = new TimeStamp(true)
        String filename = "tlog"
        filename += TimeStamp.pad(theTime.hours)
        filename += TimeStamp.pad(theTime.minutes)
        filename += TimeStamp.pad(theTime.seconds)
        filename += ".log"

        try {
            logFile = new PrintWriter(new FileOutputStream(filename))
        } catch (IOException e) {
            System.err.println("Log file could not be opened. Logging to terminal.")
            logFile = new PrintWriter(System.out, true)
        }
        println "Logging started"
        loggingActive = true
    }

    void stopLogging() {
        logCommand("Logging stopped")
        logFile.close()
        println "Logging stopped"
        loggingActive = false
    }

    boolean isLoggingActive() {
        loggingActive
    }


    //Helper class
    class TimeStamp {
        private static final int SECONDS_PER_MIN = 60
        private static final int SECONDS_PER_HOUR = SECONDS_PER_MIN * 60
        private static final int INVALID_TIME = -1

        static String pad(int num) {
            (num < 10 ? "0" : "") + num
        }

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

        int getHours() {
            valid ? theStamp / SECONDS_PER_HOUR : 0
        }

        int getMinutes() {
            valid ? (theStamp - hours*SECONDS_PER_HOUR) / SECONDS_PER_MIN : 0
        }

        int getSeconds() {
            valid ? theStamp % SECONDS_PER_MIN : 0
        }

        String toString() {
            def theTime = ""
            if (isValid()) {
                theTime += pad(hours)
                theTime += ":" + pad(minutes)
                theTime += ":" + pad(seconds)
            } else {
                theTime = "**:**:**"
            }
            theTime
        }
    } // TimeStamp
}
