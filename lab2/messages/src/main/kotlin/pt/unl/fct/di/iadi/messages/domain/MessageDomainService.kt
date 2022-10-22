package pt.unl.fct.di.iadi.messages.domain

import java.security.InvalidParameterException
import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.data.MessageRepository
import pt.unl.fct.di.iadi.messages.presentation.MessageCreateDTO
import pt.unl.fct.di.iadi.messages.presentation.MessageListDTO
import java.util.*

@Service
class MessageDomainService(val messages: MessageRepository) {


    fun addMessage(receiver: String, cc: String, subject: String, body: String) {
        if (receiver.isEmpty())
            throw InvalidParameterException("Message receiver is empty")
        if (subject.isEmpty())
            throw InvalidParameterException("Message subject is empty")
        if (body.isEmpty())
            throw InvalidParameterException("Message body is empty")
        messages.save(MessageDAO(0, receiver, cc, subject, body))
    }

    fun findById(id: Long): Optional<MessageDAO> {
        val msg: Optional<MessageDAO> = messages.findById(id)
        if (msg.get().equals(null))
            throw InvalidParameterException(String.format("message with id %s does not exist!", id))
        return msg
    }

    fun getAll(): MutableIterable<MessageDAO> = messages.findAll()

    fun updateMessage(id: Long, update: MessageCreateDTO) {
        val msg: MessageDAO = messages.findById(id).get()
        msg.body = update.body
        messages.save(msg)
    }

    fun deleteMessage(id: Long) {
        if (!messages.existsById(id))
            throw InvalidParameterException(String.format("message with id %s does not exist!", id))
        messages.deleteById(id)
    }

    fun getMessagesByName(name: String) : MutableIterable<MessageDAO> = messages.getMessageByName(name)
}
