package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.FragmentCalcBinding


class CalcFragment : Fragment() {

    private lateinit var binding: FragmentCalcBinding

    private lateinit var viewModel: CalcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_calc,container,false)

        viewModel = ViewModelProvider(this).get(CalcViewModel::class.java)

        binding.zero.setOnClickListener {
            viewModel.addText("0")
        }
        binding.one.setOnClickListener {
            viewModel.addText("1")
        }
        binding.two.setOnClickListener {
            viewModel.addText("2")
        }
        binding.three.setOnClickListener {
            viewModel.addText("3")
        }
        binding.four.setOnClickListener {
            viewModel.addText("4")
        }
        binding.five.setOnClickListener {
            viewModel.addText("5")
        }
        binding.six.setOnClickListener {
            viewModel.addText("6")
        }
        binding.seven.setOnClickListener {
            viewModel.addText("7")
        }
        binding.eight.setOnClickListener {
            viewModel.addText("8")
        }
        binding.nine.setOnClickListener {
            viewModel.addText("9")
        }
        binding.point.setOnClickListener {
            viewModel.addText(".")
        }
        binding.AC.setOnClickListener {
            viewModel.clear()
        }
        binding.plus.setOnClickListener {
            viewModel.expression("+")
        }
        binding.minus.setOnClickListener {
            viewModel.expression("-")
        }
        binding.multiply.setOnClickListener {
            viewModel.expression("*")
        }
        binding.divide.setOnClickListener {
            viewModel.expression("/")
        }
        binding.remainder.setOnClickListener {
            viewModel.expression("%")
        }
        binding.erase.setOnClickListener {
            viewModel.erase()
        }
        binding.equal.setOnClickListener {
            viewModel.calc()
        }

        viewModel.answer.observe(viewLifecycleOwner, Observer {
            binding.result.text=viewModel.answer.value
        })

        return binding.root
    }


}