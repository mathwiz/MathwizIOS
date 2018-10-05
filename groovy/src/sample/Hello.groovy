package sample

class Hello {
    static class Helper {
        def foo

        def setFoo(arg) { foo = "(From setter: ${arg})" }

        def getFoo() { "Using getter method: ${foo}" }
    }

    String name

    def greet() { "Hello ${name}" }

    def static main(String... args) {
        def helloworld = new Hello(name: "Gill")
        println helloworld.greet()

        println new Helper().setFoo(3)

        def helper = new Helper(foo: "foo from constructor")
        println(helper .foo)

        helper .foo = "foo from property"
        println(helper .foo)

    }
}
