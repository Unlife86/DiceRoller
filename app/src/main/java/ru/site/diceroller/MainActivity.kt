package ru.site.diceroller

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView /*lateinit сообщает компилятору, что переменная будет инициализирована перед вызовом каких либо операций с ней. То есть обещаем не оставить ее равной нулю*/

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button  = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            /*Toast.makeText( this, "button clicked", Toast.LENGTH_SHORT).show()*/
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        /*val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()*/
        //val diceImage: ImageView = findViewById(R.id.dice_image) /*findViewById() является дорогостоящей операцией, чтобы вызывать его каждый раз при нажатии на кнопку*/
        val drawableResource = resources.getDrawable(resources.getIdentifier("dice_$randomInt","drawable",packageName),theme)
        diceImage.setImageDrawable(drawableResource)


    }
}