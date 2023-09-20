package com.spookybrain.customviewexample

import android.view.View

sealed class CustomToolbarBehavior(
    val menuVisibility: Int = View.GONE,
    val goBackVisibility: Int = View.GONE,
    val okIconVisibility: Int = View.GONE
) {
    object TitleBehavior : CustomToolbarBehavior()
    object NavigateBehavior : CustomToolbarBehavior(
        goBackVisibility = View.VISIBLE
    )

    object MenuBehavior : CustomToolbarBehavior(
        menuVisibility = View.VISIBLE
    )

    object CheckBehavior : CustomToolbarBehavior(
        goBackVisibility = View.VISIBLE,
        okIconVisibility = View.VISIBLE,
    )
}