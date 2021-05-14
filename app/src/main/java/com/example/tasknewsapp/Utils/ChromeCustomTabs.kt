package com.example.tasknewsapp.Utils
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.core.content.ContextCompat
import com.example.tasknewsapp.R

class ChromeCustomTabs(private val context: Context) {
    private var serviceConnection: CustomTabsServiceConnection? = null
    private var mCustomTabsIntent: CustomTabsIntent? = null

    @ColorInt
    private val toolbarColor: Int

    private fun initService() {
        serviceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(componentName: ComponentName, customTabsClient: CustomTabsClient) {
                customTabsClient.warmup(0L)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                // NO-OP
            }
        }

        // Bind the Chrome Custom Tabs service
        CustomTabsClient.bindCustomTabsService(context, "com.example.tasknewsapp", serviceConnection as CustomTabsServiceConnection)
        mCustomTabsIntent = CustomTabsIntent.Builder()

            .setShowTitle(true)
            .setToolbarColor(toolbarColor)
            .build()
    }

    fun launchUrl(Url: String?) {
        mCustomTabsIntent?.apply {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchUrl(context,Uri.parse(Url))
        }
    }

    /**
     * Allow the Chrome Custom Tabs service to disconnect and GC.
     */
    fun destroy() {
        serviceConnection?.let {
            context.unbindService(it)
        }
    }

    companion object {
        /**
         * Launches a Chrome Custom Tab without warmup / service.
         *
         * @param context The context - used for launching an Activity.
         * @param url     The URL to load.
         */
        fun launchUrl(context: Context, url: String) {
            val customTabsIntent = CustomTabsIntent.Builder().build()
            customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent.launchUrl(context, Uri.parse(url))
        }
    }

    init {
        toolbarColor = ContextCompat.getColor(context, R.color.color)
        initService()
    }
}