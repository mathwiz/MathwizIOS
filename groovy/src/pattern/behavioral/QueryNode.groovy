package pattern.behavioral

import pattern.SubclassReponsibility

class QueryNode {
    def evaluateAgainst(anObject) {
        throw new SubclassReponsibility()
    }
}
