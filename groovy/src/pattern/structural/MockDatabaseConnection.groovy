package pattern.structural

class MockDatabaseConnection extends DatabaseConnection {
    private Map mockDB = [
            "Aaron Rodgers": [pos: "qb", points: 43],
            "LeVeon Bell": [pos: "rb", points: 0],
            "James Conner": [pos: "rb", points: 350],
            "Peyton Barber": [pos: "rb", points: 22],
            "Dion Lewis": [pos: "rb", points: 33],
            "Rashaad Penny": [pos: "rb", points: 1],
            "Derrick Henry": [pos: "rb", points: 3],
            "Jordan Wilkins": [pos: "rb", points: 7],
            "Julio Jones": [pos: "wr", points: 180],
            "Tyreek Hill": [pos: "wr", points: 322],
            "Marquise Goodwin": [pos: "wr", points: 23],
            "Kenny Golladay": [pos: "wr", points: 196],
            "Sammy Watkins": [pos: "wr", points: 74],
            "Kenny Stills": [pos: "wr", points: 77],
            "Greg Olsen": [pos: "te", points: 4],
            "David Njoku": [pos: "te", points: 7],
            "Case Keenum": [pos: "qb", points: 17]
    ]

    MockDatabaseConnection() {
        connString = "mock"
    }

    def execute(statement) {
        println("executing... ${statement}")
        statement
    }

}
