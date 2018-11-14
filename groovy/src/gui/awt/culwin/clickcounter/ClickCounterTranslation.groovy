package gui.awt.culwin.clickcounter

import java.applet.Applet
import java.awt.Frame
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ClickCounterTranslation extends Applet implements ActionListener {
    final static INITIAL_STATE = 0
    final static MINIMUM_STATE = 1
    final static COUNTING_STATE = 2
    final static MAXIMUM_STATE = 3
    int theState = INITIAL_STATE
    ClickCounter theCounter
    ClickCounterPresentation itsInterface

    void init() {
        theCounter = new ClickCounter(0, 5)
        itsInterface = new ClickCounterPresentation(this)
        itsInterface .setValueDisplay(theCounter .countIsAsString())
        itsInterface .setMinimumState()
        theState = MINIMUM_STATE
    }

    @Override
    void actionPerformed(ActionEvent event) {
        def buttonPressed = event .getActionCommand()

        switch(buttonPressed) {
            case "increment":
                if (theState == MINIMUM_STATE) {
                    itsInterface .setCountingState()
                    theState = COUNTING_STATE
                }

                theCounter .count()

                if (theCounter .isAtMaximum()) {
                    itsInterface .setMaximumState()
                    theState = MAXIMUM_STATE
                }
                break
            case "reset":
                theCounter .reset()
                itsInterface .setMinimumState()
                theState = MINIMUM_STATE
                break
            case "decrement":
                if (theCounter .isAtMaximum()) {
                    itsInterface .setCountingState()
                    theState = COUNTING_STATE
                }

                theCounter .unCount()

                if (theCounter .isAtMinimum()) {
                    itsInterface .setMinimumState()
                    theState = MINIMUM_STATE
                }
                break
        }

        itsInterface .setValueDisplay( theCounter .countIsAsString())
    }

    public static void main(String[] args) {
        def frame = new Frame("Click Counter Demo")
        def theInterface = new ClickCounterTranslation()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }
}
