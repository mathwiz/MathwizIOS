package sample

import pattern.behavioral.Magnitude
import pattern.behavioral.StringLength

class TemplateMethodExample1 {
    def doIt() {
        println("Template Method")
        def foosballMag = new Magnitude(val: "foosball")
        def foosballStringLength = new StringLength(val: "foosball")
        def yohanMag = new Magnitude(val: "yohan")
        def yohanStringLength = new StringLength(val: "yohan")
        def zebraMag = new Magnitude(val: "zebra")
        def zebraStringLength = new StringLength(val: "zebra")

        println("\nString value")
        test(foosballMag, yohanMag, "lt")
        println("\nString length")
        test(foosballStringLength, yohanStringLength, "lt")

        println("\nString value")
        test(zebraMag, yohanMag, "lt")
        test(zebraMag, yohanMag, "gt")
        println("\nString length")
        test(zebraStringLength, yohanStringLength, "lt")
        test(zebraStringLength, yohanStringLength, "gt")
        test(zebraStringLength, yohanStringLength, "lteq")
        test(zebraStringLength, yohanStringLength, "gteq")
    }

    def test(a, b, op) {
        def result = a ."${op}"(b)
        println("'${a}' ${op} '${b}': ${result}" )
    }
}
