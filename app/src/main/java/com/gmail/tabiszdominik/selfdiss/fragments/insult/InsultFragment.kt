package com.gmail.tabiszdominik.selfdiss.fragments.insult

import android.os.Bundle
import android.view.View
import com.gmail.tabiszdominik.selfdiss.R
import com.gmail.tabiszdominik.selfdiss.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_insult.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class InsultFragment : BaseFragment() {

    private val viewModel: InsultViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_insult

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsButton.setOnClickListener {
            mainViewModel.openSettings()
        }

        insultMeButton.setOnClickListener {
            viewModel.onInsultMeClick()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.insult.bind {
            insult.text = it
        }
    }
}