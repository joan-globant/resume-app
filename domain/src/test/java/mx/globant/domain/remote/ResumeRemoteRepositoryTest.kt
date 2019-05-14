package mx.globant.domain.remote

import android.net.NetworkInfo
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.entities.GistEntity
import mx.globant.data.network.BaseCallback
import mx.globant.data.network.ResumeApi
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.model.Skill
import mx.globant.domain.model.WorkExperience
import mx.globant.domain.repository.ResumeRemoteRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call


@RunWith(MockitoJUnitRunner::class)
class ResumeRemoteRepositoryTest {

    @Mock
    lateinit var resumeApi: ResumeApi

    @Mock
    lateinit var networkManager: NetworkInfo

    @Mock
    lateinit var personalCallback: BaseCallback<PersonalInformation>

    @Mock
    lateinit var skillCallback: BaseCallback<List<Skill>>

    @Mock
    lateinit var workExperienceCallback: BaseCallback<List<WorkExperience>>

    @Mock
    lateinit var mockCall: Call<GistEntity>

    private lateinit var repository: ResumeRemoteRepository

    @Before
    fun setup() {
        repository = ResumeRemoteRepository(resumeApi, networkManager, Gson())
    }

    @Test
    fun `it should get an error when network is offline`() {
        `when`(networkManager.isConnected).thenReturn(false)
        `when`(resumeApi.getPersonalInformation()).thenReturn(mockCall)

        repository.getPersonalInformation(personalCallback)

        verify(personalCallback).onError()
        verifyNoMoreInteractions(personalCallback)
    }

    @Test
    fun `it should invoke get personal information request`() {
        `when`(networkManager.isConnected).thenReturn(true)
        `when`(resumeApi.getPersonalInformation()).thenReturn(mockCall)

        repository.getPersonalInformation(personalCallback)

        verify(resumeApi).getPersonalInformation()
        verifyNoMoreInteractions(resumeApi)
    }

    @Test
    fun `it should invoke get skills request`() {
        `when`(networkManager.isConnected).thenReturn(true)
        `when`(resumeApi.getSkills()).thenReturn(mockCall)

        repository.getSkills(skillCallback)

        verify(resumeApi).getSkills()
        verifyNoMoreInteractions(resumeApi)
    }

    @Test
    fun `it should invoke get work experience request`() {
        `when`(networkManager.isConnected).thenReturn(true)
        `when`(resumeApi.getWorkExperience()).thenReturn(mockCall)

        repository.getWorkHistory(workExperienceCallback)

        verify(resumeApi).getWorkExperience()
        verifyNoMoreInteractions(resumeApi)
    }
}