package mx.globant.domain.usecases

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.WorkExperience
import mx.globant.domain.repository.ResumeRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetWorkHistoryUseCaseTest {

    @Mock
    lateinit var repository: ResumeRepository

    @Mock
    lateinit var callback: BaseCallback<List<WorkExperience>>

    @Test
    fun `it should execute get work history`() {
        mx.globant.domain.usecases.GetWorkHistoryUseCase(repository).execute(callback)

        verify(repository).getWorkHistory(callback)
        verifyNoMoreInteractions(repository)
    }
}