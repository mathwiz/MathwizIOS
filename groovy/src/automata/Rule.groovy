package automata


class Rule {
    List<RuleElement> elements = []

    Rule add(RuleElement element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {
        //iterate over all rule elements
        //if there is a match, produce the new color
        //otherwise return 0
    }

}
