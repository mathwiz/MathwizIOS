package pattern.structural

import pattern.SubclassReponsibility

abstract class Asset {
    def name, id, container

    def value() {
        throw new SubclassReponsibility()
    }

    def containsSecurity(aSecurity) {
        throw new SubclassReponsibility()
    }

    def description() {
        "$name($id)"
    }

    def draw() {
        println(description())
    }

    def depth() {
        container == null ? 0 : 1 + container.depth()
    }

    def padding() {
        def pad = ""
        1 .upto(depth()) {
            pad += "    "
        }
        pad
    }
}
