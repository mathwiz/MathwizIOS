package pattern.creational

import pattern.SubclassReponsibility

abstract class CarBuilder {
    def car = new Car()

    def addEngine() {
        throw new SubclassReponsibility()
    }

    def addChassis() {
        throw new SubclassReponsibility()
    }

    def addTransmission() {
        throw new SubclassReponsibility()
    }

    def build() {
        car
    }
}
