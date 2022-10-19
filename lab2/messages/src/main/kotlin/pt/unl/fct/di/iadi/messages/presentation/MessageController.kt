package pt.unl.fct.di.iadi.messages.presentation

import org.springframework.web.bind.annotation.RestController
import pt.unl.fct.di.iadi.messages.application.MessagesApplication
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.service.MessageService

@RestController
class MessageController(val app: MessagesApplication, val messages: MessageService) : MessageAPI {

    override fun getAll(): Collection<MessageListDTO> {
        TODO("Not yet implemented")
    }

    override fun getOne(receiver: String): MessageDTO =
        app.getMessage(receiver)

    override fun addOne(value: MessageCreateDTO) {
        messages.addMessage(value.receiver, value.subject, value.body)
        print(value)
    }

    override fun updateOne(id: Long, value: MessageCreateDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteOne(id: Long) {
        TODO("Not yet implemented")
    }

}