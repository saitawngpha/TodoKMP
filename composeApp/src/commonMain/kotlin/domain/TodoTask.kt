package domain

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 24/03/2024.
 */
class TodoTask: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var title: String = ""
    var description: String = ""
    var favorite: Boolean = false
    var completed: Boolean = false
}