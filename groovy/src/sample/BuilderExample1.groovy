package sample

import pattern.creational.FordBuilder
import pattern.creational.PorscheBuilder
import pattern.creational.ToyotaBuilder

class BuilderExample1 {
    def doIt() {
        println("Builder")
        def builder
        println("Building a Ford")
        builder = chooseManufacturer("Ford")
        builder .addchassis() .addEngine() .addTransmission()
        println(builder .build())
        println("Building a Porsche")
        builder = chooseManufacturer("Porsche")
        builder .addchassis() .addEngine() .addTransmission()
        println(builder .build())
        println("Building a Toyota")
        builder = chooseManufacturer("Toyota")
        builder .addchassis() .addEngine() .addTransmission()
        println(builder .build())
    }

    def chooseManufacturer(make) {
        println("Simulating a user selection of ${make} from a menu")
        if (make == "Ford") {
            return new FordBuilder()
        } else if (make == "Toyota") {
            return new ToyotaBuilder()
        } else if (make == "Porsche") {
            return new PorscheBuilder()
        }
    }

}
