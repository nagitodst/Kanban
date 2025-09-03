package com.alex.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alex.task.R
import com.alex.task.databinding.FragmentFormTaskBinding
import com.alex.task.util.initToolbar
import com.alex.task.util.showBottomSheet

class FormTaskFragment : Fragment() {
    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.buttonSave.setOnClickListener {
            valideData()
        }
    }

    private fun valideData(){
        val description = binding.editTextDescricao.text.toString().trim()
        if (description.isNotBlank()){
            Toast.makeText(requireContext(),"Tudo OK!", Toast.LENGTH_SHORT).show()
        }else{
            showBottomSheet(message = getString(R.string.description_empty_form_task_fragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}