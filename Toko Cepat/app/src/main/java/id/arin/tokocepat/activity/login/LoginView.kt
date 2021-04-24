package id.arin.tokocepat.activity.login

import id.arin.tokocepat.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg: String?)
}