package mx.globant.domain.usecases

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.repository.ResumeRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetPersonalUseCaseTest {

    @Mock
    lateinit var repository: ResumeRepository

    @Mock
    lateinit var callback: BaseCallback<PersonalInformation>

    @Test
    fun `it should execute get personal information`() {
        mx.globant.domain.usecases.GetPersonalUseCase(repository).execute(callback)

        verify(repository).getPersonalInformation(callback)
        verifyNoMoreInteractions(repository)
    }
}