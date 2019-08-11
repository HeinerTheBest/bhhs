package com.mobileapps.bhhslux.views.fragments.auth.login

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mobileapps.bhhslux.model.user.User

class LoginViewModel() : ViewModel(), Observable {

    var fragmentTransaction2 : FragmentTransaction? = null

    val propertyChangeRegistry = PropertyChangeRegistry()
    lateinit var email : String
    lateinit var password : String
    val mAuth : FirebaseAuth = FirebaseAuth.getInstance()


    @Bindable
    var emailStatus = "Please enter email"


    @Bindable
    var logingStatus = "Login"

    @Bindable
    var visibleLogIn = View.VISIBLE

    @Bindable
    var verSso = "SSO 1.4"

    var user : FirebaseUser? = mAuth.currentUser





    val currentUser : MutableLiveData<User> = MutableLiveData()




    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    fun notifyAllViewsChanged(){
        propertyChangeRegistry.notifyChange(this,0)
    }

    // TODO: Implement the ViewModel



    fun onEmailChanged(email : Editable)
    {
        this.email = email.toString()
        Log.d("Heiner -> email",this.email)
        emailStatus = if(this.email.length < 4) "Invalid email address" else ""
        notifyAllViewsChanged()
    }

    fun onPasswordChanged(password : Editable)
    {
        this.password = password.toString()
        Log.d("Heiner -> password",this.password)
        emailStatus = if(this.password.length < 6) "Password too short" else ""
        notifyAllViewsChanged()
    }

    fun login()
    {
        val validatingEmail = User(email, password)
        currentUser.postValue(validatingEmail)
        try {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {  task: Task<AuthResult> ->
                        if (task.isSuccessful){
                            Log.d("Heiner","signInWithEmail:success")
                            user = mAuth.currentUser
                            updateUI()
                        } else if (!task.isSuccessful)  {
                            Log.d("Heiner","signInWithEmail:failure")
                        }
                    }
        } catch (e: Exception) {
        }
    }

    fun logOut()
    {
        mAuth.signOut()
        user = mAuth.currentUser
        updateUI()
    }

    fun primaryAction() = if(isUserLoged()) logOut() else login()


    fun updateUI()
    {
        if (isUserLoged()) {
            logingStatus = "SIGN OUT"
            verSso = "SSO 1.1"
            visibleLogIn = View.GONE
        }
        else
        {
            logingStatus = "LOGIN"
            verSso = "SSO 1.4"
            visibleLogIn = View.VISIBLE
        }
        notifyAllViewsChanged()
    }

    fun isUserLoged() : Boolean
    {
        return user?.email != null
    }

    fun startSignUpFragment()  //minute 12  https://www.youtube.com/watch?v=XWH0WainC1Y
    {
        fragmentTransaction2?.commit()
    }

    fun setFragmentTransaction(fragmentTransaction2: FragmentTransaction?) {

        this.fragmentTransaction2 = fragmentTransaction2
    }


}
