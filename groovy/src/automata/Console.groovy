package automata

class Console {
    static final char mark = '*'
    static final char empty = ' '

    String displayChar(val) {
        (val == 0 ? empty : val) as String
    }

    void displayRow(Automaton a) {
        a.getCells().each {
            print displayChar(it.color)
        }
        println ""
    }

    static void main(String[] args) {
        Console c = new Console()
        Rule rule = new Rule()
        rule.add(new RuleElement(left: 1, center: 0, right: 0))
        rule.add(new RuleElement(left: 0, center: 1, right: 1))
        rule.add(new RuleElement(left: 0, center: 1, right: 0))
        rule.add(new RuleElement(left: 0, center: 0, right: 1))
        List<Byte> pattern = []
        pattern.add(0 as Byte)
        pattern.add(1 as Byte)
        pattern.add(1 as Byte)
        pattern.add(0 as Byte)

        Automaton a = new Automaton(rule)
        def rows = (args.length > 0 ? args[0] : 40) as Integer
        c.displayRow(a)
        (0..rows).each {
            a.evolve()
            c.displayRow(a)
        }
    }
}
