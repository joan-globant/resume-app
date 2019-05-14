package mx.globant.domain.model

data class WorkExperience(
    val job: String,
    val companyName: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val description: String
) {
    fun getPeriod(): String =
        "$startDate – $endDate"
}