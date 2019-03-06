package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.TuttleButton

import java.applet.Applet
import java.awt.FlowLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Panel
import java.awt.event.ActionListener

class SemiDirectTuttleInterface extends Panel {
    Applet sendToHere
    Panel foregroundPanel, backgroundPanel, screenPanel, penPanel, movementPanel
    def movementButtons = [:]
    def screenButtons = [:]
    def penButtons = [:]
    def backgroundButtons = [:]
    def foregroundButtons = [:]
    def movementButtonNames = ["goForward", "goBackward", "turnLeft", "turnRight"]
    def screenButtonNames = ["clear", "reset", "clearAndReset"]
    def penButtonNames = ["penUp", "penDown"]
    def backgroundButtonNames = ["backgroundRed", "backgroundBlue", "backgroundYellow", "backgroundGreen", "backgroundWhite", "backgroundBlack"]
    def foregroundButtonNames = ["foregroundRed", "foregroundBlue", "foregroundYellow", "foregroundGreen", "foregroundWhite", "foregroundBlack"]

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

        doMovementPanel("turnLeft", makeConstraints(0, 1, 1, 2), movementLayout, movementPanel)
        doMovementPanel("goForward", makeConstraints(1, 0, 1, 2), movementLayout, movementPanel)
        doMovementPanel("goBackward", makeConstraints(1, 2, 1, 2), movementLayout, movementPanel)
        doMovementPanel("turnRight", makeConstraints(2, 1, 1, 2), movementLayout, movementPanel)

        doGenericPanel(penButtons, penPanel)
        doGenericPanel(screenButtons, screenPanel)
        doGenericPanel(backgroundButtons, backgroundPanel)
        doGenericPanel(foregroundButtons, foregroundPanel)

        tuttleLayout.setConstraints(foregroundPanel, makeConstraints(0, 0, 12, 1, GridBagConstraints.SOUTHEAST))
        tuttleLayout.setConstraints(backgroundPanel, makeConstraints(0, 1, 12, 1, GridBagConstraints.NORTHEAST))
        tuttleLayout.setConstraints(movementPanel, makeConstraints(12, 0, 9, 2, GridBagConstraints.CENTER))
        tuttleLayout.setConstraints(screenPanel, makeConstraints(21, 0, 6, 1, GridBagConstraints.SOUTHWEST))
        tuttleLayout.setConstraints(penPanel, makeConstraints(21, 1, 6, 1, GridBagConstraints.NORTHWEST))
        this.setLayout(tuttleLayout)

        this.add(foregroundPanel)
        this.add(backgroundPanel)
        this.add(movementPanel)
        this.add(screenPanel)
        this.add(penPanel)
    }

    private def doGenericPanel(buttons, panel) {
        panel.setLayout(new FlowLayout())
        buttons.each { k, v ->
            panel.add(v)
        }
    }

    private def doMovementPanel(name, constraints, layout, panel) {
        def btn = movementButtons[name]
        layout.setConstraints(btn, constraints)
        panel.add(btn)
    }

    private def makeConstraints(gridx, gridy, gridWidth, gridHeight, anchor = null) {
        def constraints = new GridBagConstraints()
        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.gridwidth = gridWidth
        constraints.gridheight = gridHeight
        if (anchor != null) {
            constraints.anchor = anchor
        }
        constraints
    }

    private def doCreatButtons(List names, Map holder) {
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
