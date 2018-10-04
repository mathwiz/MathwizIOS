package pattern.creational

class PorscheBuilder extends CarBuilder {
    def addEngine() {
        car .engine = new PorscheEngine()
        this
    }

    def addchassis() {
        car .chassis = new PorscheChassis()
        this
    }

    def addTransmission() {
        car .transmission = new GermanTransmission()
        this
    }
}
