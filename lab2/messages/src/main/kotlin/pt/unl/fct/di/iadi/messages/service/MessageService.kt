package pt.unl.fct.di.iadi.messages.service

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.domain.MessageDomainService
import pt.unl.fct.di.iadi.messages.data.MessageRepository
import pt.unl.fct.di.iadi.messages.presentation.MessageCreateDTO
import pt.unl.fct.di.iadi.messages.presentation.MessageListDTO
import java.util.*

@Service
class MessageService(val messageDomain: MessageDomainService, val messages: MessageRepository) {

    fun addMessage(receiver:String, cc:String, subject:String, msg:String) { messageDomain.addMessage(receiver, cc, subject, msg) }

    fun getMessage(id: Long): Optional<MessageDAO> = messageDomain.findById(id)

    fun getAllMessages(): MutableIterable<MessageDAO> = messageDomain.getAll()

    fun updateMessage(id:Long, msg: MessageCreateDTO) { messageDomain.updateMessage(id, msg)}

    fun deleteMessage(id:Long) { messageDomain.deleteMessage(id)}

    fun getMessagesByName(name:String): MutableIterable<MessageDAO> = messageDomain.getMessagesByName(name)
}