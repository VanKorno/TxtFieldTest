package io.github.vankorno.txtfield._ui.tycjalka

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vankorno.vankornocompose.LibScreen.Companion.smallUI
import com.vankorno.vankornohelpers.values.LibLambdas.showKeyboard
import io.github.vankorno.txtfield._data.focusOnTypingInputField
import io.github.vankorno.txtfield._data.scrollTvToTop
import kotlinx.coroutines.launch

@Composable
fun BodyTyper(                                                               modifier: Modifier
) {
    val interactionSource by remember { mutableStateOf(MutableInteractionSource()) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    
    scrollTvToTop = {
        scope.launch { scrollState.animateScrollTo(0) }
    }
    
    Column(
        modifier
            .verticalScroll(scrollState)
            .combinedClickable(
                onClick = {
                    focusOnTypingInputField()
                    showKeyboard()
                },
                interactionSource = interactionSource,
                indication = null
            )
            .padding(top = 40.dp, bottom = if (smallUI) 20.dp else 60.dp, start=13.dp, end=13.dp)
        ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TvTextToType()
    }
}