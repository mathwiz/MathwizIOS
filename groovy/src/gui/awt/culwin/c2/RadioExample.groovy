package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class RadioExample extends Applet implements ItemListener {
    Checkbox leftButton, rightButton, justifyButton, centerButton

    void init() {
        this.setLayout(new GridLayout(2,2,5,5))

        CheckboxGroup theGroup = new CheckboxGroup()

        leftButton = new Checkbox("Left", false, theGroup)
        leftButton.addItemListener(this)
        this.add(leftButton)

        rightButton = new Checkbox("Right", false, theGroup)
        rightButton.addItemListener(this)
        this.add(rightButton)

        justifyButton = new Checkbox("Justify", false, theGroup)
        justifyButton.addItemListener(this)
        this.add(justifyButton)

        centerButton = new Checkbox("Center", true, theGroup)
        centerButton.addItemListener(this)
        this.add(centerButton)
    }

    void itemStateChanged(ItemEvent event) {
        print "Item Selectable is... "
        if (event.getItemSelectable() == leftButton) {
            println "Left button"
        } else if (event.getItemSelectable() == rightButton) {
            println "Right button"
        } else if (event.getItemSelectable() == justifyButton) {
            println "Justify button"
        } else if (event.getItemSelectable() == centerButton) {
            println "Center button"
        }

        println "Calling getItem() on the event: " + event.getItem()

        print "State change is... "

        if (event.getID() == ItemEvent.ITEM_STATE_CHANGED) {
            println "ID is ITEM_STATE_CHANGED which is " + event.getID()
        }

        println "\n"
    }

    static void main(String[] args) {
        def frame = new Frame("RadioExample")
        def theInterface = new RadioExample()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }

}
