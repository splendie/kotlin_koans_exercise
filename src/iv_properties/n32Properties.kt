package iv_properties

import util.TODO
import util.doc32
import kotlin.reflect.KProperty

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(arg: Int?) {
            field = arg
            counter++
        }

}

//class Delegate() {
//    operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
//        return prop.c
//    }

//    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
//    }
//}

fun todoTask32(): Nothing = TODO(
        """
        Task 32.
        Add a custom setter to 'PropertyExample.propertyWithCounter' so that
        the 'counter' property is incremented every time 'propertyWithCounter' is assigned to.
    """,
        documentation = doc32(),
        references = { PropertyExample() }
)
