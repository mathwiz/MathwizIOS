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
        (0..(row.length - 1)).each {
            row[it] = new Cell(color: pattern[it])
            if (it == row.length - 1) {
                row[it].setRight(row[0])
                row[0].setLeft(row[it])
            } else {
                row[it].setLeft(row[it - 1])
                row[it - 1].setRight(row[it])
            }
        }
    }
}
