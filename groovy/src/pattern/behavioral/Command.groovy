package pattern.behavioral

import pattern.SubclassReponsibility

abstract class Command {
    def receiver, application

    def execute() {
        handleExecute()
        application .saveForUndo(this)
    }

    def handleExecute() {
        throw new SubclassReponsibility()
    }

    def unexecute() {
        println("No action taken.")
    }
}
