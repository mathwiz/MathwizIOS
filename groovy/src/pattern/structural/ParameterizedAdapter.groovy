package pattern.structural

class ParameterizedAdapter {
    def adaptee, getBlock, setBlock

    def static on(anObject) {
        new ParameterizedAdapter(adaptee: anObject)
    }

    def setGetBlock(block) {
        getBlock = block
    }

    def setSetBlock(block) {
        setBlock = block
    }

    def getValue() {
        getBlock(adaptee)
    }

    def setValue(newValue) {
        setBlock(adaptee, newValue)
    }
}
