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
                println "MATCH on ${cell} with rule: ${it}"
                return 1 as byte // colorFunction(cell)
            }
        }
        0 as byte
    }

}
