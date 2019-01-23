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
     * @param thisMonth
     * @param thisDay
     * @return 0 for Sunday, 1 for Monday, ..., 6 for Saturday
     */
    static int dayOfWeekIs(int thisYear, int thisMonth, int thisDay) {
        if (thisMonth < 3) {
            thisMonth += 10
        } else {
            thisMonth -= 2
        }
        int thisCentury = thisYear.intdiv(100)
        thisYear %= 100
        int zellers = ((26 * thisMonth - 2).intdiv(10) +
                thisDay + thisYear.intdiv(4) +
                thisCentury.intdiv(4) -
                2 * thisCentury) % 7

        if (zellers < 0) {
            zellers += 7
        }

        zellers % 7
    }

    static int firstDayOfMonthIs(int thisYear, int thisMonth){
        dayOfWeekIs(thisYear, thisMonth, 1)
    }

    public static void main(String[] args) {
        println dayOfWeekIs(2019, 1, 23) //Wednesday
        println dayOfWeekIs(1968, 11, 10) //Sunday
        println dayOfWeekIs(2018, 2, 2) //Friday
    }
}
