package io.github.vankorno.txtfield._logic

import androidx.compose.ui.text.input.TextFieldValue
import com.vankorno.vankornocompose.vm.inc
import com.vankorno.vankornohelpers.values.playSound
import io.github.vankorno.txtfield._data.TypingGlobals.typingSoundsAllowed
import io.github.vankorno.txtfield._data.newTypingExercise
import io.github.vankorno.txtfield._data.onFinishTyping
import io.github.vankorno.txtfield._data.onTypingError
import io.github.vankorno.txtfield._data.onTypingParagraphFinish
import io.github.vankorno.txtfield._data.scrollTvToTop
import io.github.vankorno.txtfield._vm.VmTycjalkaHolder.vmTycjalka
import io.github.vankorno.txtfield.zvuky.KlavaSound
import io.github.vankorno.txtfield.zvuky.getClickSound

object TyperOps {
    
    fun onValueChangeOther(                                                  newVal: TextFieldValue
    ) {
        if (vmTycjalka.exerciseText.value.isEmpty()) {
            newTypingExercise()
            return //\/\/\/\/\/\
        }
        val exerciseText = vmTycjalka.exerciseText.value
        val paragraphIdx = vmTycjalka.paragraphIdx.value
        val charIdx = vmTycjalka.charIdx.value
        
        if (paragraphIdx >= exerciseText.size  ||  charIdx >= exerciseText[paragraphIdx].size)
            return //\/\/\/\/\/\  Might fix a rare crash
        
        val lastChar = newVal.text.last()
        val charToType = exerciseText[paragraphIdx][charIdx]
        val isCorrectClick = lastChar == charToType
        
        if (isCorrectClick) {
            vmTycjalka.isMisclick.value = false
            
            val isLastParagraph = exerciseText.size == paragraphIdx + 1
            val isLastChar = exerciseText[paragraphIdx].size == charIdx + 1
            val finished = isLastParagraph  &&  isLastChar
            
            if (finished) {
                onFinishTyping()
            }
            else if (isLastChar) {
                vmTycjalka.paragraphIdx.inc()
                vmTycjalka.charIdx.value = 0
                scrollTvToTop()
                onTypingParagraphFinish()
            }
            else {
                vmTycjalka.charIdx.inc()
            }
            if (typingSoundsAllowed)
                playSound(getClickSound(lastChar))
        }
        else if (lastChar != '\b'  &&  lastChar != '\t') { //-------- ERROR
            vmTycjalka.isMisclick.value = true
            onTypingError()
            
            if (typingSoundsAllowed)
                playSound(KlavaSound.Error.file)
        }
    }
    
    
    
    
    
    
    
    
    
}