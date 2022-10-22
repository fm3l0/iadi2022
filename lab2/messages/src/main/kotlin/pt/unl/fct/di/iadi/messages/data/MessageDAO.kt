package pt.unl.fct.di.iadi.messages.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class MessageDAO(@Id @GeneratedValue val id:Long, val receiver:String, val cc:String, val subject:String, var body:String)