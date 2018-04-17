package com.irfan_berasbdg.mvpstarter.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
abstract class BaseFragment : Fragment() {

    lateinit var activity: AppCompatActivity

    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return bindView(inflater, container)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view, savedInstanceState)
    }

    private fun bindView(inflater: LayoutInflater?, container: ViewGroup?): View {
        val view = inflater!!.inflate(getLayoutRes(), container, false)

        activity = getActivity() as AppCompatActivity

        initProgressDialog()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    public fun setToolbarTitle(title: String) {
        (getActivity() as BaseActivity).setToolbarTitle(title)
    }

    public fun setToolbar(toolbar: Toolbar) {
        (getActivity() as BaseActivity).setViewToolbar(toolbar)
    }

    public fun showBackHomeButton() {
        (getActivity() as BaseActivity).showHomeBackButton()
    }

    public fun showBackHomeButton(icon: Int) {
        (getActivity() as BaseActivity).showHomeBackButton(icon)
    }

    public fun showProgressDialog(title: String, message: String, cancel: Boolean) {
        progressDialog.setTitle(title)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(cancel)
        progressDialog.setCanceledOnTouchOutside(cancel)
        progressDialog.show()
    }

    public fun hideProgressDialog() {
        progressDialog.dismiss()
    }

    public fun initProgressDialog() {
        progressDialog = ProgressDialog(activity)
    }

    public fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun onViewReady(view: View?, savedInstanceState: Bundle?)
}
