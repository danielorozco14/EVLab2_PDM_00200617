package com.example.cortolabo.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cortolabo.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Color : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_colors, container, false)

        //ponerImagen(view)
        return view
    }

    /*fun ponerImagen(view: View){
        if(isAdded){
            Glide.with(this.context!!).load(param1).into(view.color)
        }
    }*/


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
