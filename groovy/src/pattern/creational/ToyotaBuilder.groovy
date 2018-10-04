package pattern.creational

class ToyotaBuilder extends CarBuilder {
    def addEngine() {
        car .engine = new ToyotaEngine()
        this
    }

    def addchassis() {
        car .chassis = new ToyotaChassis()
        this
    }

    def addTransmission() {
        car .transmission = new GermanTransmission()
        this
    }
}
