package mx.globant.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class PersonalInformationTest(
    private val expectedFullName: String, private val expectedFullAddress: String,
    private val personalInformation: PersonalInformation
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("John Doe", "7375 Pennington Ave, New York, USA", PersonalInformation(
                "John", "Doe", "43 years", "+11 (22) 3333 4444", Address(
                    "7375 Pennington Ave", "New York", "USA"
                ), "john.doe@email.com", "Lorem ipsum..."
            )
            ),
            arrayOf("Mark Z", "684 Dunbar Court, Ciudad de México, México", PersonalInformation(
                "Mark", "Z", "57 years", "+11 (22) 7777 9999", Address(
                    "684 Dunbar Court", "Ciudad de México", "México"
                ), "mark.x@email.com", "Lorem ipsum..."
            )
            ),
            arrayOf("Juan Pérez", "7375 Pennington Ave, Madrid, Spain", PersonalInformation(
                "Juan", "Pérez", "29 years", "+11 (22) 2222 9999", Address(
                    "7375 Pennington Ave", "Madrid", "Spain"
                ), "juan.x@email.com", "Lorem ipsum..."
            )
            )
        )
    }


    @Test
    fun `it should format correctly name and address`() {
        assertEquals(expectedFullName, personalInformation.getFullName())
        assertEquals(expectedFullAddress, personalInformation.getFullAddress())
    }
}