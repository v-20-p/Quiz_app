package com.example.quiz_app.model

data class QuizItem (
    val Id:Int,
    val question:String,
    val answersList:List<String>,
    val correctChoice:String,
    val isAnswerCorrect:Boolean?

)