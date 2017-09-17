package com.prilaga.verge_agni_yoga.view.view_model

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View

/**
 * Created by Oleg Tarashkevich on 17.09.17.
 */
class ObservableBackground : BaseObservable() {

    var mDrawableResource: Int? = null
        private set
    var mColorResource: Int? = null
        private set
    var mColorValue: Int? = null
        private set
    var mDrawable: Drawable? = null
        private set
    var mBitmap: Bitmap? = null
        private set

    private fun reset() {
        mDrawableResource = null
        mColorResource = null
        mColorValue = null
        mDrawable = null
    }

    fun setDrawableResource(@DrawableRes drawableResource: Int) {
        reset()
        mDrawableResource = drawableResource
        notifyChange()
    }

    fun setColorResource(@ColorRes colorResource: Int) {
        reset()
        mColorResource = colorResource
        notifyChange()
    }

    fun setColorValue(colorValue: Int) {
        reset()
        mColorValue = colorValue
        notifyChange()
    }

    fun setDrawable(drawable: Drawable) {
        reset()
        mDrawable = drawable
        notifyChange()
    }

    fun setBitmap(bitmap: Bitmap) {
        reset()
        mBitmap = bitmap
        notifyChange()
    }

    fun clear() {
        reset()
        notifyChange()
    }
}

@BindingAdapter("android:background")
fun setBackground(view: View, observable: ObservableBackground) {
    if (observable.mDrawableResource != null)
        observable.mDrawableResource?.let { view.setBackgroundResource(it) }
    else if (observable.mColorResource != null)
        observable.mColorResource?.let {
            val color = ContextCompat.getColor(view.context, it)
            view.setBackgroundColor(color)
        }
    else if (observable.mColorValue != null)
        observable.mColorValue?.let { view.setBackgroundColor(it) }
    else if (observable.mDrawable != null) {
        observable.mDrawable?.let {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                view.setBackgroundDrawable(it)
            else
                view.background = it
        }
    } else if (observable.mBitmap != null) {
        observable.mBitmap?.let {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                view.setBackgroundDrawable(BitmapDrawable(it))
            else
                view.background = BitmapDrawable(view.context.resources, it)
        }
    } else {
        view.setBackgroundResource(0)
    }
}
