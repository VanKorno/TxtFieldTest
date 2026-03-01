package io.github.vankorno.txtfield._ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vankorno.vankornocompose.dp3
import com.vankorno.vankornocompose.theme_main.LibColor
import com.vankorno.vankornocompose.values.MOD_MaxW

@Composable
fun DrukUiPracticeTypeBlock(                                title: Lazy<Map<String, Lazy<String>>>,
                                                            color: Color = LibColor.Surface.color,
                                                          content: @Composable ColumnScope.()->Unit,
) {
    Column(
        MOD_MaxW
            .padding(bottom = 20.dp)
            .background(color, RoundedCornerShape(15.dp))
            .padding(
                vertical = 8.dp3(),
                horizontal = 6.dp3()
            )
    ) {
        DrukUiTitleS(title)
        
        content()
    }
}


@Composable
fun DrukUiPracticeSetBlock(                                  title: Lazy<Map<String, Lazy<String>>>,
                                                           content: @Composable RowScope.()->Unit,
) {
    DrukUiPracticeTypeBlock(title) {
        Row(
            MOD_MaxW
                .padding(top = 5.dp, bottom = 5.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            content()
        }
    }
}