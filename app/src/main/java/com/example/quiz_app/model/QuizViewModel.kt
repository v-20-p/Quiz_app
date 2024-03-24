package com.example.quiz_app.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quiz_app.model.QuizItem

class QuizViewModel:ViewModel() {


    val quizList: MutableList<QuizItem> = mutableListOf(
        QuizItem(
            Id = 0,
            question = "What is the capital of France?",
            answersList = listOf("Paris", "London", "Berlin", "Madrid"),
            correctChoice = "Paris",
            isAnswerCorrect = false
        ),
        QuizItem(
            1,
            question = "What is the capital of Germany?",
            answersList = listOf("Paris", "London", "Berlin", "Madrid"),
            correctChoice = "Berlin",
            isAnswerCorrect = false
        ),
        QuizItem(
            2,
            question = "What is the capital of Spain?",
            answersList = listOf("Paris", "London", "Berlin", "Madrid"),
            correctChoice = "Madrid",
            isAnswerCorrect = false
        ),
        QuizItem(
            3,
            question = "What is the capital of England?",
            answersList = listOf("Paris", "London", "Berlin", "Madrid"),
            correctChoice = "London",
            isAnswerCorrect = false
        )
    )
    val score = mutableStateOf("")
    fun checkAnswer(quizItem: QuizItem,answer:String){
        quizList.map {
            if(it==quizItem && answer==it.correctChoice){
                it.copy(isAnswerCorrect=true)
            } else if (it==quizItem && answer!= it.correctChoice){
                it.copy(isAnswerCorrect = false)
            } else{
                it
            }
        }.toMutableList()

    }
    fun numOfsumbit(): Int {
        return quizList.filter { it.isAnswerCorrect==true }.size
    }

}