package automata

class Console {
    static final char mark = '*'
    static final char empty = ' '

    String displayChar(val) {
        (val == 0 ? empty : val) as String
    }

    static void main(String[] args) {
        Console c = new Console()
        println "${c.displayChar(0)}${c.displayChar(2)}"
        println([] ? "true" : "false")
    }
}
