package sample

class Patterns {
    def static main(String... args) {
        switch (args[0]) {
            case "absfact":
                new AbstractFactoryExample1() .doIt()
                break
            case "builder":
                new BuilderExample1() .doIt()
                break
            case "factmeth":
                break
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
            case "facade":
                new FacadeExample1() .doIt()
                break
            case "flyweight":
                new FlyweightExample1() .doIt()
                break
            case "proxy":
                new ProxyExample1() .doIt()
                break
            case "chain":
                new CORExample1() .doIt()
                break
            case "command":
                new CommandExample1() .doIt()
                break
            case "interpreter":
                new InterpreterExample1() .doIt()
                break
            case "iterator":
                new IteratorExample1() .doIt()
                break
            case "mediator":
                new MediatorExample1() .doIt()
                break
            case "memento":
                new MementoExample1() .doIt()
                break
            case "observer":
                new ObserverExample1() .doIt()
                break
            case "state":
                break
            case "strategy":
                break
            case "templatemeth":
                break
            case "visitor":
                break
            default:
                println "no pattern: ${args[0]}"
        }
    }
}
