package pattern.structural

import pattern.SubclassReponsibility

class SQLStatement {
    def from(obj, columnMap) {
        throw new SubclassReponsibility()
    }

    def quote(str) {
        "\"" + str + "\""
    }
}
