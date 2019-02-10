package automata


class Rule {
    List<RuleElement> elements = []
    Closure colorFunction = { cell -> 1 }

    Rule add(RuleElement element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {
        for (int it = 0; it < elements.size(); it++) {
            if (elements[it].isMatch(cell)) {
                println "MATCH on ${cell} with rule: ${elements[it]}"
                return 1 as byte // colorFunction(cell)
            }
        }
        0 as byte
    }

}
