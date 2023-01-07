package com.javfairuz.bercerita.question

data class QuestionModel(
    var question:String="",
    var number:Int=0,
    var options:List<OptionsModel> = listOf()
)

data class OptionsModel(
    var answer:String="",
    var score:Int=0,
    var key:String=""
)


