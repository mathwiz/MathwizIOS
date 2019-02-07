package automata

class Rule {
    List<List<Byte>> elements = []

    Rule add(List<Byte> element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {

    }


}
