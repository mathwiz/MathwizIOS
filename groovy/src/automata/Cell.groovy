package automata

class Cell {
    byte color
    Cell left
    Cell right

    Cell evolve(Rule rule) {
        new Cell(color: rule)
    }

    boolean isOn() {
        color != 0 as byte
    }
}
