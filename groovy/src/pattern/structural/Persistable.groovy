package pattern.structural

import pattern.SubclassReponsibility

class Persistable {
    def isPersistent = false

    def getKey() {
        throw new SubclassReponsibility()
    }
}
