package pattern.structural

class BasicStack extends StackAbstraction {
    def push(obj) {
        impl.push(obj)
    }

    def pop() {
        impl.pop()
    }
}
