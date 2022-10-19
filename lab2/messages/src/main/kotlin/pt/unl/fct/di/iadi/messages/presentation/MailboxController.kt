package pt.unl.fct.di.iadi.messages.presentation

import org.springframework.web.bind.annotation.RestController

@RestController
class MailboxController(): MailBoxAPI {
    override fun getAllMessageThreads(package_id: Long): Collection<MessageListDTO> {
        TODO("Not yet implemented")
    }

    override fun addOne(package_id: Long, value: MessageCreateDTO) {
        TODO("Not yet implemented")
    }

    override fun initMailbox(value: MessageCreateDTO) {
        print(value)
    }
}