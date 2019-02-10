package automata


class Rule {
    List<RuleElement> elements = []
    Closure colorFunction = { cell -> 1 }

    Rule add(RuleElement element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {
        elements.each {
            if (it.isMatch(cell)) {
                return colorFunction(cell)
            }
        }
        0 as byte
    }

}
