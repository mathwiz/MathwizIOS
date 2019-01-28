package gui.awt.culwin.c3.datepanel


import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class MonthPanel extends Panel implements ActionListener {
    static final int MAX_BOXES = 37
    static String[] dayNames = ["Sun" , "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat"]

    DayBox[] dayBoxes = new DayBox[MAX_BOXES]
    int highlighted
    int firstBox
    ActionListener passUpToHere

    MonthPanel(ActionListener listener) {
        Label[] dayLabels = new Label[7]
        setLayout(new GridLayout(7, 7, 0, 0))
    }

    @Override
    void actionPerformed(ActionEvent e) {

    }
}
