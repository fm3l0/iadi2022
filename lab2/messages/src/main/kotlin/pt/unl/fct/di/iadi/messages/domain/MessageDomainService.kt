package pt.unl.fct.di.iadi.messages.domain

import java.security.InvalidParameterException
import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.presentation.MessageRepository
import java.util.*

@Service
class MessageDomainService(val messages: MessageRepository) {

    fun addMessage(receiver:String, subject:String, msg:String) {
        if (receiver.isEmpty())
            throw InvalidParameterException("No receiver name given")
        messages.save(MessageDAO(receiver, "miro", subject, msg))
    }

    fun findByReceiver(receiver:String): Optional<MessageDAO> = messages.findByReceiver(receiver)
}
