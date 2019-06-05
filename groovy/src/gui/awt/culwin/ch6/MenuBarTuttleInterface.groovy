package gui.awt.culwin.ch6


import java.awt.*
import java.awt.event.ActionListener
import java.util.List

class MenuBarTuttleInterface {
    ActionListener sendToHere
    Frame myFrame
    MenuBar mainMenuBar = new MenuBar()

    def mainMenus = [:]
    def fileMenus = [:]
    def moveMenus = [:]
    def turnMenus = [:]
    def colorMenus = [:]
    def commandControls = [:]
    def mainMenuNames = ["File", "Move", "Turn", "Colors", "Screen", "Help"]
    def moveCommands = ["10 steps", "25 steps", "50 steps", "100 steps"]
    def turnCommands = ["5 degrees", "15 degrees", "45 degrees", "90 degrees"]
    def screenCommands = ["Clear", "Reset", "Clear and Reset"]
    def penCommands = ["Pen Up", "Pen Down"]
    def colorCommands = ["Red", "Blue", "Yellow", "Green", "White", "Black"]
    def helpCommands = ["Version", "Help"]

    MenuBarTuttleInterface(Frame frame, ActionListener listener) {
        sendToHere = listener
        myFrame = frame

        myFrame.setMenuBar(mainMenuBar)

        doCreateMenus(mainMenuNames, mainMenus)
        addSubItems(mainMenuBar, mainMenus)

        doCreateControls(["Exit ..."], "File", fileMenus)
        addSubItems(mainMenus["File"], fileMenus)

        doCreateMenus(["Forward", "Backward"], moveMenus)
        addSubItems(mainMenus["Move"], moveMenus)
        doCreateControls(moveCommands, "Forward", commandControls)
        addSubItems(moveMenus["Forward"], filterControls("Forward", moveCommands))
        doCreateControls(moveCommands, "Backward", commandControls)
        addSubItems(moveMenus["Backward"], filterControls("Backward", moveCommands))

        doCreateMenus(["Turn Right", "Turn Left"], turnMenus)
        addSubItems(mainMenus["Turn"], turnMenus)
        doCreateControls(turnCommands, "Turn Right", commandControls)
        addSubItems(turnMenus["Turn Right"], filterControls("Turn Right", turnCommands))
        doCreateControls(turnCommands, "Turn Left", commandControls)
        addSubItems(turnMenus["Turn Left"], filterControls("Turn Left", turnCommands))

        doCreateMenus(["Foreground", "Background"], colorMenus)
        addSubItems(mainMenus["Colors"], colorMenus)
        doCreateControls(colorCommands, "Background", commandControls)
        addSubItems(colorMenus["Background"], filterControls("Background", colorCommands))
        doCreateControls(colorCommands, "Foreground", commandControls)
        addSubItems(colorMenus["Foreground"], filterControls("Foreground", colorCommands))

        doCreateControls(screenCommands, "Screen", commandControls)
        addSubItems(mainMenus["Screen"], filterControls("Screen", screenCommands[0..1]))
        mainMenus["Screen"].addSeparator()
        addSubItems(mainMenus["Screen"], filterControls("Screen", screenCommands[2..2]))
        mainMenus["Screen"].addSeparator()
        doCreateControls(penCommands, "Screen", commandControls)
        addSubItems(mainMenus["Screen"], filterControls("Screen", penCommands))

        doCreateControls(helpCommands, "Help", commandControls)
        addSubItems(mainMenus["Help"], filterControls("Help", helpCommands))
    }

    def setForegroundCheckmark(which) {

    }

    def setBackgroundCheckmark(which) {

    }

    def setPenUpCheckmark(selected) {
        def it = filterControls("Screen", ["Pen Up"])
        println it["Screen Pen Up"]
    }

    def setPenDownCheckmark(selected) {
        def it = filterControls("Screen", ["Pen Down"])
        println it["Screen Pen Down"]
    }

    def filterControls(parentName, names) {
        commandControls.subMap(names.collect { parentName + " " + it })
    }

    private def addSubItems(master, subs) {
        subs.each { k, v ->
            master.add(v)
        }
    }

    private def doCreateMenus(List names, Map holder, checkbox=false) {
        names.each {
            holder[it] = new Menu(it)
            holder[it].setActionCommand(it)
            holder[it].addActionListener(sendToHere as ActionListener)
        }
    }

    private def doCreateControls(List names, String menu, Map holder, checkbox=false) {
        names.each {
            def command = menu + " " + it
            holder[command] = makeButton(command, checkbox)
        }
    }

    private def makeButton(String name, checkbox=false) {
        def tokens = name.split(" ")
        def label = tokens.tail().join(" ")
        def btn = checkbox ? new CheckboxMenuItem(label) : new MenuItem(label)
        println "Created ${btn} with command: ${name}"
        btn.setActionCommand(name)
        btn.addActionListener(sendToHere as ActionListener)
        btn
    }
}
