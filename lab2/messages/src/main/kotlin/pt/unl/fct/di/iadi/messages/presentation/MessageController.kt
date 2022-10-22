package pt.unl.fct.di.iadi.messages.presentation

import org.springframework.web.bind.annotation.RestController
import pt.unl.fct.di.iadi.messages.application.MessagesApplication
import pt.unl.fct.di.iadi.messages.service.MessageService

@RestController
class MessageController(val app: MessagesApplication, val messages: MessageService) : MessageAPI {

    override fun getAll(): Collection<MessageListDTO> = app.getAll()

    override fun getOne(id: Long): MessageDTO =
        app.getMessage(id)

    override fun addOne(value: MessageCreateDTO) {
        messages.addMessage(value.receiver, value.cc, value.subject, value.body)
    }

    override fun updateOne(id: Long, value: MessageCreateDTO) {
        app.updateMessage(id, value)
    }

    override fun deleteOne(id: Long) {
        app.deleteMessage(id)
    }

    override fun getMessagesByName(name: String): Collection<MessageListDTO> =
        app.getMessagesByName(name)
}