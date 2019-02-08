package automata

class Console {
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
        rule.add(new RuleElement(left: 0, center: 1, right: 1))
        rule.add(new RuleElement(left: 1, center: 1, right: 1))
        rule.add(new RuleElement(left: 1, center: 1, right: 0))
        List<Byte> pattern = []
        pattern.add(0 as Byte)
        pattern.add(1 as Byte)
        pattern.add(1 as Byte)

        Automaton a = new Automaton(rule, pattern)
        (0..40).each {
            c.displayRow(a)
        }
    }
}
