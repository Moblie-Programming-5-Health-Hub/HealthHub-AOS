package com.example.healthhub.util.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("selected")
fun View.setSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}
