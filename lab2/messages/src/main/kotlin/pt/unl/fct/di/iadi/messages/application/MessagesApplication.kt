package pt.unl.fct.di.iadi.messages.application

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.presentation.MessageDTO
import pt.unl.fct.di.iadi.messages.service.MessageService

@Service
class MessagesApplication(val messages: MessageService) {

    fun getMessage(receiver:String): MessageDTO {
        val msg: MessageDAO = messages.getMessage(receiver).get()
        return MessageDTO(0, "miro", msg.receiver, msg.subject, msg.body)
    }
}
