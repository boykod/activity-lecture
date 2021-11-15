package ua.motionman.activitylecture.model

import java.io.Serializable

data class UserModel(
    val id: String,
    val firstName: String,
    val lastName: String
) : Serializable