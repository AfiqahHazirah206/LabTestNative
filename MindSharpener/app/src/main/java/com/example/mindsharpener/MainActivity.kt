import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mindsharpener.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.textView3)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val radioButton1: RadioButton = findViewById(R.id.radio_pirates)

        // Set the first radio button as checked by default
        radioButton1.isChecked = true

        // Handle changes in the selected level
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedLevel = when (checkedId) {
                R.id.radio_pirates -> 3 // Level i3
                R.id.radio_ninjas -> 5 // Level i5
                R.id.radio_abc -> 7 // Level i7
                else -> 0 // Default level or error handling
            }
            // Generate a random question based on the selected level
            val question = generateQuestion(selectedLevel)
            questionTextView.text = question
        }

        // Set the initial question based on the default level (i3)
        val initialQuestion = generateQuestion(3)
        questionTextView.text = initialQuestion
    }

    private fun generateQuestion(level: Int): String {
        val random = Random.Default

        when (level) {
            3 -> return "${random.nextInt(10)} + ${random.nextInt(10)}"
            5 -> return "${random.nextInt(100)} - ${random.nextInt(100)}"
            7 -> return "${random.nextInt(1000)} * ${random.nextInt(10)}"
            else -> return "Invalid level"
        }
    }
}

