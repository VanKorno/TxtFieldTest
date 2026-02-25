package io.github.vankorno.txtfield._ui.shared

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.vankorno.vankornocompose.dp3
import com.vankorno.vankornocompose.sp2
import com.vankorno.vankornocompose.theme_main.LibColor
import com.vankorno.vankornocompose.transl.translate
import com.vankorno.vankornocompose.values.MOD_MaxW

@Composable
fun DrukUiTitleS(                                           transl: Lazy<Map<String, Lazy<String>>>,
                                                          maxLines: Int = 3,
) = DrukUiTitleS(translate(transl), maxLines)


@Composable
fun DrukUiTitleS(                                                                   text: String,
                                                                                maxLines: Int = 3
) {
    Text(
        modifier = MOD_MaxW
            .padding(bottom = 10.dp3())
        ,
        text = text,
        color = LibColor.WhiteText.color,
        style = MaterialTheme.typography.titleMedium.copy(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(6f, 6f),
                blurRadius = 7f
            )
        ),
        fontSize = 20.sp2(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        maxLines = maxLines,
    )
}





