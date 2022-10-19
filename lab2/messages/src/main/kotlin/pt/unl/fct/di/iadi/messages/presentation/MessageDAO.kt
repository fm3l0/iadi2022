package pt.unl.fct.di.iadi.messages.presentation

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MessageDAO(@Id val to:String, val cc:String, val subject:String, val body:String)