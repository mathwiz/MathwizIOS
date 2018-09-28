package pattern.structural

class DatabaseBroker {
    def instanceOf(objClass, key) {
        //def clazz = this.getClass().classLoader.loadClass(objClass, true, false)?.newInstance()
        proxy .get(objClass, key)
    }

    def save(anObj) {
        def stmtType = anObj .isPersistent ? "Update" : "Insert"
        def stmtObj = this .getClass() .classLoader .loadClass("pattern.structural.SQL"+stmtType, true, false) ?.newInstance()
        def columnMap = ColumnMap .createFrom(anObj)
        def conn = getConnection()
        conn.connect()
        conn .execute(stmtObj .from(anObj, columnMap))
        conn.disconnect()
    }

    def getConnection() {
        new MockDatabaseConnection()
    }
}
