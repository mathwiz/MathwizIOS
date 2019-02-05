package sample

class Functional {
    def inc(int n) { n + 1 }

    static void main(String[] args) {
        def instance = new Functional()
        [1, 2, 3, 4].collect({ instance.inc(it) }).each { println it }
    }
}
