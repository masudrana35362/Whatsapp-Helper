package com.masud.whatsappsmessage

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
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
        var message = binding.etMessage.text.toString().trim()

        if (TextUtils.isEmpty(number) && number.length < 11) {
            binding.etNumber.error = "Enter valid number"
            return
        }
        if (TextUtils.isEmpty(message)) {
            binding.etMessage.error = "type your message here"
            return
        }

       // contains spaces.
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
        startActivity(sendIntent)


    }


}


