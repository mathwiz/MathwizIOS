package pattern.creational

class FordBuilder2 extends CarFactoryMethodBuilder {
    def makeEngine() {
        new FordEngine()
    }

    def makeChassis() {
        new FordChassis()
    }

    def makeTransmission() {
        new FordTransmission()
    }
}
