package sample

class Hello {
    String name

    def greet() { "Hello ${name}" }

    def static main(String... args) {
        def helloworld = new Hello(name: "Gill")
        println helloworld.greet()
    }
}
