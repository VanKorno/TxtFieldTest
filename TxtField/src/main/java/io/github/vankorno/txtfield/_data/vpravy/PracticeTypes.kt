package io.github.vankorno.txtfield._data.vpravy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize open class TypingPracticeType : Parcelable

@Parcelize object DefaultTyping : TypingPracticeType()
@Parcelize object SprintTyping : TypingPracticeType()
@Parcelize object DifficultyTyping : TypingPracticeType()
@Parcelize object EdTyping : TypingPracticeType()
