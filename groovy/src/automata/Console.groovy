package automata

class Console {
    static final char mark = '*'
    static final char empty = ' '

    String displayChar(val) {
        (val == 0 ? empty : val) as String
    }

    void displayRow(Automaton a) {
        a.getCells().each {
            print "${it.color}"
        }
        println ""
    }

    static void main(String[] args) {
        Console c = new Console()
        Rule rule = new Rule()
        List<Byte> pattern = []
        pattern.add(0 as Byte)
        pattern.add(1 as Byte)

        Automaton a = new Automaton(rule, pattern)
        (0..20).each {
            c.displayRow(a)
        }
    }
}
