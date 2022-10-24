package com.example.password

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var usernames: Array<String> = TODO()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPasswordButton: Button = findViewById(R.id.viewPassword)
        val submitPasswordButton: Button = findViewById(R.id.submitPassword)


        viewPasswordButton.setOnClickListener { viewPasswords() }
        submitPasswordButton.setOnClickListener { createPasswords() }

    }

    private fun viewPasswords() {
        //val passwords = ViewPassword("Password1")
        //val password = passwords.printPassword()

        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = password

        for (i in usernames.indices)
        {
            println(usernames[i])
        }

        //val path = Context.getFilesDir()
        //val letDirectory = File(path, "LET")
        //letDirectory.mkdirs()
        //val file = File(letDirectory, "Records.txt")
        //file.appendText("record goes here")
        //val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }

    }

    private fun createPasswords(){
        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val username = usernameInput.getText().toString()
        val password = passwordInput.getText().toString()
        usernames += username
    }


}


class ViewPassword(private val password: String) {
    fun printPassword(): String {
        return password
    }

}
