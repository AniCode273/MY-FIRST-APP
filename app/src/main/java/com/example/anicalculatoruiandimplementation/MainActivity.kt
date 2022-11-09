package com.example.anicalculatoruiandimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.anicalculatoruiandimplementation.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // setting onClick listener on all the buttons
        // start with btn clear
        binding.btnClear.setOnClickListener {
            clear();
        }
// adding onclick listeners to all the button
// addding string to our button
        binding.btnLeftBracket.setOnClickListener {
            binding.textInput.text =addtoInputText("(")
        }
        binding.btnRightBracket.setOnClickListener {
            binding.textInput.text = addtoInputText(")")
        }

        binding.btnDivide.setOnClickListener {
            binding.textInput.text = addtoInputText("/")
        }

        binding.btn7.setOnClickListener {
            binding.textInput.text = addtoInputText("7")

        }

        binding.btn8.setOnClickListener {
            binding.textInput.text = addtoInputText("8")
        }

        binding.btn9.setOnClickListener {
            binding.textInput.text = addtoInputText("9")
        }

        binding.btnMultiply.setOnClickListener {
            binding.textInput.text = addtoInputText("*")
        }

        binding.btn4.setOnClickListener {
            binding.textInput.text = addtoInputText("4")
        }

        binding.btn5.setOnClickListener {
            binding.textInput.text = addtoInputText("5")
        }
        binding.btn6.setOnClickListener {
            binding.textInput.text = addtoInputText("6")
        }
        binding.btnSubtract.setOnClickListener {
            binding.textInput.text = addtoInputText("-")
        }
        binding.btn1.setOnClickListener {
            binding.textInput.text = addtoInputText("1")
        }
        binding.btn2.setOnClickListener {
            binding.textInput.text = addtoInputText("2")
        }
        binding.btn3.setOnClickListener {
            binding.textInput.text = addtoInputText("3")
        }
        binding.btnAdd.setOnClickListener {
            binding.textInput.text = addtoInputText("+")
        }
        binding.btn0.setOnClickListener {
            binding.textInput.text = addtoInputText("0")
        }
        binding.btndot.setOnClickListener {
            binding.textInput.text = addtoInputText(".")
        }

        binding.btnEquals.setOnClickListener {
            calculateResult();
        }






    }



    private fun clear() {
        binding.textInput.text = ""
        binding.textOutput.text = ""
    }

    private fun addtoInputText(btnValue:String):String{
        return "${binding.textInput.text}$btnValue"

    }

    private fun getInputExpression():String{
        var expression = binding.textInput.text.replace(Regex("-"),"/")
        expression = expression.replace(Regex("-"),"*")
        return expression

    }
    private fun calculateResult() {
        try {
        val expression = getInputExpression()
         val result = Expression(expression).calculate()
            if (result.isNaN()){
                binding.textOutput.text= "Error"
                binding.textOutput.setTextColor(ContextCompat.getColor(this,R.color.black))

            }else{
                binding.textOutput.text= DecimalFormat("0.#### ").format(result).toString()
                binding.textOutput.setTextColor(ContextCompat.getColor(this,R.color.black))
            }
        }catch (error:Exception){

        }

    }


}