package pattern.structural

import sun.reflect.generics.reflectiveObjects.NotImplementedException

class StackAbstraction {
    def impl

    def push(obj) {
        throw new NotImplementedException("Subclass responsibility")
    }

    def pop() {
        throw new NotImplementedException("Subclass responsibility")
    }
}
