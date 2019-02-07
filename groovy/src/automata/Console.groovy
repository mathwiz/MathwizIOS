package automata

class Console {
    static final char mark = '*'
    static final char empty = ' '

    static void main(String[] args) {
        println "${mark}${empty}${mark}"
        println([] ? "true" : "false")
    }
}
