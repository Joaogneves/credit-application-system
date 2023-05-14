package dev.joao.request.credit.system.entity

data class Customer(
        var firstName: String = "",
        var lastName:String = "",
        val cpf: String,
        var email: String = "",
        var password: String = "",
        var address: Address = Address(),
        var credits: List<Credit> = mutableListOf(),
        var id: Long? = null,
)
