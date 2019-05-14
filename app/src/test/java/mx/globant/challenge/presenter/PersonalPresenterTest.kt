package mx.globant.challenge.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.Address
import mx.globant.domain.model.PersonalInformation
import mx.globant.challenge.view.contract.PersonalView
import mx.globant.domain.usecases.GetPersonalUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class PersonalPresenterTest {

    companion object {
        private val FAKE_PERSONAL_INFORMATION =
            PersonalInformation(
                "John",
                "Doe",
                "40 years",
                "+52 (19) 4992 1931",
                Address("Street #100", "Ciudad de México", "México"),
                "email@email.com",
                "Lorem ipsum..."
            )
    }

    @Mock
    lateinit var view: PersonalView

    @Mock
    lateinit var useCase: GetPersonalUseCase

    private lateinit var presenter: PersonalPresenter

    @Before
    fun setup() {
        presenter = PersonalPresenter(useCase)
        presenter.initView(view)
    }

    @Test
    fun `it should display personal information when callback returns success`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<PersonalInformation>
            callback.onSuccess(FAKE_PERSONAL_INFORMATION)
        }.`when`(useCase).execute(any())

        presenter.getPersonalInformation()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showContent()
        verify(view).setName("John Doe")
        verify(view).setAge("40 years")
        verify(view).setEmail("email@email.com")
        verify(view).setPhone("+52 (19) 4992 1931")
        verify(view).setAddress("Street #100, Ciudad de México, México")
        verify(view).setObjective("Lorem ipsum...")
        verifyNoMoreInteractions(view)
    }

    @Test
    fun `it should show connection error when callback returns error`() {

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            val callback = it.arguments[0] as BaseCallback<PersonalInformation>
            callback.onError()
        }.`when`(useCase).execute(any())

        presenter.getPersonalInformation()

        verify(view).showProgressBar()
        verify(view).hideConnectionError()
        verify(view).hideProgressBar()
        verify(view).showConnectionError()
        verifyNoMoreInteractions(view)
    }
}