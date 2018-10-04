package sample

import pattern.behavioral.LoginViewManager

import javax.swing.JButton
import javax.swing.JTextField

class MediatorExample1 {
    def submitBtn = new JButton("Submit")
    def usernameFld = new JTextField()
    def passwordFld = new JTextField()

    def doIt() {
        println("Mediator")
        submitBtn .setEnabled(false)
        def mediator = new LoginViewManager(activator: submitBtn, userField: usernameFld, passwordField: passwordFld)
        showState("Initial state")
        usernameFld .setText("yohan")
        mediator .tryToEnableSubmit()
        showState("Username added")
        passwordFld .setText("janies_got_a_gun")
        mediator .tryToEnableSubmit()
        showState("Password added")
    }

    def showState(message) {
        println(message)
        println("Username is empty: ${usernameFld .text .empty}")
        println("Password is empty: ${passwordFld .text .empty}")
        println("Submit is enabled: ${submitBtn .enabled}")
    }
}
