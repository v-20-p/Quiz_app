package com.example.quiz_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz_app.model.QuizViewModel
import com.example.quiz_app.ui.theme.Quiz_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            Quiz_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(Modifier.padding(11.dp)) {
                        Quiz()


                        }

                    }


                }
            }
        }
    }


@Composable
fun Quiz(viewModel: QuizViewModel =androidx.lifecycle.viewmodel.compose.viewModel()) {

LazyColumn{
    items(viewModel.quizList){quizItem ->
        Text(text = quizItem.question)
        val (selectedOp,setSelectedOp)= remember {
            mutableStateOf("")
        }
        quizItem.answersList.forEach{answer ->
            Row(
                modifier= Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .clickable {
                        setSelectedOp(answer)
                        viewModel.checkAnswer(quizItem, answer)

                    }

            ){
                RadioButton(selected = (answer==selectedOp.toString()), onClick = { setSelectedOp(answer)
                    viewModel.checkAnswer(quizItem,answer)
                })
                Text(text = answer)
            }


        }





        val (state,setstate)= remember {
            mutableIntStateOf(0)
        }
        Column {


            Button(onClick = {
                setstate(viewModel.numOfsumbit())

            }) {
                Text(text = "submit")
            }


        }
        Text(text = state.toString())
    }


}

}

