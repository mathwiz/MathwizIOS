package pattern.behavioral

class Menu {
    private Map<String, MenuItem> items = [:]

    def add(menuItem) {
        items[menuItem .name] = menuItem
    }

    def select(String selector) {
        items[selector] .clicked
    }
}
