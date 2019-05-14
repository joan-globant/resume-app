package mx.globant.challenge.view.contract

interface PersonalView: LoadingView,
    ConnectionErrorView {

    fun showContent()

    fun setName(name: String)

    fun setAge(age: String)

    fun setEmail(email: String)

    fun setPhone(telephone: String)

    fun setAddress(fullAddress: String)

    fun setObjective(objective: String)
}