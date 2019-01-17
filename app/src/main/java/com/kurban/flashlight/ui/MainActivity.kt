package com.kurban.flashlight.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kurban.flashlight.R
import com.kurban.flashlight.mvp.MainContract
import com.kurban.flashlight.mvp.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MvpView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this).init()
    }

    override fun initUI() {
        btn.setOnClickListener {
            presenter.handleTik()
        }
    }

    override fun tik(value: Boolean) {
        if (value) presenter.toast("Açık") else presenter.toast("Kapalı")

        presenter.control(value)
    }
}
