package pattern.behavioral

class OrNode extends NonterminalQueryNode {
    def evaluateAgainst(anObject) {
        leftChild .evaluateAgainst(anObject) || rightChild .evaluateAgainst(anObject)
    }
}
