package data

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics

class Stats1 {
    static data1 = [1,2,3,4,5,6,7,8,9,10]

    static main(String... args) {
        println("Descriptive Statistics")
        DescriptiveStatistics stats = new DescriptiveStatistics()
        data1 .each { stats .addValue(it) }
        println(stats .getN())
        println(stats .getSum())
        println(stats .getMean())
    }
}
