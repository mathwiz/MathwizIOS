package pattern.structural

import pattern.SubclassReponsibility

class DatabaseConnection {
    def connString

    def execute(statement) {
        throw new SubclassReponsibility()
    }

    def connect() {
        println("Connecting to database with ${connString}")
    }

    def disconnect() {
        println("Disconnecting from database with ${connString}")
    }
}
