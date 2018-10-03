package sample

import pattern.behavioral.Letter
import pattern.behavioral.Log
import pattern.behavioral.TextAlert
import pattern.behavioral.YTextField

class ObserverExample1 {
    def doIt() {
        def alerter = new TextAlert()
        def log = new Log()
        log.append("Starting Observer example")

        def field = new YTextField()
        field.addActionMessage(
                new Letter(event: "changed",
                        block: { details -> alerter.alert("Text action from '${details.oldValue}' to '${details.newValue}'") })
        )
        field.addActionMessage(
                new Letter(event: "changed",
                        block: { details -> log.append("Text action from '${details.oldValue}' to '${details.newValue}'") })
        )

        field .setText("first input to field")
        field .setText("second input to field")
        field.show()

        log .replay()
    }
}
