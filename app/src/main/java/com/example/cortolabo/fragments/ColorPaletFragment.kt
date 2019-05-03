package com.example.cortolabo.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.cortolabo.R
import kotlinx.android.synthetic.main.fragment_colors.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Color : Fragment() {

    private var param1: String? = "color"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_colors, container, false)

        ponerColor(view)
        return view
    }

    fun ponerColor(view: View){
        if(isAdded){
            view.color.setBackgroundColor(resources.getColor(R.color.colorRojo))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            Color().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
