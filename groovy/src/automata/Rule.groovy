package automata


class Rule {
    static Rule R30
    static {
        R30 = new Rule()
        R30.add(new RuleElement(left: 1, center: 0, right: 0))
        R30.add(new RuleElement(left: 0, center: 1, right: 1))
        R30.add(new RuleElement(left: 0, center: 1, right: 0))
        R30.add(new RuleElement(left: 0, center: 0, right: 1))
    }

    List<RuleElement> elements = []
    Closure colorFunction = { cell -> 1 }

    Rule add(RuleElement element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {
        for (int it = 0; it < elements.size(); it++) {
            if (elements[it].isMatch(cell)) {
//                println "MATCH on ${cell} with rule: ${elements[it]}"
                return colorFunction(cell) as byte
            }
        }
        0 as byte
    }

}
