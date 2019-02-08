package automata


class Rule {
    List<Element> elements = []

    Rule add(Element element) {
        elements.add(element)
        this
    }

    byte eval(Cell cell) {
        //iterate over all rule elements
        //if there is a match, produce the new color
        //otherwise return 0
    }

    static class Element {
        byte left
        byte center
        byte right
    }
}
