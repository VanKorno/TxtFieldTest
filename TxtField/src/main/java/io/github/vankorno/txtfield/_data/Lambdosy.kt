package io.github.vankorno.txtfield._data

import com.vankorno.vankornohelpers.lambdaError
import io.github.vankorno.txtfield._vm.VmTycjalkaHolder.vmTycjalka

// Must init

//var newTypingExercise: ()->Unit = { lambdaError("newExercise") }

var onFinishTyping: ()->Unit = { vmTycjalka.startOver() }


// Optional
/**
 * Optional additional actions.
 */
var onTypingError: ()->Unit = {}

/**
 * Optional additional actions.
 */
var onTypingParagraphFinish: ()->Unit = {}



// Internal

var focusOnTypingInputField: ()->Unit = {}
    internal set

internal var scrollTvToTop: ()->Unit = { lambdaError("scrollTvToTop") }








