package io.github.vankorno.txtfield.focus

import android.util.Log
import androidx.compose.ui.focus.FocusRequester

@PublishedApi
internal fun FocusRequester.libRequest() =  try {
                                                this.requestFocus()
                                                true
                                            } catch (e: Exception) {
                                                // region LOG
                                                    Log.e("focusOnTextField", "Error: $e")
                                                // endregion
                                                false
                                            }