package sample

class Functional {
    int step

    def inc(int n) { n + 1 }

    def increase(int n) { n + step }

    static void main(String[] args) {
        def instance = new Functional()
        [1, 2, 3, 4].collect({ instance.inc(it) }).each { print "${it} " }
        println ""
        def another = new Functional(step: 2)
        [1, 2, 3, 4].collect({ another.increase(it) }).each { print "${it} " }
        println ""
    }
}
