package pattern.behavioral

class YComponent {
    def action(event, details) {
        LetterRouter .getInstance() .send(this, event, details)
    }

    def addActionMessage(letter) {
        LetterRouter .getInstance() .addRoute(this, letter)
    }
}
