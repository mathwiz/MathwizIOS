package gui.awt.culwin.ch9

import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class DatePanelDemonstration extends Applet implements ActionListener{
    DatePanel datePanel

    void init(){
        Properties preset = System.getProperties()
        String lang = preset.getProperty("user.language")
        println "Language: ${lang}"

        datePanel = new DatePanel()
        datePanel.setActionCommand("DatePanelDemonstration Applet")
        datePanel.addActionListener(this)
        add(datePanel)
    }

    @Override
    void actionPerformed(ActionEvent e) {
        println "Action Event received by DatePanelDemonstration"
        print " originating from ${e.getActionCommand()}"
        println "Date: ${datePanel.dayIs()}/${datePanel.monthIs()}/${datePanel.yearIs()}"
    }

    static void main(String[] args) {
        def frame = new Frame("DatePanelDemonstration")
        def theInterface = new DatePanelDemonstration()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
