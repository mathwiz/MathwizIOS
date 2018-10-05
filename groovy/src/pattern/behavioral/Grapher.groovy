package pattern.behavioral

import pattern.SubclassReponsibility

abstract class Grapher {
    def penSequence
    def defaultPens = [0,1,2,3,4,5,6,7,8,9]
    def fieldPad = 2
    def width

    def plotFor(context) {
        throw new SubclassReponsibility()
    }

    def drawLength(length, symbol) {
        (1..length) .inject("") {sum, it -> sum += symbol}
    }

    def dataFields(data) {
        new ArrayList(data .keySet())
    }

    def dataPairs(data) {
        dataFields(data) .collect { [it, data[it]] }
    }

    def scaledLength(val, max, scale) {
        Math.round(val / max * scale)
    }

    def maxFieldLength(data) {
        dataFields(data) .max { it.size() } .size()
    }

    def maxDataLength(data) {
        (dataPairs(data) .max { it[1] })[1]
    }

    def makeLine(field, value, max, symbol) {
        (field .padRight(max + fieldPad)) + drawLength(value, symbol)
    }

    def currentSymbol(iteration) {
        penSequence[iteration % (penSequence .size())]
    }

    def chartLines(data) {
        int line = 0
        int fieldMax = maxFieldLength(data)
        int dataMax = maxDataLength(data)
        dataPairs(data) .collect { makeLine(it[0], scaledLength(it[1], dataMax, width), fieldMax, currentSymbol(line++)) }
    }
}
