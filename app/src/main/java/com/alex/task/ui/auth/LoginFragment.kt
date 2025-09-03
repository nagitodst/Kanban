package com.alex.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alex.task.R
import com.alex.task.databinding.FragmentLoginBinding
import com.alex.task.util.showBottomSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(){
        binding.buttonLogin.setOnClickListener {
            valideData()
        }
        binding.textViewCriarConta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.textViewRecuperarConta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun valideData(){
        val email = binding.editTextEmail.text.toString().trim()
        val senha = binding.editTextSenha.text.toString().trim()
        if(email.isNotBlank()) {
            if (senha.isNotBlank()) {
                findNavController().navigate(R.id.action_global_homeFragment)
            } else {
                showBottomSheet(message = getString(R.string.password_empty))
            }
        }else{
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}