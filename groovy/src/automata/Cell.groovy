package automata

class Cell {
    byte color
    Cell left
    Cell right

    Cell evolve(Rule rule) {
        new Cell(color: rule.eval(this))
    }

    boolean isOn() {
        color != 0 as byte
    }

    String toString() {
        "${left?.color} ${color} ${right?.color}"
    }
}
