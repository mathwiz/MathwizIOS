package pattern.structural

import pattern.SubclassReponsibility

class VisualComponent {
    def draw(graphicsContext) {
        throw new SubclassReponsibility()
    }
}
