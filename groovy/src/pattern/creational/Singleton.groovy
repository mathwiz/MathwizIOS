package pattern.creational

class Singleton {
    def static instance
    def static count = 0

    def static getInstance() {
        if (instance == null) {
            instance = new Singleton()
            count = 1
        }
        instance
    }

    def getInstanceCount() {
        count
    }
}
