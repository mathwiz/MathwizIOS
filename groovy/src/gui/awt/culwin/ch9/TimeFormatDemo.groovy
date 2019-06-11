package gui.awt.culwin.ch9

import java.text.DateFormat

class TimeFormatDemo {
    static void main(String[] args) {
        Date nightBefore = new GregorianCalendar(1999, 11, 31, 20, 20).getTime()
        Date morningAfter = new GregorianCalendar(2000, 0, 1, 7, 7).getTime()

        Locale.setDefault(Locale.FRANCE)

        println "Date Format Demo"

        println "Default formatting of dates and times... "
        print "Before: "
        println DateFormat.getInstance().format(nightBefore)
        print "After: "
        println DateFormat.getInstance().format(morningAfter)
        println ""

        println "Full formatting of dates and times... "
        print "Before: "
        println DateFormat.getDateInstance(DateFormat.FULL).format(nightBefore)
        print "After: "
        println DateFormat.getDateInstance(DateFormat.FULL).format(morningAfter)
        println ""

        println "Full formatting of times... "
        print "Before: "
        println DateFormat.getTimeInstance(DateFormat.FULL).format(nightBefore)
        print "After: "
        println DateFormat.getTimeInstance(DateFormat.LONG).format(morningAfter)
        println ""
    }
}
