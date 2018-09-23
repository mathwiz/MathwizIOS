package pattern.structural

class StringTailoredAdapter implements MyString {
    String string

    def getLength() {
        string.length()
    }

    def sub(from, upTo) {
        string.substring(from, upTo)
    }

    def append(more) {
        string.concat(more)
    }
}
