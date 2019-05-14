package mx.globant.domain.model

data class PersonalInformation(
    val name: String,
    val lastName: String,
    val age: String,
    val telephone: String,
    val address: Address,
    val email: String,
    val objective: String
) {
    fun getFullName(): String =
        "$name $lastName"

    fun getFullAddress(): String =
        address.getFullAddress()
}

data class Address(
    val street: String,
    val city: String,
    val country: String
) {
    fun getFullAddress(): String =
        "$street, $city, $country"
}