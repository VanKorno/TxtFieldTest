package io.github.vankorno.txtfield._vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vankorno.vankornocompose.vm.VmSavedVal
import com.vankorno.vankornocompose.vm.inc
import com.vankorno.vankornohelpers.dLog
import io.github.vankorno.txtfield._vm.VmTycjalkaHolder.vmTycjalka
import io.github.vankorno.txtfield.obrobkaTekstu.normalizeExerciseText

class VmTycjalka(                                                             ssh: SavedStateHandle
) : ViewModel() {
    
    val exerciseText = VmSavedVal<Array<CharArray>>(ssh, "exerciseText", arrayOf())
    
    
    fun updateExerciseText(                                                          new: String
    ) {
        val text = normalizeExerciseText(new)
        
        val singleParagraph = !text.contains("\n")
        val charArrays =
            if (singleParagraph) {
                arrayOf(text.toCharArray())
            } else {
                val chunks = text.split("\n")
                val chunks2 = mutableListOf<CharArray>()
                val lastIdx = chunks.lastIndex
                
                chunks.forEachIndexed { idx, chunk ->
                    val newChunk = if (idx < lastIdx)  chunk+"\n"  else  chunk
                    if (newChunk.isNotEmpty())
                        chunks2.add(newChunk.toCharArray())
                }
                chunks2.toTypedArray()
            }
        exerciseText.value = charArrays
    }
    
    
    val paragraphIdx = VmSavedVal(ssh, "paragraphIdx", 0)
    
    val charIdx = VmSavedVal(ssh, "charIdx", 0)
    
    val repCount = VmSavedVal(ssh, "repCount", -1)
    
    val isMisclick = VmSavedVal(ssh, "isMisclick", false)
    
    
    fun startOver() {
        // region LOG
            dLog("VmTycjalka", "startOver()")
        // endregion
        vmTycjalka.paragraphIdx.value = 0
        vmTycjalka.charIdx.value = 0
        vmTycjalka.repCount.inc()
        vmTycjalka.isMisclick.value = false
    }
    
}