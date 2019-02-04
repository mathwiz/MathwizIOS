package gui.awt.culwin.c4

import gui.awt.culwin.tuttles.Tuttle
import org.fusesource.jansi.Ansi

import java.applet.Applet
import java.awt.BorderLayout
import java.awt.Button
import java.awt.Color
import java.awt.Frame
import java.awt.GridLayout
import java.awt.Label
import java.awt.Panel
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleTest extends Applet implements ActionListener {
    Tuttle theTuttle
    Label feedbackLabel
    Panel feedbackPanel, tuttlePanel, buttonPanel
    String[] actions = ["Fwd", "Bwd", "Rtn", "Ltn", "Rst", "Clr", "Cst",
                        "Fgr", "FgL", "FgB", "BgY", "BgW", "Pdn", "Pup"]
    Map<String, Button> buttons = new HashMap<>()

    void init() {
        setLayout(new BorderLayout())
        //create components
        tuttlePanel = new Panel()
        tuttlePanel.setBackground(Color.WHITE)
        theTuttle = new Tuttle(this, 400, 600)
        tuttlePanel.add(theTuttle)

        buttonPanel = new Panel()
        buttonPanel.setLayout(new GridLayout(2, 7))

        feedbackPanel = new Panel()
        feedbackPanel.setBackground(Color.WHITE)
        feedbackLabel = new Label()
        feedbackPanel.add(feedbackLabel)

        //create buttons
        actions.each { addButton(it) }

        //add components
        add(buttonPanel, "South")
        add(tuttlePanel, "Center")
        add(feedbackPanel, "North")

        feedback()
    }

    @Override
    void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand()
        println "Recieved command ${cmd}"

        switch (cmd) {
            case "Fwd":
                theTuttle.forward(25)
                break
            case "Bwd":
                theTuttle.backward(25)
                break
            case "Rtn":
                theTuttle.turnRight(30)
                break
        }

        feedback()
    }

    private void feedback() {
        feedbackLabel.setText(theTuttle.getDetails())
        feedbackPanel.doLayout()
    }

    private void addButton(String cmd) {
        Button button = new Button(cmd)
        button.setActionCommand(cmd)
        button.addActionListener(this)
        buttonPanel.add(button)
        buttons.put(cmd, button)
    }

    static void main(String[] args) {
        def frame = new Frame("TuttleTest")
        def theInterface = new TuttleTest()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
