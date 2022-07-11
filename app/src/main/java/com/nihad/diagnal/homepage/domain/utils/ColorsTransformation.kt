package com.nihad.diagnal.homepage.domain.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle

class ColorsTransformation(private val compareWord: String) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            buildAnnotatedStringWithColors(text.toString(),compareWord),
            OffsetMapping.Identity)
    }

    fun buildAnnotatedStringWithColors(text:String,compareWord:String): AnnotatedString{
        val words: List<String> = text.split(compareWord)// splits by whitespace



        val builder = AnnotatedString.Builder()
        words.forEachIndexed {index,word->

            builder.withStyle(style = SpanStyle(color = Color.White)) {
                append("$word")
            }
            if(index!=(words.size-1)) {
                builder.withStyle(style = SpanStyle(color = Color.Yellow)) {
                    append("$compareWord")
                }
            }
        }
        return builder.toAnnotatedString()
    }
}