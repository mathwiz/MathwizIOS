package gui.awt.culwin.ch9

import gui.awt.culwin.c3.datepanel.DateUtility
import gui.awt.culwin.c3.datepanel.MonthPanel

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class DatePanel extends Panel implements ActionListener, ItemListener {

    MonthPanel monthPanel
    Choice centuryChoice, decadeChoice, yearChoice, monthChoice
    String actionCommand
    ActionListener listener
    ResourceBundle resources

    DatePanel() {
        this(DateUtility.yearIs(), DateUtility.monthIs(), DateUtility.dayOfMonthIs())
    }

    DatePanel(int year, int month, int day) {
        resources = ResourceBundle.getBundle("gui.awt.culwin.ch9.DatePanelResources")
        String[] monthNames = resources.getObject("monthNames") as String[]

        Panel topPanel = new Panel()
        Panel topLeftPanel = new Panel()
        Panel topRightPanel = new Panel()
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
        centuryChoice.select((year / 100) - 20 as Integer)
        decadeChoice.select((year % 100) / 10 as Integer)
        yearChoice.select(year % 10)
        monthChoice.select(month - 1)
        monthPanel.reConfigure(year, month, dayOfMonth)
        dateSelected()
    }

    int yearIs() {
        Integer.valueOf(centuryChoice.getSelectedItem() +
                decadeChoice.getSelectedItem() +
                yearChoice.getSelectedItem())
    }

    int monthIs() {
        monthChoice.getSelectedIndex() + 1
    }

    int dayIs() {
        monthPanel.dayIs()
    }

    @Override
    void actionPerformed(ActionEvent e) {
        dateSelected()
    }

    @Override
    void itemStateChanged(ItemEvent e) {
        monthPanel.reConfigure(yearIs(), monthIs(), dayIs())
        dateSelected()
    }

    void setActionCommand(String command) {
        actionCommand = command
    }

    String getActionCommand() {
        actionCommand ?: "Date Panel"
    }

    void addActionListener(ActionListener listener) {
        this.listener = AWTEventMulticaster.add(this.listener, listener)
    }

    void removeActionListener(ActionListener listener) {
        this.listener = AWTEventMulticaster.remove(this.listener, listener)
    }

    void dateSelected() {
        if (this.listener != null) {
            this.listener.actionPerformed(new ActionEvent(this,
                    ActionEvent.ACTION_PERFORMED,
                    getActionCommand()))
        }
    }
}
