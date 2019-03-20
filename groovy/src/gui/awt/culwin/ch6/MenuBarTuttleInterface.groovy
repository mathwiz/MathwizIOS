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
    def backgroundMenus = [:]
    def foregroundMenus = [:]
    def commandControls = [:]
    def mainMenuNames = ["File", "Move", "Turn", "Colors", "Screen", "Help"]
    def moveCommands = ["5 steps", "10 steps", "25 steps"]
    def turnCommands = ["5 degrees", "15 degrees", "45 degrees"]
    def screenCommands = ["clear", "reset", "clearAndReset"]
    def penCommands = ["penUp", "penDown"]
    def backgroundCommands = ["backgroundRed", "backgroundBlue", "backgroundYellow", "backgroundGreen", "backgroundWhite", "backgroundBlack"]
    def foregroundCommands = ["foregroundRed", "foregroundBlue", "foregroundYellow", "foregroundGreen", "foregroundWhite", "foregroundBlack"]
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

        doCreateMenus(["TurnRight", "TurnLeft"], turnMenus)
        addSubItems(mainMenus["Turn"], turnMenus)
        doCreateControls(turnCommands, "TurnRight", commandControls)
        addSubItems(turnMenus["TurnRight"], filterControls("TurnRight", turnCommands))
        doCreateControls(turnCommands, "TurnLeft", commandControls)
        addSubItems(turnMenus["TurnLeft"], filterControls("TurnLeft", turnCommands))
//
//        doCreateControls(screenCommands, screenMenus)
//        addSubItems(mainMenus["Screen"], fileMenus)
//
//        doCreateControls(penCommands, penMenus, true)
//        doCreateControls(backgroundCommands, backgroundMenus, true)
//        doCreateControls(foregroundCommands, foregroundMenus, true)
    }

    def setForegroundCheckmark(which) {

    }

    def setBackgroundCheckmark(which) {

    }

    def setPenUpCheckmark(selected) {
//        penMenus["penUp"].setState(selected)
    }

    def setPenDownCheckmark(selected) {
//        penMenus["penDown"].setState(selected)
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
