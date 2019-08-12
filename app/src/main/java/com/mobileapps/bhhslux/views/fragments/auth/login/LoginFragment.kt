package com.mobileapps.bhhslux.views.fragments.auth.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.LoginFragmentBinding
import com.mobileapps.bhhslux.views.fragments.auth.signup.SignUpFragment

class LoginFragment : Fragment() {



    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding : LoginFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment, container, false)
        return binding.root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.viewModel = viewModel

        // TODO: Use the ViewModel
        viewModel.updateUI()
        val signUpFragment = SignUpFragment.newInstance()
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentLayout,signUpFragment)
        fragmentTransaction?.addToBackStack(null)
        viewModel.setFragmentTransaction(fragmentTransaction)
    }







}
