package gui.awt.culwin.c3.datepanel

class DateUtility {
    static int daysThisMonthIs(int thisYear, int thisMonth) {
        switch (thisMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30
            case 2:
                if (isLeapYear(thisYear)) {
                    return 29
                }
                return 28
            default:
                return 31
        }
    }

    static boolean isLeapYear(int year) {
        (year % 400) || (year % 4 && !(year % 100))
    }

    /**
     * Use Zeller's congruence to calculate day of week of a date
     * @param thisYear
     * @param thisMonth 1 for January...
     * @param thisDay
     * @return 7 for Sunday, 1 for Monday, ..., 6 for Saturday
     */
    static int dayOfWeekIs(int thisYear, int thisMonth, int thisDay) {
        int Q = thisDay
        int y = thisMonth < 3 ? thisYear - 1 : thisYear
        int m = thisMonth < 3 ? thisMonth + 12 : thisMonth
        int M = Math.floorDiv(13 * (m + 1), 5)
        int K = y % 100
        int J = Math.floorDiv(y, 100)

        int zeller = (Q + M + K + Math.floorDiv(K, 4) + Math.floorDiv(J, 4) + (5 * J)) % 7

        ((zeller + 5) % 7) + 1
    }

    static int firstDayOfMonthIs(int thisYear, int thisMonth){
        dayOfWeekIs(thisYear, thisMonth, 1)
    }

    public static void main(String[] args) {
        println dayOfWeekIs(2019, 1, 23) //Wednesday
        println dayOfWeekIs(1968, 11, 10) //Sunday
        println dayOfWeekIs(2018, 2, 2) //Friday
        println dayOfWeekIs(2018, 12, 25) //Tuesday
    }
}
