package gui.awt.culwin.c3.datepanel


import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class MonthPanel extends Panel implements ActionListener {
    static final int MAX_BOXES = 37
    static String[] dayNames = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]

    DayBox[] dayBoxes = new DayBox[MAX_BOXES]
    int highlighted
    int firstBox
    ActionListener passUpToHere

    MonthPanel(ActionListener listener) {
        Label[] dayLabels = new Label[7]
        setLayout(new GridLayout(7, 7, 0, 0))

        for (int i = 0; i < 7; i++) {
            dayLabels[i] = new Label(dayNames[i], Label.CENTER)
            add(dayLabels[i])
        }

        for (int i = 0; i < MAX_BOXES; i++) {
            dayBoxes[i] new DayBox(i, this)
            add(dayBoxes[i])
        }

        passUpToHere = listener
    }

    void reConfigure(int year, int month, int day) {
        int maxDay = DateUtility.daysThisMonthIs(year, month)
        int startDay = DateUtility.firstDayOfMonthIs(year, month)
        firstBox = startDay
        day = day > maxDay ? maxDay : day
        dayBoxes[highlighted].clearHighlight()
        for (int i = 0; i < MAX_BOXES; i++) {
            if (i < startDay || i >= (startDay + maxDay)) {
                dayBoxes[i].setDayNumber(0)
            } else {
                dayBoxes[i].setDayNumber(i - startDay + 1)
            }
            dayBoxes[i].repaint()
        }
        dayBoxes[firstBox + day - 1].setHighlight()
        highlighted = firstBox + day - 1
    }

    int dayIs() {
        highlighted - firstBox + 1
    }

    @Override
    void actionPerformed(ActionEvent e) {
        DayBox source = e.getSource() as DayBox
        dayBoxes[highlighted].clearHighlight()
        source.setHighlight()
        highlighted = source.getOrdinal()
        passUpToHere.actionPerformed(e)
    }
}
