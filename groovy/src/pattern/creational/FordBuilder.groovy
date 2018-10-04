package pattern.creational

class FordBuilder extends CarBuilder {
    def addEngine() {
        car .engine = new FordEngine()
        this
    }

    def addChassis() {
        car .chassis = new FordChassis()
        this
    }

    def addTransmission() {
        car .transmission = new FordTransmission()
        this
    }
}
