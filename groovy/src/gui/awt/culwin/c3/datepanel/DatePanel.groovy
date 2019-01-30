package gui.awt.culwin.c3.datepanel

import java.awt.BorderLayout
import java.awt.Choice
import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.Panel
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class DatePanel extends Panel implements ActionListener, ItemListener {
    static final String[] monthNames = [
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    ]

    MonthPanel monthPanel
    Choice centuryChoice, decadeChoice, yearChoice, monthChoice
    String actionCommand
    ActionListener listener

    DatePanel() {
        this(DateUtility.yearIs(), DateUtility.monthIs(), DateUtility.dayOfMonthIs())
    }

    DatePanel(int year, int month, int day) {
        Panel topPanel, topLeftPanel, topRightPanel
        setLayout(new BorderLayout(4, 4))
        topPanel.setLayout(new GridLayout(1, 2, 4, 4))
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4))
        topRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4))

        monthPanel = new MonthPanel(this)

        centuryChoice = new Choice()
        centuryChoice.addItemListener(this)
        centuryChoice.addItem("19")
        centuryChoice.addItem("20")
        centuryChoice.addItem("21")

        decadeChoice = new Choice()
        decadeChoice.addItemListener(this)

        yearChoice = new Choice()
        yearChoice.addItemListener(this)

        (1..10).each {
            decadeChoice.addItem(it.toString())
            yearChoice.addItem(it.toString())
        }

        monthChoice = new Choice()
        monthChoice.addItemListener(this)
        (0..11).each {
            monthChoice.addItem(monthNames[it])
        }

        topLeftPanel.add(centuryChoice)
        topLeftPanel.add(decadeChoice)
        topLeftPanel.add(yearChoice)
        topRightPanel.add(monthChoice)
        topPanel.add(topLeftPanel)
        topPanel.add(topRightPanel)
        add(topPanel, "North")
        add(monthPanel, "Center")
        setDate(year, month, day)
    }

    void setDate(int year, int month, int dayOfMonth) {

    }

    @Override
    void actionPerformed(ActionEvent e) {

    }

    @Override
    void itemStateChanged(ItemEvent e) {

    }
}
