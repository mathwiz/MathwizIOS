package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class SingleListExample extends Applet implements ItemListener {
    List cityList
    Label promptLabel

    void init() {
        promptLabel = new Label("What cities have you visited")

        cityList = new List(7, false)
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
        int selection = selectedComponent.getSelectedIndex()

        if (selection == -1) {
            println "No items selected"
        } else {
            println "Selected index is ${selection}"
            println "Selected item is ${selectedComponent.getSelectedItem()}"
        }

        if (event.getID() == ItemEvent.ITEM_STATE_CHANGED) {
            println "ID is ITEM_STATE_CHANGED"
        }

        println ""
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new SingleListExample()

        theInterface .init()
        frame .add(theInterface, "Center")

        frame .setVisible(true)
        frame .setSize(frame .getPreferredSize())
    }

}
