package io.github.vankorno.txtfield._ui

import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vankorno.vankornocompose.navig.Navig
import com.vankorno.vankornocompose.sp2
import com.vankorno.vankornocompose.theme_main.LibAccentColor
import com.vankorno.vankornocompose.theme_main.LibColor
import com.vankorno.vankornocompose.values.LibGlobals2.libVm
import com.vankorno.vankornocompose.values.MOD_MaxW
import com.vankorno.vankornohelpers.values.LibLambdas.hideKeyboard
import io.github.vankorno.txtfield._data.ScrTyper
import io.github.vankorno.txtfield._data.TypingGlobals.typingDifficultyLevel
import io.github.vankorno.txtfield._data.vpravy.DifficultyTyping
import io.github.vankorno.txtfield._data.vpravy.difficulties.Difficulties
import io.github.vankorno.txtfield._translate.TrDiffBlockTitle
import io.github.vankorno.txtfield._ui.shared.DrukUiPracticeTypeBlock
import io.github.vankorno.txtfield._vm.VmTycjalkaHolder.vmTycjalka

@Composable
fun DifficultiesBlock(                                     color: Color = LibAccentColor.Green.color
) {
    DrukUiPracticeTypeBlock(TrDiffBlockTitle, color) {
        DiffBtnRow()
        DiffBtnRow(false)
    }
}


@Composable
private fun DiffBtnRow(                                                  isFirstRow: Boolean = true
) {
    val firstLvl = if (isFirstRow) 1 else 4
    val paddingBetweenBtns = 4.dp
    
    Row(
        MOD_MaxW
            .padding(vertical = paddingBetweenBtns)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val btnModif = Modifier
            .padding(horizontal = paddingBetweenBtns)
            .weight(1f)
            .aspectRatio(1f)
            .border(4.dp, LibColor.WhiteText.color, RoundedCornerShape(10.dp))
        
        DiffBtn(firstLvl, btnModif)
        DiffBtn(firstLvl+1, btnModif)
        DiffBtn(firstLvl+2, btnModif)
    }
}


@Composable
private fun DiffBtn(                                                               level: Int,
                                                                                modifier: Modifier,
) {
    val interactionSource by remember { mutableStateOf(MutableInteractionSource()) }
    
    Box(
        modifier
            .combinedClickable(
                onClick = {
                    hideKeyboard()
                    typingDifficultyLevel = level
                    
                    Difficulties.updateSet()
                    val txt = Difficulties.getDiffTypingUnit()
                    
                    vmTycjalka.newExercise(txt, DifficultyTyping)
                    
                    if (libVm.currScreen.value != ScrTyper)
                        Navig.goTo(ScrTyper)
                },
                onLongClick = {},
                interactionSource = interactionSource,
                indication = null
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = level.toString(),
            textAlign = TextAlign.Center,
            maxLines = 1,
            color = LibColor.WhiteText.color,
            fontSize = 36.sp2(),
            fontWeight = FontWeight.Bold
        )
    }
}






