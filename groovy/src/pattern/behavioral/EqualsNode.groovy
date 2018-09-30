package pattern.behavioral

class EqualsNode extends NonterminalQueryNode {
    def evaluateAgainst(anObject) {
        leftChild .evaluateAgainst(anObject) == rightChild .evaluateAgainst(anObject)
    }
}
