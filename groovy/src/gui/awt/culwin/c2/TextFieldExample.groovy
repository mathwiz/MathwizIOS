package gui.awt.culwin.c2

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.AdjustmentEvent
import java.awt.event.AdjustmentListener

class TextFieldExample extends Applet implements ActionListener {
    TextField promptField, passwordField

    void init() {
        passwordField = new TextField(8)
        promptField = new TextField("Please enter the magic word.")

        passwordField.setEchoChar("*" as char)
        passwordField.addActionListener(this)

        promptField.setEditable(false)

        this.setLayout(new FlowLayout())

        this.add(promptField)
        this.add(passwordField)
    }

    void actionPerformed(ActionEvent event) {
        println "Action Event fired."
        String attempt = passwordField.getText()

        if (attempt.equals("Linda")) {
            promptField.setText("Welcome!")
            passwordField.setVisible(false)
            promptField.getParent().doLayout()
        } else {
            passwordField.setText("")
        }
    }

    static void main(String[] args) {
        def frame = new Frame("AWT Example")
        def theInterface = new TextFieldExample()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }

}
