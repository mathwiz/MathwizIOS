package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.TuttleButton

import java.applet.Applet
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Panel
import java.awt.event.ActionListener

class SemiDirectTuttleInterface {
    Applet sendToHere
    Panel foregroundPanel, backgroundPanel, screenPanel, penPanel, movementPanel
    def movementButtons = [:]
    def screenButtons = [:]
    def penButtons = [:]
    def backgroundButtons = [:]
    def foregroundButtons = [:]
    def movementButtonNames = ["goForward", "goBackward", "turnLeft", "turnRight" ]
    def screenButtonNames = [ "clear", "reset", "clearAndReset" ]
    def penButtonNames = [ "penUp", "penDown" ]
    def backgroundButtonNames = [ "backgroundRed", "backgroundBlue", "backgroundYellow", "backgroundGreen", "backgroundWhite", "backgroundBlack" ]
    def foregroundButtonNames = [ "foregroundRed", "foregroundBlue", "foregroundYellow", "foregroundGreen", "foregroundWhite", "foregroundBlack" ]

    def tuttleLayout = new GridBagLayout()
    def movementLayout = new GridBagLayout()

    SemiDirectTuttleInterface(Applet myApplet) {
        sendToHere = myApplet

        foregroundPanel = new Panel()
        backgroundPanel = new Panel()
        screenPanel = new Panel()
        penPanel = new Panel()
        movementPanel = new Panel()

        doCreatButtons(movementButtonNames, movementButtons)
        doCreatButtons(screenButtonNames, screenButtons)
        doCreatButtons(penButtonNames, penButtons)
        doCreatButtons(backgroundButtonNames, backgroundButtons)
        doCreatButtons(foregroundButtonNames, foregroundButtons)

        movementPanel.setLayout(movementLayout)

        doMovementButton("turnLeft", makeConstraints(0,1,1,2), movementLayout, movementPanel)
        doMovementButton("goForward", makeConstraints(1,0,1,2), movementLayout, movementPanel)
        doMovementButton("goBackward", makeConstraints(1,2,1,2), movementLayout, movementPanel)
        doMovementButton("turnRight", makeConstraints(1,1,1,2), movementLayout, movementPanel)
    }

    private def doMovementButton(name, constraints, layout, panel) {
        def btn = movementButtons[name]
        layout.setConstraints(btn, constraints)
        panel.add(btn)
    }

    private def makeConstraints(gridx, gridy, gridWidth, gridHeight) {
        def constraints = new GridBagConstraints()
        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.gridwidth = gridWidth
        constraints.gridheight = gridHeight
        constraints
    }

    private def doCreatButtons(String names, Map holder) {
        names.each {
            holder[it] = makeButton(it)
        }
    }

    private def makeButton(String name) {
        def btn = new TuttleButton("${name}.gif", sendToHere)
        btn.setActionCommand(name)
        btn.addActionListener(sendToHere as ActionListener)
        btn
    }
}
