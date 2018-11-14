package gui.awt.culwin.clickcounter

import java.awt.*

class ClickCounterPresentation {
    def incrementButton, resetButton, decrementButton, valueDisplay

    ClickCounterPresentation(ClickCounterTranslation itsApplet) {
        def valuePanel = new Panel()
        def controlPanel = new Panel()

        itsApplet .setLayout(new GridLayout(2, 1, 10, 10))

        valueDisplay = new Label()
        valuePanel .add(valueDisplay)
        itsApplet .add(valuePanel)

        incrementButton = new Button("+")
        incrementButton .setActionCommand("increment")
        incrementButton .addActionListener(itsApplet)

        resetButton = new Button("0")
        resetButton .setActionCommand("reset")
        resetButton .addActionListener(itsApplet)

        decrementButton = new Button("-")
        decrementButton .setActionCommand("decrement")
        decrementButton .addActionListener(itsApplet)

        controlPanel .add(incrementButton)
        controlPanel .add(resetButton)
        controlPanel .add(decrementButton)

        itsApplet .add(controlPanel)
    }

    def setValueDisplay(setTo) {
        valueDisplay .setText(setTo)
    }

    def setMinimumState() {
        incrementButton .setEnabled(true)
        resetButton .setEnabled(false)
        decrementButton .setEnabled(false)
    }

    def setMaximumState() {
        incrementButton .setEnabled(false)
        resetButton .setEnabled(true)
        decrementButton .setEnabled(true)
    }

    def setCountingState() {
        incrementButton .setEnabled(true)
        resetButton .setEnabled(true)
        decrementButton .setEnabled(true)
    }
}
