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
    def movementMenus = [:]
    def screenMenus = [:]
    def penMenus = [:]
    def backgroundMenus = [:]
    def foregroundMenus = [:]
    def commandControls = [:]
    def mainMenuNames = ["File", "Move", "Turn", "Colors", "Screen", "Help"]
    def moveCommands = ["5 steps", "10 steps", "25 steps"]
    def turnCommands = ["turnLeft", "turnRight"]
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

        doCreateMenus(["Forward", "Backward"], movementMenus)
        addSubItems(mainMenus["Move"], movementMenus)
        doCreateControls(moveCommands, "Forward", commandControls)
        addSubItems(movementMenus["Forward"], filterCommandControls("Forward", moveCommands))


//        addSubItems(mainMenus["Turn"], movementMenus)
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

    def filterCommandControls(menu, commands) {
        commandControls.subMap(commands.collect { menu + " " + it })
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
        def btn = checkbox ? new CheckboxMenuItem(name) : new MenuItem(name)
        btn.setActionCommand(name)
        btn.addActionListener(sendToHere as ActionListener)
        btn
    }
}
