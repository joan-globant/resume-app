package mx.globant.challenge.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.WorkExperience
import mx.globant.challenge.view.contract.ListingView
import mx.globant.domain.usecases.GetWorkHistoryUseCase
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class WorkHistoryPresenterTest {

    companion object {
        private val FAKE_WORK_HISTORY = listOf(
            WorkExperience(
                "Developer",
                "Globant",
                "Ciudad de México",
                "Jun 2020",
                "Sept 2020",
                "Lorem ipsum"
            )
        )
    }

    @Mock
    lateinit var view: ListingView

    @Mock
    lateinit var useCase: GetWorkHistoryUseCase

    private lateinit var presenter: WorkHistoryPresenter

    @Before
    fun setup() {
        presenter = WorkHistoryPresenter(useCase)
        presenter.initView(view)
    }

    @Test
    fun `it should return a list of work experiences when callback returns success`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<List<WorkExperience>>
            callback.onSuccess(FAKE_WORK_HISTORY)
        }.`when`(useCase).execute(any())

        presenter.getWorkHistory()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showContent()
        verify(view).setupAdapter()
        verifyNoMoreInteractions(view)

        assertArrayEquals(FAKE_WORK_HISTORY.toTypedArray(), presenter.getCurrentWorkHistory().toTypedArray())
    }

    @Test
    fun `it should show connection error when callback returns error`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<List<WorkExperience>>
            callback.onError()
        }.`when`(useCase).execute(any())

        presenter.getWorkHistory()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showConnectionError()
        verifyNoMoreInteractions(view)
    }
}