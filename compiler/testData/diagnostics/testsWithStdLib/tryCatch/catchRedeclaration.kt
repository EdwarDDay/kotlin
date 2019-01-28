// !WTIH_NEW_INFERENCE

class MyException : Exception() {
    val myField = "field"
}

fun test1() {
    val <!UNUSED_VARIABLE!>e<!> = "something"
    try {}
    catch (e: Exception) {
        e.message
        e.<!UNRESOLVED_REFERENCE!>length<!>
    }
}

fun test2() {
    try {}
    catch (e: Exception) {
        val <!NAME_SHADOWING!>e<!> = "something"
        e.<!UNRESOLVED_REFERENCE!>message<!>
        e.length
    }
}

fun test3() {
    try {}
    catch (e: MyException) {
        e.myField
    }
}

fun test4() {
    try {}
    catch (e: Exception) {
        val <!REDECLARATION, UNUSED_VARIABLE!>a<!> = 42
        val <!NAME_SHADOWING, REDECLARATION, UNUSED_VARIABLE!>a<!> = "foo"
    }
}