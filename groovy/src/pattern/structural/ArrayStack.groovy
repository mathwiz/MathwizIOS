package pattern.structural

class ArrayStack extends AbstractStack {
    ArrayStack() {
        collection = new ArrayList()
    }

    def push(obj) {
        collection .add(0, obj)
    }

    def pop() {
        collection .remove(0)
    }

    def peek() {
        collection .get(0)
    }
}
