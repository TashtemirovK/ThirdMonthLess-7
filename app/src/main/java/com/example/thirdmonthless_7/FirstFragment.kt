package com.example.thirdmonthless_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thirdmonthless_7.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var RmList: ArrayList<Rm>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = RmAdapter(RmList, this::onItemClick)
        binding.recycleView.adapter = adapter
    }

    private fun loadData() {
        RmList = ArrayList<Rm>()

        RmList.apply {
            add(Rm(R.drawable.ricky,"Alive","Rick Sanchez"))
            add(Rm(R.drawable.morty,"Alive","Morty Smith"))
            add(Rm(R.drawable.albert,"Dead","Albert Einstein"))
            add(Rm(R.drawable.jerry,"Alive","Jerry Smith"))
        }

    }
    private fun onItemClick(rm: Rm){
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSrcondFragment(rm))
    }

}

}