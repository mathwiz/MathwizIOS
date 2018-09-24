package pattern.creational

class PrototypicalPlayer {
    Integer draft_position = 30
    Integer years = 4
    Integer pro_bowls = 0
    String college_type = "major"

    def copy() {
        new PrototypicalPlayer()
    }

    String toString() {
        "Years: ${years}, College: ${college_type}, Pro Bowls: ${pro_bowls}, Draft pos: ${draft_position}"
    }
}
