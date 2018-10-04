package pattern.creational

class ToyotaBuilder2 extends CarFactoryMethodBuilder {
    def makeEngine() {
        new ToyotaEngine()
    }

    def makeChassis() {
        new ToyotaChassis()
    }

    def makeTransmission() {
        new GermanTransmission()
    }
}
