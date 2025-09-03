package com.alex.task.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.alex.task.R
import com.alex.task.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


fun Fragment.initToolbar(toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title=""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    tittleButton: Int? = null,
    message: String,
    onClick: () -> Unit ={}
){
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.textViewTitle.text=getText(titleDialog ?: R.string.text_tile_warning)
    binding.textViewMessage.text = message
    binding.buttonOk.text = getText(tittleButton ?: R.string.text_button_warning)
    binding.buttonOk.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}