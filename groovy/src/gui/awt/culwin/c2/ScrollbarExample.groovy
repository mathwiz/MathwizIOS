package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.AdjustmentEvent
import java.awt.event.AdjustmentListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class ScrollbarExample extends Applet implements AdjustmentListener {
    Scrollbar scroller
    Label decimalLabel, hexLabel

    void init() {
        decimalLabel = new Label()
        hexLabel = new Label()

        scroller = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256)
        scroller.setBlockIncrement(10)
        scroller.addAdjustmentListener(this)

        this.setLayout(new GridLayout(3, 1, 5, 5))

        this.add(decimalLabel)
        this.add(hexLabel)
        this.add(scroller)

        this.update()
    }

    void adjustmentValueChanged(AdjustmentEvent event) {
        print "Adjustment Value Changed. "
        println "Value is now: ${event.value}"
        this.update()
    }

    protected void update() {
        int theValue = scroller.getValue()
        String decimalValue = Integer.toString(theValue, 10)
        String hexValue = Integer.toString(theValue, 16)

        decimalLabel.setText("Decimal: ${decimalValue}")
        hexLabel.setText("Hex: ${hexValue}")
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new ScrollbarExample()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
