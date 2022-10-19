package pt.unl.fct.di.iadi.messages.service

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.domain.MessageDomainService
import pt.unl.fct.di.iadi.messages.presentation.MessageRepository
import java.util.*

@Service
class MessageService(val messageDomain: MessageDomainService, val messages: MessageRepository) {

    fun addMessage(receiver:String, subject:String, msg:String) { messageDomain.addMessage(receiver, subject, msg) }

    fun getMessage(receiver:String): Optional<MessageDAO> = messageDomain.findByReceiver(receiver)

}