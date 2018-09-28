package pattern.structural

class SQLInsert extends SQLStatement {
    def from(obj, columnMap) {
        def stmt = new StringBuffer()
        stmt .append("INSERT INTO ")
        stmt .append(columnMap .tableName)
        stmt .append(" ")
        def cols = columnMap .columnNames() .inject("") { result, it -> result + ", " + it } .drop(1)
        stmt .append("(" + cols + ")")
        def vals = columnMap .valuesFrom(obj) .inject("") { result, it -> result + ", " + quote(it)} .drop(1)
        stmt .append(" VALUES ")
        stmt .append("(" + vals + ")")
        stmt .toString()
    }
}
