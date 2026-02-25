package io.github.vankorno.txtfield._ui.tycjalka

import android.view.KeyEvent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vankorno.vankornocompose.actions.libRequest
import com.vankorno.vankornohelpers.values.showKeyboard
import io.github.vankorno.txtfield._data.focusOnTextField
import io.github.vankorno.txtfield._logic.TyperOps


@Composable
fun TypingInputContainer() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
        TypingInput()
    }
}


@Composable
fun TypingInput() {
    val inputState by remember { mutableStateOf(TextFieldValue()) }
    val focusRequester = remember { FocusRequester() }
    focusOnTextField = { focusRequester.libRequest() }
    
    TextField(
        modifier = Modifier
            .widthIn(min = 1.dp, max = 5.dp)
            .focusRequester(focusRequester)
            .onGloballyPositioned {
                if (focusOnTextField())
                    showKeyboard()
            }
            .onKeyEvent {                          /* import androidx.compose.ui.input.key.onKeyEvent      import android.view.KeyEvent */
                when (it.nativeKeyEvent.keyCode) {
                    KeyEvent.KEYCODE_DPAD_UP,
                    KeyEvent.KEYCODE_DPAD_DOWN,
                    KeyEvent.KEYCODE_DPAD_LEFT,
                    KeyEvent.KEYCODE_DPAD_RIGHT -> { /*true*/ }
                }
                false
            }
        ,
        value = inputState,
        onValueChange = { newState ->
            // region Dis.LOG
            //Log.d("TypingInput", "oldTxt = ${inputState.text}, oldSelection = ${inputState.selection.start}-${newState.selection.end}")
            //Log.d("TypingInput", "newTxt = ${newState.text}, newSelection = ${newState.selection.start}-${newState.selection.end}")
            // endregion
            if (newState.text.length == inputState.text.length + 1) // one char only
                TyperOps.onValueChangeOther(newState)
        },
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            
            focusedTextColor = Color.Transparent,
            unfocusedTextColor = Color.Transparent,
            
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(fontSize = 4.sp),
        maxLines = 2,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.None,
            autoCorrect = false
        )
    )
}









