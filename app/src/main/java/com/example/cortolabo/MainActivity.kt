package com.example.cortolabo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.cortolabo.fragments.Buttons
import com.example.cortolabo.fragments.Color

class MainActivity : AppCompatActivity() , Buttons.OnFragmentInteractionListener{

    var colores = ArrayList<String>()
    var contador = 0


    override fun adelante() {

        contador = sumar(contador)
        var fragmento = Color.newInstance(colores.get(contador))

        changeFragment(R.id.color_fragment,fragmento)
    }

    override fun atras() {
        contador = restar(contador)
        var fragmento = Color.newInstance(colores.get(contador))

        changeFragment(R.id.color_fragment,fragmento)
    }

    override fun onFragmentInteraction() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        //color rojo agregado

        colores.add("#FF0000")
        //color azul agregado
        colores.add("#0000FF")
        //color verde agregado
        colores.add("#00FF00")


        var fragmento = Color.newInstance(colores.get(sumar(contador)))
        changeFragment(R.id.color_fragment,fragmento)

    }

    fun sumar(a: Int):Int{

        var b = a
        if(b == 2){
            b = 0
        }else{
            b++
        }

        return b
    }

    fun restar(a: Int): Int{
        var b = a
        if(b == 0){
            b = 2
        }else{
            b--
        }

        return b
    }

    fun changeFragment(num: Int,frag: Fragment){
        supportFragmentManager.beginTransaction().replace(num,frag).commit()
    }

    fun init(){
        var botones = Buttons.newInstance()

        changeFragment(R.id.botones,botones)
    }

}
