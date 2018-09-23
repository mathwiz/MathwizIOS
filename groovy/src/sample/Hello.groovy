package sample

class Hello {
    static class Helper {
        def foo

        def setFoo(arg) { foo = arg }
    }

    String name

    def greet() { "Hello ${name}" }

    def static main(String... args) {
        def helloworld = new Hello(name: "Gill")
        println helloworld.greet()

        println new Helper().setFoo(3)
    }
}
