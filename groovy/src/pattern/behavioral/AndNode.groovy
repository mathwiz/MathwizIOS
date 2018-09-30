package pattern.behavioral

class AndNode extends NonterminalQueryNode {
    def evaluateAgainst(anObject) {
        leftChild .evaluateAgainst(anObject) && rightChild .evaluateAgainst(anObject)
    }
}
