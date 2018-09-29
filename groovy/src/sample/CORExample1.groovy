package sample

import pattern.behavioral.Handler

class CORExample1 {
    def doIt() {
        println("Chain of Responsibility")

        def assistant = new Handler(name: "Assistant")
        assistant.decider = { it =~ /assist/ }
        assistant.strategy = { println " * Assistant handling"}

        def manager = new Handler(name: "Manager")
        manager.decider = { it =~ /manage/ }
        manager.strategy = { println " * Manager handling"}

        def ceo = new Handler(name: "CEO")
        ceo.decider = { it =~ /strategize/ }
        ceo.strategy = { println " * CEO handling"}

        def no_one = new Handler(name: "Default")
        no_one.decider = { true }
        no_one.strategy = { println " * Maybe get a robot to do this"}

        def important_decision = ceo
        ceo.next = manager
        manager.next = assistant
        assistant.next = no_one

        println("Important decision 1")
        important_decision .handle("You can assist or manage to strategize.")
        println("Important decision 2")
        important_decision .handle("You can assist or manage.")

        def fast_decision = assistant
        assistant.next = manager
        manager.next = ceo
        ceo.next = no_one

        println("Fast decision 1")
        fast_decision .handle("You can assist or manage to strategize.")
        println("Fast decision 2")
        fast_decision .handle("Do this fast!")
    }
}
