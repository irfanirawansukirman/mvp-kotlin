package id.gits.gitsmvpkotlingooglebase.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by irfanirawansukirman on 12/03/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var progressDialog: ProgressDialog

    lateinit var unbinder: Unbinder

    lateinit var activity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        unbinder = ButterKnife.bind(this)
        activity = this

        initToolbar()
        initProgressDialog(activity)
        onActivityStarted(savedInstanceState)
    }

    override fun onDestroy() {
        unbinder.unbind()
        super.onDestroy()
    }

    fun showHomeBackButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    fun showHomeBackButton(icon: Int) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setHomeAsUpIndicator(icon)
    }

    fun setViewToolbar(toolbars: Toolbar) {
        try {
            if (toolbars != null) {
                setSupportActionBar(toolbars)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setToolbarTitle(title: String) {
        toolbar.txt_toolbar_title.text = title
    }

    private fun initToolbar() {
        try {
            toolbar = findViewById(getToolbarId())

            setViewToolbar(toolbar)
        } catch (e: Exception) {
            e.printStackTrace()
        }
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

    public fun initProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item!!.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    @IdRes
    protected abstract fun getToolbarId(): Int

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun onActivityStarted(savedInstanceState: Bundle?)

}