package com.example.cortolabo

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.cortolabo.fragments.Buttons
import com.example.cortolabo.fragments.Images

class MainActivity : AppCompatActivity() , Buttons.OnFragmentInteractionListener{

    var fotos = ArrayList<String>()
    var contador = 0


    override fun adelante() {

        contador = sumar(contador)
        var fragmento = Images.newInstance(fotos.get(contador))

        changeFragment(R.id.imagen_fragment,fragmento)
    }

    override fun atras() {
        contador = restar(contador)
        var fragmento = Images.newInstance(fotos.get(contador))

        changeFragment(R.id.imagen_fragment,fragmento)
    }

    override fun onFragmentInteraction() {
        Log.d("boton", "click anterior")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        fotos.add("https://joesknowsfood.com/wp-content/uploads/2018/01/instagram-logo-vector-download-200x200.jpg")
        fotos.add("https://townandcountryremovals.com/wp-content/uploads/2013/10/firefox-logo-200x200.png")
        fotos.add("https://doculinux.files.wordpress.com/2010/03/batux-tux-g2-hd-200x200.png")

        var fragmento = Images.newInstance(fotos.get(sumar(contador)))
        changeFragment(R.id.imagen_fragment,fragmento)

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
