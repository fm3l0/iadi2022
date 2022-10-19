package pt.unl.fct.di.iadi.messages.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MessageDAO(@Id val receiver:String, val cc:String, val subject:String, val body:String)