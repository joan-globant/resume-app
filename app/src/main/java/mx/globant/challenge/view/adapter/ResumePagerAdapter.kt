package mx.globant.challenge.view.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import mx.globant.challenge.R
import mx.globant.challenge.view.fragment.PersonalFragment
import mx.globant.challenge.view.fragment.SkillsFragment
import mx.globant.challenge.view.fragment.WorkHistoryFragment


class ResumePagerAdapter(
    context: Context,
    fragmentManager: FragmentManager?
): FragmentPagerAdapter(fragmentManager) {

    companion object {
        private const val NUMBER_OF_PAGES = 3
    }

    private var titles = context.resources.getStringArray(R.array.pager_titles)

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> WorkHistoryFragment()
            2 -> SkillsFragment()
            else -> PersonalFragment()
        }
    }

    override fun getCount(): Int =
        NUMBER_OF_PAGES

    override fun getPageTitle(position: Int): CharSequence =
        titles[position]
}