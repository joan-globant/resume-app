package mx.globant.challenge.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.Skill
import mx.globant.challenge.view.contract.ListingView
import mx.globant.domain.usecases.GetSkillsUseCase
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SkillPresenterTest {

    companion object {
        private val FAKE_SKILLS = listOf(Skill("bash", 30.2))
    }

    @Mock
    lateinit var view: ListingView

    @Mock
    lateinit var useCase: GetSkillsUseCase

    private lateinit var presenter: SkillsPresenter

    @Before
    fun setup() {
        presenter = SkillsPresenter(useCase)
        presenter.initView(view)
    }

    @Test
    fun `it should return a list of skills when callback returns success`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<List<Skill>>
            callback.onSuccess(FAKE_SKILLS)
        }.`when`(useCase).execute(any())

        presenter.getSkills()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showContent()
        verify(view).setupAdapter()
        verifyNoMoreInteractions(view)

        assertArrayEquals(FAKE_SKILLS.toTypedArray(), presenter.getCurrentSkills().toTypedArray())
    }

    @Test
    fun `it should show connection error when callback returns error`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<List<Skill>>
            callback.onError()
        }.`when`(useCase).execute(any())

        presenter.getSkills()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showConnectionError()
        verifyNoMoreInteractions(view)
    }
}