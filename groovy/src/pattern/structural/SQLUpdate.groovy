package pattern.structural

class SQLUpdate extends SQLStatement {
    def from(obj, columnMap) {
        def stmt = new StringBuffer()
        stmt .append("UPDATE ")
        stmt .append(columnMap .tableName)
        stmt .append(" SET ")
        def cols = columnMap .columnNames() .inject("") { result, it -> result + ", " + it + "=" + quote(obj ."${columnMap .columnMappings[it]}") } .drop(1)
        stmt .append(cols)
        stmt .append(" WHERE ")
        stmt .append(" key= ")
        stmt .append(quote(obj .key))
        stmt .toString()
    }
}
