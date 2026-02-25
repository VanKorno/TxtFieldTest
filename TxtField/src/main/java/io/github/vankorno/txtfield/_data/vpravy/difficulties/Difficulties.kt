package io.github.vankorno.txtfield._data.vpravy.difficulties

import com.vankorno.vankornohelpers.convenience.libRandom
import io.github.vankorno.txtfield._data.difficultyLevel

object Difficulties {
    var typingUnits = emptyArray<String>()
    
    fun getDiffTypingUnit(): String {
        if (typingUnits.isEmpty())
            updateSet()
        
        val idx = typingUnits.indices.libRandom()
        val example = typingUnits[idx]
        
        val ending = if (difficultyLevel < 3)
                        " "
                    else if (difficultyLevel == 3  ||  example.last() != '\n')
                        "\n"
                    else
                        ""
        return example + ending
    }
    
    
    fun updateSet() {
        val units = DiffTypingUnits()
        typingUnits = when (difficultyLevel) {
            1 -> units.lvl1()
            2 -> units.lvl2()
            3 -> units.lvl3()
            4 -> units.lvl4()
            5 -> units.lvl5()
            else -> units.lvl6()
        }
    }
    
}


