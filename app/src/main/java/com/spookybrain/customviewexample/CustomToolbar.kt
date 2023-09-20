package com.spookybrain.customviewexample

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewOutlineProvider
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class CustomToolbar(context: Context, attrs: AttributeSet)
    : LinearLayout(context, attrs) {

    private var type: Int = 0
    private var title: String = ""

    private lateinit var ibMenu: ImageButton
    private lateinit var ibGoBack: ImageButton
    private lateinit var ibOk: ImageButton
    private lateinit var tvTitle: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this)

        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomToolbar, 0, 0
        ).apply {
            try {
                type = getInteger(R.styleable.CustomToolbar_type, 0)
                title = getString(R.styleable.CustomToolbar_title) ?: String()
            } finally {
                recycle()
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        tvTitle = findViewById(R.id.title)
        ibMenu = findViewById(R.id.ib_menu)
        ibGoBack = findViewById(R.id.ib_go_back)
        ibOk = findViewById(R.id.ib_checked)

        with(getBehavior()) {
            ibMenu.visibility = menuVisibility
            ibGoBack.visibility = goBackVisibility
            ibOk.visibility = okIconVisibility
        }

        tvTitle.text = title

        elevation = 2F
        outlineProvider = ViewOutlineProvider.BOUNDS

    }

    private fun getBehavior(): CustomToolbarBehavior {
        return when (type) {
            0 -> CustomToolbarBehavior.TitleBehavior
            1 -> CustomToolbarBehavior.NavigateBehavior
            2 -> CustomToolbarBehavior.MenuBehavior
            else -> CustomToolbarBehavior.CheckBehavior
        }
    }
}