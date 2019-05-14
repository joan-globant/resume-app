package mx.globant.challenge.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mx.globant.challenge.R
import mx.globant.challenge.view.adapter.ResumePagerAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resumeViewpager.adapter = ResumePagerAdapter(this, supportFragmentManager)
    }
}
