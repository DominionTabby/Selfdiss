package com.gmail.tabiszdominik.selfdiss.fragments.settings

import android.os.Bundle
import android.view.View
import com.gmail.tabiszdominik.selfdiss.R
import com.gmail.tabiszdominik.selfdiss.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class SettingsFragment : BaseFragment() {

    private val viewModel: SettingsViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_settings

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity!!.onBackPressed()
        }

        vulgarInsults.setOnClickListener {
            viewModel.onVulgarInsultsClick(!vulgarInsultsSwitch.isChecked)
        }

        vulgarInsultsSwitch.isChecked = viewModel.useVulgarInsults.blockingFirst()

        insultMeButton.setOnClickListener {
            viewModel.onInsultMeClick()
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.insult.bind {
            toolbarTitle.text = it
        }

        viewModel.useVulgarInsults.bind {
            vulgarInsultsSwitch.isChecked = it
        }
    }
}