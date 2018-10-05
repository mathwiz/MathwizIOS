package sample

class LazyEval {
    def static recommendations(age, region, gender) {
        print("recommendations called...")
        def recs = []
        if (age < 10) {
            recs .add("Barbie")
        }
        if (gender == "male") {
            recs .add("GI Joe")
        }
        if (region == "south") {
            recs .add("Toy Gun")
        }
        if (region == "west") {
            recs .add("Skateboard")
        }
        recs
    }

    static class recommender {
        def age, region, gender

        def doIt() {
            print("recommender .doIt called...")
            def recs = []
            if (age < 10) {
                recs .add("Barbie")
            }
            if (gender == "male") {
                recs .add("GI Joe")
            }
            if (region == "south") {
                recs .add("Toy Gun")
            }
            if (region == "west") {
                recs .add("Skateboard")
            }
            recs
        }
    }

    def static main(String... args) {
        println("\nAt the same time")
        println(recommendations(7, "south", "male"))
        println(new recommender(age: 7, region: "south", gender: "male") .doIt())

        println("\nGather data at various times")
        def rec = new recommender()
        def region = "south"
        rec .region = "south"
        //get data from user
        elapse_time()
        def age = 7
        def gender = "male"
        rec .age = 7
        rec .gender = "male"
        println(recommendations(age, region, gender))
        println(rec .doIt())

        println("\nDefer call after creating calculation")
        def doIt = { recommendations(7, "south", "male") }
        def rec2 = new recommender(age: 7, region: "south", gender: "male")
        //ship to machine with more cycles
        elapse_time()
        println(doIt())
        println(rec2 .doIt())
    }

    private static elapse_time() {
        println("time elapses")
        Thread .sleep(3000)
    }
}
