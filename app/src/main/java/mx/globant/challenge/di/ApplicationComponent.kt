package mx.globant.challenge.di

import dagger.Component
import mx.globant.challenge.ResumeApplication
import mx.globant.challenge.view.fragment.PersonalFragment
import mx.globant.challenge.view.fragment.SkillsFragment
import mx.globant.challenge.view.fragment.WorkHistoryFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ResumeApplication)

    fun inject(fragment: WorkHistoryFragment)

    fun inject(fragment: PersonalFragment)

    fun inject(fragment: SkillsFragment)
}