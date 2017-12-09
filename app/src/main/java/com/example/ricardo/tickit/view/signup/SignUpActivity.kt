package com.example.ricardo.tickit.view.signup

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.app.Activity;
import android.provider.ContactsContract
import android.util.Patterns
import com.example.ricardo.tickit.R

import com.example.ricardo.tickit.base.BasePresenter

import com.example.ricardo.tickit.data.entity.GDUser

import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import com.example.ricardo.tickit.view.common.BaseActivity
import com.example.ricardo.tickit.view.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity(),SignUpView{

    override val presenter by lazy { SignUpPresenter(this, UserRepository.get()) }


    var _userDao: GDUserDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btn_signup.setOnClickListener { signup() }

        link_signin.setOnClickListener {
            // Finish the registration screen and return to the Login activity
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_in_top )
            //第一个参数为第一个Activity离开时的动画，第二参数为所进入的Activity的动画效果

        }

        _userDao = loadDaoSession().gdUserDao

        presenter.mUserDao = _userDao

        signupBtn.setOnClickListener{ signupClick(presenter) }

        println("signup")
    }

    override fun show(items: List<User>) {

    }

    override fun showError(error: Throwable) {

    }
    private fun signup() {
        //Log.d(TAG, "Signup")

        if (!validate()) {
            onSignupFailed()
            return
        }

        btn_signup.setEnabled(false)

        //val progressDialog = ProgressDialog(this@SignupActivity, R.style.AppTheme_Dark_Dialog)
        //progressDialog.isIndeterminate = true
        //progressDialog.setMessage("Creating Account...")
        //progressDialog.show()

    //按钮点击处理事件
    fun signupClick(presenter: SignUpPresenter?){
        println("click")

        val mUser = User("1111112","2327","1127","1234567812","22222")

        presenter!!.postAccount(mUser)


        android.os.Handler().postDelayed(
                {
                    // On complete call either onSignupSuccess or onSignupFailed
                    // depending on success
                    onSignupSuccess()
                    // onSignupFailed();

                    //progressDialog.dismiss()
                }, 3000)
    }

    fun onSignupSuccess() {
        btn_signup.setEnabled(true)
        setResult(Activity.RESULT_OK, null)
        finish()
    }

    fun onSignupFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        btn_signup.setEnabled(true)
    }


    private fun validate(): Boolean {
        var valid = true

        val nickname = input_nickname.getText().toString()
        val studentID = input_studentID.getText().toString()
        val realName = input_realName.getText().toString()
        val mobile = input_mobile.getText().toString()
        val password = input_password.getText().toString()
        val reEnterPassword = input_reEnterPassword.getText().toString()

        if (nickname.isEmpty() || nickname.length < 3) {
            input_nickname.setError("at least 3 characters")
            valid = false
        } else {
            input_nickname.setError(null)
        }

        // todo: check if student ID in list
        if (studentID.isEmpty()||studentID.length != 7) {
            input_studentID.setError("Enter Valid Address")
            valid = false
        } else {
            input_studentID.setError(null)
        }

        // todo: check if name matches the student ID
        if (realName.isEmpty()) {
            input_realName.setError("enter a valid email address")
            valid = false
        } else {
            input_realName.setError(null)
        }

        if (mobile.isEmpty() ||mobile.length != 11) {
            input_mobile.setError("Enter Valid Mobile Number")
            valid = false
        } else {
            input_mobile.setError(null)
        }

        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            input_password.setError("between 4 and 10 alphanumeric characters")
            valid = false
        } else {
            input_password.setError(null)
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length < 4 || reEnterPassword.length > 10 || reEnterPassword != password) {
            input_reEnterPassword.setError("Password Do not match")
            valid = false
        } else {
            input_reEnterPassword.setError(null)
        }

        return valid

    //注册成功后调用的函数，用户信息存入greenDao,跳转界面
    override fun onSuccess(items: List<User>) {

        println(items[0].avatar)

        val user = items[0]

        saveUserToLocal(user, presenter.mUserDao!!)

    }

    //注册失败，给出一系列提示
    override fun onError(error: Throwable) {
        println(error)

    }


    //存入本地服务器
    override fun saveUserToLocal(item: User, userDao: GDUserDao){
        val db = userDao!!.queryBuilder()

        val list = db.list()

        //如果本地数据库为空，插入账户数据
        if (list.isEmpty() || list.size <= 0){
            println(" is Empty ")

            val gdUser: GDUser = GDUser(item)

            userDao.insert(gdUser)

            val sUser = userDao.load(item.id)

            println(sUser.id)
        }
        //若不为空，则删掉再插入，保持数据库只存一个账户信息
        else {
            println(list[0].id)
            userDao.deleteByKey(list[0].id)

            val db = userDao!!.queryBuilder()
            val list = db.list()
            if (list.isEmpty() || list.size <= 0){

                val gdUser: GDUser = GDUser(item)
                userDao.insert(gdUser)

                val sUser = userDao.load(item.id)
                println(sUser.id)
            }


        }

    }



}