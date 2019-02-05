package automata

class Automaton {
    private static int SIZE = 64
    int size
    Rule rule
    List<Byte> init
    Cell[] row

    Automaton(Rule rule) {
        List<Byte> init = []
        (0..(SIZE - 1)).each { init.add((it == Math.floor(SIZE / 2) ? 1 : 0) as Byte) }
        initialize(rule, init, SIZE)
    }

    Automaton(Rule rule, List<Byte> init) {
        initialize(rule, init, SIZE)
    }

    Automaton(Rule rule, List<Byte> init, int size) {
        initialize(rule, init, size)
    }

    private void initialize(Rule rule, List<Byte> init, int size) {
        this.size = size
        this.rule = rule
        makeCells(init)
    }

    private void makeCells(List<Byte> pattern) {
        row = new Cell[this.size]
        //recycle over init values
    }
}
