package gui.awt.culwin.c2

import java.awt.*
import java.applet.*
import java.awt.event.*

class CheckExample extends Applet implements ItemListener {
    Checkbox boldButton, italicButton, underlineButton, smallcapsButton

    void init() {
        this.setLayout(new GridLayout(2,2,5,5))

        boldButton = new Checkbox("Bold")
        boldButton.addItemListener(this)
        this.add(boldButton)

        italicButton = new Checkbox("Italic")
        italicButton.addItemListener(this)
        this.add(italicButton)

        underlineButton = new Checkbox("Underline")
        underlineButton.addItemListener(this)
        this.add(underlineButton)

        smallcapsButton = new Checkbox("Smallcaps")
        smallcapsButton.addItemListener(this)
        this.add(smallcapsButton)
    }

    void itemStateChanged(ItemEvent event) {
        println "Item Selectable is..."
        if (event.getItemSelectable() == boldButton) {
            println "Bold button"
        } else if (event.getItemSelectable() == italicButton) {
            println "Italic button"
        } else if (event.getItemSelectable() == underlineButton) {
            println "Underline button"
        } else if (event.getItemSelectable() == smallcapsButton) {
            println "Smallcaps button"
        }

        println "Item is " + event.getItem()

        println "State change is..."

        if (event.getID() == ItemEvent.ITEM_STATE_CHANGED) {
            println "ID is ITEM_STATE_CHANGED which is " + event.getID()
        }

        println "\n"
    }

    static void main(String[] args) {
        def frame = new Frame("CheckExample")
        def theInterface = new CheckExample()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }

}
