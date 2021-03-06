@file:JvmName("BottomNavigationHelper")
package net.squanchy.home

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import net.squanchy.support.kotlin.children
import timber.log.Timber

@SuppressLint("RestrictedApi") // This is a hack, not much we can do about it until there is an API for this
fun BottomNavigationView.disableShiftMode() {
    val menuView = getChildAt(0) as BottomNavigationMenuView
    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (view in menuView.children) {
            val item = view as BottomNavigationItemView
            item.setShiftingMode(false)
            item.setChecked(item.itemData.isChecked)
        }
    } catch (e: NoSuchFieldException) {
        Timber.e(e, "Unable to get shift mode field")
    } catch (e: IllegalAccessException) {
        Timber.e(e, "Unable to change value of shift mode")
    }
}
