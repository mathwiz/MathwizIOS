package pattern.structural

class ListStack extends AbstractStack {
    ListStack() {
        collection = new LinkedList()
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
