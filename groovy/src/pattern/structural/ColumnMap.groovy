package pattern.structural

class ColumnMap {
    def columnMappings, tableName

    def static createFrom(obj) {
        def table = obj .getClass() .toString() .split() [1] .split("\\.") .last()
        def properties = namesFrom(obj)
        def mappings = properties .collectEntries { [(it): it] }
        new ColumnMap(columnMappings: mappings, tableName: table)
    }

    def static namesFrom(obj) {
        obj.getClass().declaredFields.findAll { !it.synthetic } *.name
    }

    def columnNames() {
        columnMappings .keySet() as List
    }

    def valuesFrom(obj) {
        columnNames() .collect() { obj ."${columnMappings[it]}" }
    }
}
