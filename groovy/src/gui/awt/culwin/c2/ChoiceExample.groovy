package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class ChoiceExample extends Applet implements ItemListener {
    Choice dayChoice = new Choice()
    Label promptLabel = new Label("Today is ", Label.RIGHT)

    void init() {
        this.setLayout(new FlowLayout())

        dayChoice.addItemListener(this)
        this.add(promptLabel)
        this.add(dayChoice)

        dayChoice.addItem("Sunday")
        dayChoice.addItem("Monday")
        dayChoice.addItem("Tuesday")
        dayChoice.addItem("Wednesday")
        dayChoice.addItem("Thursday")
        dayChoice.addItem("Friday")
        dayChoice.addItem("Saturday")
    }

    void itemStateChanged(ItemEvent event) {
        if (event.getItemSelectable() == dayChoice) {
            println "Item selectable is " + event.getItemSelectable()
        }

        println "Calling getItem() on the event: " + event.getItem()

        print "State change is... "

        if (event.getID() == ItemEvent.ITEM_STATE_CHANGED) {
            println "ID is ITEM_STATE_CHANGED"
        }

        println "\n"
    }

    static void main(String[] args) {
        def frame = new Frame("ChoiceExample")
        def theInterface = new ChoiceExample()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }

}
