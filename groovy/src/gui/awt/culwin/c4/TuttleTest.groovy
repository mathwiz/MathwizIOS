package gui.awt.culwin.c4

import gui.awt.culwin.tuttles.Tuttle

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class TuttleTest extends Applet implements ActionListener {
    Tuttle theTuttle
    Label feedbackLabel
    Panel feedbackPanel, tuttlePanel, buttonPanel
    String[] actions = ["Fwd", "Bwd", "Rtn", "Ltn", "Rst", "Clr", "Cst",
                        "FgR", "FgG", "FgB", "BgY", "BgW", "Pdn", "Pup"]
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
            case actions[0]:
                theTuttle.forward(25)
                break
            case actions[1]:
                theTuttle.backward(25)
                break
            case actions[2]:
                theTuttle.turnRight(30)
                break
            case actions[3]:
                theTuttle.turnLeft(30)
                break
            case actions[4]:
                theTuttle.resetTuttle()
                break
            case actions[5]:
                theTuttle.clearTuttleArea()
                break
            case actions[6]:
                theTuttle.clearAndReset()
                break
            case actions[7]:
                theTuttle.setForeground(Color.RED)
                break
            case actions[8]:
                theTuttle.setForeground(Color.GREEN)
                break
            case actions[9]:
                theTuttle.setForeground(Color.BLUE)
                break
            case actions[10]:
                theTuttle.setBackground(Color.YELLOW)
                break
            case actions[11]:
                theTuttle.setBackground(Color.WHITE)
                break
            case actions[12]:
                theTuttle.setPenDown()
                break
            case actions[13]:
                theTuttle.setPenUp()
                break
            default:
                println "Command not recognized ${cmd}"
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
