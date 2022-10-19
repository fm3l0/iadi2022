package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("mailbox")
interface MailBoxAPI {

    @Operation(summary = "Get all mailbox messages")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all messages threads", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MessageDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the package", content = [Content()])]
    )
    @GetMapping("{package_id}")
    fun getAllMessageThreads(@PathVariable package_id: Long): Collection<MessageListDTO>

    @Operation(summary = "Add one message to a thread, based on the package_id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Added the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the package", content = [Content()])]
    )
    @PutMapping("")
    fun addOne(@RequestParam package_id: Long, @RequestBody value: MessageCreateDTO):Unit

    @Operation(summary = "Crates a new Mailbox for package_id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Added the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the package", content = [Content()])]
    )
    @PostMapping("")
    fun initMailbox(@RequestBody value: MessageCreateDTO):Unit
}