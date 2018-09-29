package pattern.behavioral

class MenuItem {
    def name, command

    def clicked() {
        command .execute()
    }
}
