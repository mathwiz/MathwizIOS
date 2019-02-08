package automata

class Automaton {
    private static int SIZE = 64
    int size
    Rule rule
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

    List<Cell> getCells() {
        row.toList()
    }

    private void initialize(Rule rule, List<Byte> init, int size) {
        this.size = size
        this.rule = rule
        makeCells(init)
    }

    private void makeCells(List<Byte> pattern) {
        row = new Cell[this.size]
        //recycle over init values
        def colorIt = 0
        (0..(row.length - 1)).each {
            colorIt = colorIt == pattern.size() ? 0 : colorIt
            row[it] = new Cell(color: pattern[colorIt++])
            if (it == 0) {
                //clause needed so no pointers created in this case
            } else if (it == row.length - 1) {
                row[it].setRight(row[0])
                row[0].setLeft(row[it])
            } else {
                row[it].setLeft(row[it - 1])
                row[it - 1].setRight(row[it])
            }
        }
    }
}
