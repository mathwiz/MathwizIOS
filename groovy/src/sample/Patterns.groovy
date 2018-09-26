package sample

class Patterns {
    def static main(String... args) {
        switch (args[0]) {
            case "prototype":
                new PrototypeExample1() .doIt()
                break
            case "singleton":
                new SingletonExample1() .doIt()
                break
            case "adapter":
                new TailoredAdapterExample() .doIt()
                new MessageAdapterExample() .doIt()
                new ParameterizedAdapterExample() .doIt()
                break
            case "bridge":
                new BridgeExample1() .doIt()
                break
            case "composite":
                new CompositeExample1() .doIt()
                break
            case "decorator":
                new DecoratorExample1() .doIt()
                break
            default:
                println "no pattern: ${args[0]}"
        }
    }
}
