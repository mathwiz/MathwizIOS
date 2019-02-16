package automata

class Console {
    static final char mark = '*'
    static final char empty = ' '

    String displayChar(val) {
        (val == 0 ? empty : mark) as String
    }

    void displayRow(Automaton a) {
        a.getCells().each {
            print displayChar(it.color)
        }
        println ""
    }

    void displayHeader(Automaton a) {
        int size = a.getCells().size()
        def ones = new StringBuffer()
        def tens = new StringBuffer()
        for (int it = 0; it < size; it++) {
            def o = it % 10
            ones.append(o)
            def t = Math.floorDiv(it, 10) % 10
            tens.append(o == 0 ? t : " ")
        }
        println tens
        println ones
        println ""
    }

    def randomPattern(int size) {
        List<Byte> pattern = []
        (0..(size - 1)).each {
            byte val = (Math.random() < 0.5 ? 0 : 1) as byte
            pattern.add(val)
        }
        pattern
    }

    def singlePattern(int size) {
        List<Byte> pattern = []
        (0..(size - 1)).each {
            pattern.add(Math.floorDiv(size, 2) == it ? 1 : 0)
        }
        pattern
    }

    def initPattern(String pat) {
        pat.collect { it as byte }
    }

    Rule getRule(int ruleNum) {
        Rule.create(ruleNum)
    }

    static void main(String[] args) {
        Console c = new Console()

        def size = (args.length > 0 ? args[0] : 40) as Integer
        def rows = (args.length > 1 ? args[1] : 40) as Integer
        def rule = args.length > 2 ? c.getRule(args[2] as Integer) : Rule.create(30)
        def pat = args.length > 3 ? args[3] : null
        def random = pat == "r"
        def init = !random && pat != null ? c.initPattern(pat) : c.singlePattern(size)
        Automaton a = random ? new Automaton(rule, size, c.randomPattern(size)) : new Automaton(rule, size, init)
        c.displayHeader(a)
        c.displayRow(a)
        (0..rows).each {
            a.evolve()
            c.displayRow(a)
        }
    }
}
