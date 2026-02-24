package io.github.vankorno.txtfield._ui.tycjalka

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.vankorno.vankornocompose.sp1
import com.vankorno.vankornocompose.values.MOD_MaxW
import io.github.vankorno.txtfield.obrobkaTekstu.formatTypedText

@Composable
fun TvTextToType(                                                 exerciseText: Array<CharArray>,
                                                                  paragraphIdx: Int,
                                                                       charIdx: Int,
                                                                    isMisclick: Boolean,
                                                                 notTypedColor: Color = Color.White,
) {
    Text(
         modifier = MOD_MaxW
             .padding(bottom=80.dp, start=5.dp, end=5.dp)
        ,
        text =
        if (exerciseText.isEmpty() || exerciseText[paragraphIdx].isEmpty()) {
             AnnotatedString("")
        }
        else {
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.DarkGray)
                ) {
                    val txtDone = String(exerciseText[paragraphIdx].sliceArray(0 until charIdx))
                    append(formatTypedText(txtDone))
                }
                withStyle(
                    style = SpanStyle(
                        color = if (isMisclick)  Color.Red  else  notTypedColor,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    val charToType = exerciseText[paragraphIdx][charIdx].toString()
                    append(formatTypedText(charToType))
                }
                val sizeP = exerciseText[paragraphIdx].size
                val txtLeft = String(exerciseText[paragraphIdx].sliceArray(charIdx+1 until sizeP))
                append(formatTypedText(txtLeft))
                
                val paragraphCount = exerciseText.size
                if (paragraphCount > paragraphIdx+1) {
                    for (ii  in  paragraphIdx+1 until minOf(paragraphCount, paragraphIdx + 6)) {
                        append(formatTypedText( String(exerciseText[ii]) ))
                    }
                }
            }
        },
        textAlign = TextAlign.Start,
        color = notTypedColor,
        fontSize = 22.sp1(),
        fontWeight = FontWeight.Bold,
        lineHeight = 33.sp1(),
        letterSpacing = 0.1.em,
        //overflow = TextOverflow.Ellipsis
    )
}