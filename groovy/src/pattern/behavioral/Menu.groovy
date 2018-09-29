package pattern.behavioral

class Menu {
    private Map<String, MenuItem> items = [:]
    def container

    def add(MenuItem menuItem) {
        items[menuItem.name] = menuItem
        this
    }

    def select(String selector) {
        items[selector] .clicked()
    }

    def show() {
        def labels = new ArrayList(items.keySet())
        Collections.sort(labels)
        println()
        labels .each { println("- ${it}") }
        print("Enter selection: ")
    }
}
