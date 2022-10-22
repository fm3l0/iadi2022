package pt.unl.fct.di.iadi.messages.data

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MessageRepository : CrudRepository<MessageDAO, Long> {

    override fun findById(id:Long):Optional<MessageDAO>

    override fun findAll(): MutableIterable<MessageDAO>

    override fun deleteById(id:Long)

    @Query(value = "select msg from MessageDAO msg where msg.receiver = :name")
    fun getMessageByName(name:String): MutableIterable<MessageDAO>
}