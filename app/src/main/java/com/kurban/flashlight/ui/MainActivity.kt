package com.kurban.flashlight.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kurban.flashlight.R
import com.kurban.flashlight.di.DependencyInjectorImpl
import com.kurban.flashlight.mvp.MainContract
import com.kurban.flashlight.mvp.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MvpView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this, DependencyInjectorImpl(this)).init()
    }

    override fun initUI() {
        btn.setOnClickListener {
            presenter.handleTik()
        }
    }

    override fun tik(value: Boolean) {
        if (value) {
            presenter.toast(getString(R.string.opened))
            btn.text = getString(R.string.close)
        } else {
            presenter.toast(getString(R.string.closed))
            btn.text = getString(R.string.open)
        }
        
        presenter.control(value)
    }
}
