package sample

class Patterns {
    def static main(String... args) {
        switch (args[0]) {
            case "singleton":
                new SingletonExample1() .doIt()
                break
            case "adapter":
                new TailoredAdapterExample() .doIt()
                new MessageAdapterExample() .doIt()
                new ParameterizedAdapterExample() .doIt()
                break
            default:
                println "no pattern: ${args[0]}"
        }
    }
}