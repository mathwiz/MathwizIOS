package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class MultiListExample extends Applet implements ItemListener {
    List cityList
    Label promptLabel

    void init() {
        promptLabel = new Label("What cities have you visited")

        cityList = new List(7, true)
        cityList.add("London")
        cityList.add("Paris")
        cityList.add("Rome")
        cityList.add("Berlin")
        cityList.add("Amsterdam")
        cityList.add("Barcelona")
        cityList.add("Madrid")
        cityList.add("Torino")
        cityList.add("Napoli")
        cityList.add("Milano")
        cityList.add("Bern")
        cityList.add("Vienna")
        cityList.add("Athens")
        cityList.add("Budapest")
        cityList.add("Glasgow")
        cityList.add("Manchester")
        cityList.add("Dublin")

        cityList.makeVisible(cityList.itemCount - 1)

        this.setLayout(new BorderLayout())

        this.add(promptLabel, "North")
        this.add(cityList, "Center")

        cityList.addItemListener(this)
    }

    void itemStateChanged(ItemEvent event) {
        println "Item State Changed"
        List selectedComponent = event.getItemSelectable()
        String[] selections = selectedComponent.getSelectedItems()

        if (selections.length == 0) {
            println "No items selected"
        } else {
            selections.each { print " ${it}" }
            println ""
        }

        if (event.getID() == ItemEvent.ITEM_STATE_CHANGED) {
            println "ID is ITEM_STATE_CHANGED"
        }

        println ""
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new MultiListExample()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }

}
