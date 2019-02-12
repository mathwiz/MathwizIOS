package automata


class Rule {
    static Rule create(int num) {
        def rule
        switch (num) {
            case 30:
                rule = new Rule()
                rule.add(new RuleElement(left: 1, center: 0, right: 0))
                rule.add(new RuleElement(left: 0, center: 1, right: 1))
                rule.add(new RuleElement(left: 0, center: 1, right: 0))
                rule.add(new RuleElement(left: 0, center: 0, right: 1))
                break
            default:
                rule = new Rule()
        }
        rule
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
                return colorFunction(cell) as byte
            }
        }
        0 as byte
    }

}
