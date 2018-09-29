package pattern.behavioral

class AttributeNode extends QueryNode {
    def attributeName

    def evaluateAgainst(anObject) {
        anObject ."${attributeName}"
    }
}
