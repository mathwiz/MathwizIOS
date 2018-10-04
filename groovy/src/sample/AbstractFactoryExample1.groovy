package sample

import pattern.creational.Car
import pattern.creational.FordFactory
import pattern.creational.PorscheFactory
import pattern.creational.ToyotaFactory

class AbstractFactoryExample1 {
    def doIt() {
        println("Abstract Factory")
        println("Notice how dependency injection is used in the application")
        makeCar("Ford")
        makeCar("Porsche")
        makeCar("Toyota")
    }

    def makeCar(make) {
        println("Making a ${make}")
        def app = createApplication(make)
        println(app.makeCar())
    }

    def createApplication(make) {
        def factory
        if (make == "Ford") {
            factory = new FordFactory()
        } else if (make == "Toyota") {
            factory = new ToyotaFactory()
        } else if (make == "Porsche") {
            factory = new PorscheFactory()
        }
        new CarMakerApplication(factory: factory)
    }

    class CarMakerApplication {
        def factory

        def makeCar() {
            new Car(chassis: factory.make("chassis"),
                    engine: factory.make("engine"),
                    transmission: factory.make("transmission")
            )
        }
    }
}

