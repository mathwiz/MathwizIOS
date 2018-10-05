package pattern.behavioral

import pattern.SubclassReponsibility

abstract class Grapher {
    def penSequence
    def defaultPens = [0,1,2,3,4,5,6,7,8,9]

    def plotFor(context) {
        throw new SubclassReponsibility()
    }

    def drawLength(length, symbol) {

    }
}
