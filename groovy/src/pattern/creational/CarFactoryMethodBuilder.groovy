package pattern.creational

import pattern.SubclassReponsibility

abstract class CarFactoryMethodBuilder extends CarBuilder {
    def addEngine() {
        car .engine = makeEngine()
        this
    }

    def addChassis() {
        car .chassis = makeChassis()
        this
    }

    def addTransmission() {
        car .transmission = makeTransmission()
        this
    }

    def makeEngine() {
        throw new SubclassReponsibility()
    }

    def makeChassis() {
        throw new SubclassReponsibility()
    }

    def makeTransmission() {
        throw new SubclassReponsibility()
    }
}
