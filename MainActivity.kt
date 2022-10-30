package com.example.password

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Set variable arrays for each value
    var websites = arrayOf("")
    var usernames = arrayOf("")
    var passwords = arrayOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up each button to perform desired function
        val viewPasswordButton: Button = findViewById(R.id.viewPassword)
        val submitPasswordButton: Button = findViewById(R.id.submitPassword)

        // When each button is clicked, call the respected function
        viewPasswordButton.setOnClickListener { viewPasswords() }
        submitPasswordButton.setOnClickListener { createPasswords() }
    }

    private fun viewPasswords() {
        // Find the inputted website value
        val resultTextView: TextView = findViewById(R.id.textView)

        val enterWebsite: EditText = findViewById(R.id.EnterWebsite)
        val website = enterWebsite.getText().toString()
        // Clear the inputted test
        enterWebsite.getText().clear()

        // Display the passwords
        for (i in websites.indices)
        {
            if (websites[i] == website && websites[i] != ""){
                // Print the username and password for the user inputted website
                resultTextView.text = usernames[i] + ":" + passwords[i]
                return
            }
            // If the user does not input any website or the incorrect website, print all the websites
            else {
                // Create a website string to display the values as textview only accepts string
                var websiteString = ""
                // Display websites
                for (j in websites.indices) {
                    websiteString += websites[j] + "\n"
                }
                resultTextView.text = websiteString
            }
        }
        // Hide keyboard
        enterWebsite.onEditorAction(EditorInfo.IME_ACTION_DONE)

        // Save values to file
        //val path = Context.getFilesDir()
        //val letDirectory = File(path, "LET")
        //letDirectory.mkdirs()
        //val file = File(letDirectory, "Records.txt")
        //file.appendText("record goes here")
        //val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }

    }

    private fun createPasswords(){
        // Find each value and save it
        val addWebsite: EditText = findViewById(R.id.AddWebsite)
        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)

        val website = addWebsite.getText().toString()
        val username = usernameInput.getText().toString()
        val password = passwordInput.getText().toString()

        // Add the inputted values to the arrays
        websites += website
        usernames += username
        passwords += password

        // Clear the text after the user presses the button
        addWebsite.getText().clear()
        usernameInput.getText().clear()
        passwordInput.getText().clear()

        // Hide keyboard
        passwordInput.onEditorAction(EditorInfo.IME_ACTION_DONE)

        // Send message to the user to let them know the values were created successfully
        val text = "Successfully Added"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}
