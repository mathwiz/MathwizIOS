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

    Automaton evolve() {
        Cell[] next = new Cell[this.size]
        (0..(next.length - 1)).each {
            next[it] = row[it].evolve(rule)
            setNeighbors(it, next)
        }
        row = next
        this
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
            setNeighbors(it, row)
        }
    }

    private void setNeighbors(int it, Cell[] cells) {
        if (it == 0) {
            //clause needed but no pointers created in this case
        } else if (it == cells.length - 1) {
            cells[it].setLeft(cells[it - 1])
            cells[it - 1].setRight(cells[it])
            cells[it].setRight(cells[0])
            cells[0].setLeft(cells[it])
        } else {
            cells[it].setLeft(cells[it - 1])
            cells[it - 1].setRight(cells[it])
        }
//        println "current cell ${it}: ${cells[it].color}. Previous cell: ${cells[it - 1]}"
    }

    String toString() {
        StringBuffer sb = new StringBuffer()
        int i = 0
        row.each {
            sb.append("${i++}:${it.left} (${it.color}) ${it.right}|")
        }
        sb.toString()
    }
}
