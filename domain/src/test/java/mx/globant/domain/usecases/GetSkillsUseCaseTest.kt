package mx.globant.domain.usecases

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.Skill
import mx.globant.domain.repository.ResumeRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetSkillsUseCaseTest {

    @Mock
    lateinit var repository: ResumeRepository

    @Mock
    lateinit var callback: BaseCallback<List<Skill>>

    @Test
    fun `it should execute get skills`() {
        mx.globant.domain.usecases.GetSkillsUseCase(repository).execute(callback)

        verify(repository).getSkills(callback)
        verifyNoMoreInteractions(repository)
    }
}