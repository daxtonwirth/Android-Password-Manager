package com.example.password

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var websites = arrayOf("")
    var usernames = arrayOf("Usernames: ")
    var passwords = arrayOf("Passwords: ")
    

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

        val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = password

        val EnterWebsite: EditText = findViewById(R.id.EnterWebsite)
        val website = EnterWebsite.getText().toString()
        EnterWebsite.getText().clear()

        for (i in 0 until websites.size)
        {
            if (websites[i] == website){
                resultTextView.text = usernames[i] }
            else {resultTextView.text = ""}
        }

        //val path = Context.getFilesDir()
        //val letDirectory = File(path, "LET")
        //letDirectory.mkdirs()
        //val file = File(letDirectory, "Records.txt")
        //file.appendText("record goes here")
        //val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }

    }

    private fun createPasswords(){
        val AddWebsite: EditText = findViewById(R.id.AddWebsite)
        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)

        val website = AddWebsite.getText().toString()
        val username = usernameInput.getText().toString()
        val password = passwordInput.getText().toString()

        websites += website
        usernames += username
        passwords += password

        AddWebsite.getText().clear()
        usernameInput.getText().clear()
        passwordInput.getText().clear()

        val text = "Successfully Added"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}


class ViewPassword(private val password: String) {
    fun printPassword(): String {
        return password
    }

}
