package com.mobileapps.bhhslux.views.fragments.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {



    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginViewModel : LoginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val binding : LoginFragmentBinding = DataBindingUtil.setContentView(this.activity!!,R.layout.login_fragment)
        binding.viewModel = loginViewModel




    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.updateUI()
    }






}
