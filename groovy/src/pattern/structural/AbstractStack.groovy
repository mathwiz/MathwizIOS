package pattern.structural

import sun.reflect.generics.reflectiveObjects.NotImplementedException

class AbstractStack {
    def collection

    def push(obj) {
        throw new NotImplementedException("Subclass responsibility")
    }

    def pop() {
        throw new NotImplementedException("Subclass responsibility")
    }

    def peek() {
        throw new NotImplementedException("Subclass responsibility")
    }
}
