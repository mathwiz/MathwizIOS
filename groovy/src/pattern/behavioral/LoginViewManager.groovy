package pattern.behavioral

class LoginViewManager {
    def activator, userField, passwordField

    def tryToEnableSubmit() {
        def hasUsername = !(userField .text .empty)
        def hasPassword = !(passwordField .text .empty)
        activator .setEnabled(hasUsername && hasPassword)
    }
}
