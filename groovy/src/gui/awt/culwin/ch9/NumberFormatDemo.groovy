package gui.awt.culwin.ch9

import java.text.NumberFormat

class NumberFormatDemo {
    static void main(String[] args) {
        def gen = 1234.56
        def neg = -12.34
        def pos = 12.34

        Locale.setDefault(Locale.FRANCE)

        println "Number Format Demo"

        print "Default formatting of a general number..."
        println NumberFormat.getNumberInstance().format(gen)

        print "Currency formatting of a pos number..."
        println NumberFormat.getCurrencyInstance().format(pos)

        print "Currency formatting of a neg number..."
        println NumberFormat.getCurrencyInstance().format(neg)
    }
}
