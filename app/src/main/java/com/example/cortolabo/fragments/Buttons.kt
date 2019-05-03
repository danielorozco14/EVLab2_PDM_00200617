package com.example.cortolabo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

import com.example.cortolabo.R
import kotlinx.android.synthetic.main.fragment_buttons.*
import kotlinx.android.synthetic.main.fragment_buttons.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Buttons : Fragment() {

    private var param1: String? = "color"
    private var listener: OnFragmentInteractionListener? = null

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


        val view = inflater.inflate(R.layout.fragment_buttons, container, false)



        view.boton_1.setOnClickListener { atras()}

        view.boton_2.setOnClickListener { adelante()}
        return view
    }


    fun atras() {
        listener?.atras()
    }

    fun adelante() {
        listener?.adelante()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

        fun onFragmentInteraction()

        fun adelante()

        fun atras()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Buttons().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
