package pt.unl.fct.di.iadi.messages.presentation

import org.springframework.data.repository.CrudRepository
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import java.util.*

interface MessageRepository : CrudRepository<MessageDAO, Long> {

    fun findByReceiver(receiver:String):Optional<MessageDAO>

}