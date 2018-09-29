package pattern.behavioral

import pattern.SubclassReponsibility

abstract class Command {
    def receiver

    def execute() {
        throw new SubclassReponsibility()
    }
}
