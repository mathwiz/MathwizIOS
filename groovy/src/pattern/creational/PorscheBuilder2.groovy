package pattern.creational

class PorscheBuilder2 extends CarFactoryMethodBuilder {
    def makeEngine() {
        new PorscheEngine()
    }

    def makeChassis() {
        new PorscheChassis()
    }

    def makeTransmission() {
        new GermanTransmission()
    }
}
