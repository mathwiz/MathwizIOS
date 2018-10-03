package pattern.behavioral

class YTextField extends YComponent {
    def text

    def setText(str) {
        changed("changed", [oldValue: text, newValue: str])
        text = str
    }

    def show() {
        println("YTextField value: '$text'")
    }
}
