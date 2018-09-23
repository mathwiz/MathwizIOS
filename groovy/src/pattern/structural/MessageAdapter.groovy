package pattern.structural

class MessageAdapter {
    def adaptee, getter, setter

    def static on(anAdaptee) {
        new MessageAdapter(adaptee: anAdaptee)
    }

    def static onWith(anAdaptee, anAspect) {
        def instance = new MessageAdapter(adaptee: anAdaptee)
        instance.onAspect(anAspect)
        instance
    }

    def setGetter(selector) {
        getter = selector
    }

    def setSetter(selector) {
        setter = selector
    }

    def onAspect(aString) {
        setGetter "get".concat(aString)
        setSetter "set".concat(aString)
    }

    def getValue() {
        adaptee."${getter}"()
    }

    def setValue(arg) {
        adaptee."${setter}"(arg)
    }
}
