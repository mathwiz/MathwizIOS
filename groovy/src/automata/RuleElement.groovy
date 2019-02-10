package automata

class RuleElement {
    byte left
    byte center
    byte right

    boolean isMatch(Cell cell) {
        println "cell: ${cell} vs rule: ${this}"
        cell.getLeft()?.getColor() == this.getLeft() &&
                cell.getRight()?.getColor() == this.getRight() &&
                cell.getColor() == this.getCenter()
    }

    String toString() {
        "${left} ${center} ${right}"
    }
}
