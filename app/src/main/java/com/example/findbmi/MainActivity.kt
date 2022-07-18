package com.example.findbmi

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout



class MainActivity : AppCompatActivity() {


////    val material_weight: TextInputLayout =findViewById(R.id.outlined_weight)
////
////    val material_height: TextInputLayout =findViewById(R.id.outlined_height)


//    val material_height: EditText =findViewById(R.id.outlined_height)

    private val material_height : EditText
    get() = findViewById(R.id.outlined_height)

    private val recalculate_bmi : Button
    get() = findViewById(R.id.recalculate_bmi)

    val material_weight : EditText
    get() = findViewById(R.id.outlined_weight)

    val bmi_result : TextView
    get() = findViewById(R.id.bmi_result)

//    val bmi_image : ImageView
//    get() = findViewById(R.id.bmi_image)
//    val material_weight: EditText =findViewById(R.id.outlined_weight)
//    val bmi_result: TextView= findViewById(R.id.bmi_result)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculate_btn: Button = findViewById(R.id.btn)

        val male_radio: RadioButton =findViewById(R.id.male)
        val female_radio: RadioButton =findViewById(R.id.female)








        calculate_btn!!.setOnClickListener {


            if (material_weight.text.isNotEmpty() && material_height.text.isNotEmpty()){
                findBMI()
            }else {
                Toast.makeText(this, "Don't Leave Empty",Toast.LENGTH_SHORT).show()
            }


        }
//        bmi_image.setImageResource(R.drawable.ovwerweight)









    }

    private fun findBMI() {
//        TODO("Not yet implemented")
        val weightBMI =material_weight.text.toString().toFloat()
        val heightBMI =material_height.text.toString().toFloat()/100


        val myBMI = weightBMI / (heightBMI * heightBMI )

        bmi_result.text= myBMI.toString()

        if(myBMI<18.5){
            bmi_result.setText(R.string.UnderWeight)
//            bmi_image.setImageResource(R.drawable.ovwerweight)
        }else if (myBMI >=18.5 && myBMI <=24.5){

            bmi_result.setText(R.string.Normal)
        }else if(myBMI>=24.9 && myBMI<=29.9){
            bmi_result.setText(R.string.OverWeight)
//            bmi_image.setImageResource(R.drawable.ovwerweight)


        }else if (myBMI >=29.9){
            bmi_result.setText(R.string.Obesity)
        }


        recalculate_bmi.setOnClickListener(){

            material_height.text.clear()
            material_weight.text.clear()
//            bmi_image.setImageResource(R.drawable.empty)
            bmi_result.text=""

            material_weight.requestFocus()
        }








    }

}

