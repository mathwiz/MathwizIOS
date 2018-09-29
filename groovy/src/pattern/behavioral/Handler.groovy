package pattern.behavioral

class Handler {
    def next, strategy, decider, name

    def handle(data) {
        println("${name} checking.")
        decider(data) ? strategy(data) : next .handle(data)
    }
}
