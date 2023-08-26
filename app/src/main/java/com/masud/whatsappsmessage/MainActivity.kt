package com.masud.whatsappsmessage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.masud.whatsappsmessage.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title ="Enjoy"

        binding.btnSend.setOnClickListener(this::sendMessage)
    }

    private fun sendMessage(view: View) {
        var number = binding.etNumber.text.toString().trim()
        val message = binding.etMessage.text.toString().trim()

        if (TextUtils.isEmpty(number) ) {
            binding.etNumber.error = "Enter valid number"
            return
        }

        if (TextUtils.isEmpty(message)) {
            binding.etMessage.error = "type your message here"
            return
        }

        if(!number.contains("+")){
            number= "+$number"
        }

        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    String.format(
                        "https://api.whatsapp.com/send?phone=%s&text=%s",
                        number,
                        message
                    )
                )
            )
        )


/*       // contains spaces.
        number = number.replace("+", "").replace(" ", "")
        if(!number.contains("88")){
            number= "88$number"
        }
        val sendIntent = Intent("android.intent.action.MAIN")
        sendIntent.putExtra("jid", "$number@s.whatsapp.net")
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.setPackage("com.whatsapp")
        sendIntent.type = "text/plain"


        if (sendIntent.resolveActivity(packageManager) == null) {
            Toast.makeText(this,
                "Please install whatsapp first.",
                Toast.LENGTH_SHORT).show()
            return
        }

        startActivity(sendIntent)*/


    }


}


