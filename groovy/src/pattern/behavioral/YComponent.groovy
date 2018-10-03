package pattern.behavioral

class YComponent {
    def changed(event, details) {
        LetterRouter .getInstance() .send(this, event, details)
    }

    def addChangeMessage(letter) {
        LetterRouter .getInstance() .addRoute(this, letter)
    }
}
