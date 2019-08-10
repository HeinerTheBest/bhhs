package com.mobileapps.bhhslux.views.fragments.accessibility

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

import com.mobileapps.bhhslux.R

class AccessibilityFragment : Fragment() {

    companion object {
        fun newInstance() = AccessibilityFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.accessibility_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.webAccessibility)
        webView.loadUrl(getString(R.string.url_accessibility))
    }

}
