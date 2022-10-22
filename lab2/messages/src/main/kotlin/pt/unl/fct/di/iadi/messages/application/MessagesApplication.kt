package pt.unl.fct.di.iadi.messages.application

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.messages.data.MessageDAO
import pt.unl.fct.di.iadi.messages.presentation.MessageCreateDTO
import pt.unl.fct.di.iadi.messages.presentation.MessageDTO
import pt.unl.fct.di.iadi.messages.presentation.MessageListDTO
import pt.unl.fct.di.iadi.messages.service.MessageService
import java.util.*

@Service
class MessagesApplication(val messages: MessageService) {

    fun getMessage(id: Long): MessageDTO {
        val msg: MessageDAO = messages.getMessage(id).get()
        return MessageDTO(0, msg.cc, msg.receiver, msg.subject, msg.body)
    }

    fun getAll(): Collection<MessageListDTO> {
        return convertToMessageListDTO(messages.getAllMessages())
    }

    fun updateMessage(id:Long, value: MessageCreateDTO) {
        messages.updateMessage(id, value)
    }

    fun deleteMessage(id:Long) {
        messages.deleteMessage(id)
    }

    fun getMessagesByName(name:String):Collection<MessageListDTO> {
        return convertToMessageListDTO(messages.getMessagesByName(name))
    }

    private fun convertToMessageListDTO(messages: MutableIterable<MessageDAO>):Collection<MessageListDTO> {
        val msglist : LinkedList<MessageListDTO> = LinkedList<MessageListDTO>()
        val it: Iterator<MessageDAO> = messages.iterator()
        while (it.hasNext()) {
            val msg : MessageDAO = it.next()
            msglist.add(MessageListDTO(msg.id, msg.receiver, msg.cc, msg.subject))
        }
        return msglist
    }
}

