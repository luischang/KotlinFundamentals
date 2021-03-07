package dev.luischang.appsfundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.io.Console
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
   var title = "Kotlin Fundamentals is a variable";
   var fullName: String= "Luis Chang"
    var year: Int = 1986
   var amount: Double= 150.32
    var digit: Char='2'
    val exchangeRate = 3.66//-->Is a constant
    //exchangeRate = "3.88" -->This is not permitted



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("INF-KT","Print in console")
        mostrarMensajeToast("Hello World in Kotlin")
        var result = this.getFinalAmount(amount, exchangeRate);
        mostrarMensajeToast("Final Amount: $result")
        getGeneration(year)
        getGenerationWithWhen(year)

    }

    private fun getGenerationWithWhen(ageOfBirth: Int){
        val dateNow = Calendar.getInstance()
        var yearNow = dateNow.get(Calendar.YEAR);
        var age = yearNow - ageOfBirth
        var result =""
        result = when(age){
            in 0..24 -> "Gen Z"
            in 25..40 -> "Millennial"
            in 41..56 -> "Gen X"
            else -> "Baby Boomer"
        }
        Log.i("INF-KT", "Your age is $age, Generation v2: $result")

    }

    private fun getGeneration(ageOfBirth: Int){
        val dateNow = Calendar.getInstance()
        var yearNow = dateNow.get(Calendar.YEAR);
        var age = yearNow - ageOfBirth

        var result: String = "";
        if(age>=57)
            result = "Baby Boomer"
        else if (age>=41 && age <=56) //else if (age in 41..46)
            result = "Gen X"
        else if (age>=25 && age <=40) //else if (age in 25..40)
            result = "Millennial"
        else if (age<=24)
            result = "Gen Z"
        Log.i("INF-KT", "Your age is $age, Generation: $result")

    }


    private fun getFinalAmount(amount: Double, exchangeRate: Double):Double{
        return amount * exchangeRate
    }

    private fun mostrarMensajeToast(mensaje: String){
        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show()
    }
}