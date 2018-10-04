package sample

import pattern.creational.FordBuilder2
import pattern.creational.PorscheBuilder2
import pattern.creational.ToyotaBuilder2

class FactoryMethodExample1 extends BuilderExample1 {
    def doIt() {
        println("Factory Method")
        println("Notice that the Builder subclasses use Factory Method")
        def builder
        println("Building a Ford")
        builder = chooseManufacturer("Ford")
        builder .addChassis() .addEngine() .addTransmission()
        println(builder .build())
        println("Building a Porsche")
        builder = chooseManufacturer("Porsche")
        builder .addChassis() .addEngine() .addTransmission()
        println(builder .build())
        println("Building a Toyota")
        builder = chooseManufacturer("Toyota")
        builder .addChassis() .addEngine() .addTransmission()
        println(builder .build())
    }

    def chooseManufacturer(make) {
        println("Simulating a user selection of ${make} from a menu")
        if (make == "Ford") {
            return new FordBuilder2()
        } else if (make == "Toyota") {
            return new ToyotaBuilder2()
        } else if (make == "Porsche") {
            return new PorscheBuilder2()
        }
    }
}
