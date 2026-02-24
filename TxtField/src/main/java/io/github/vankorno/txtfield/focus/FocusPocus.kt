// region License
/** This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 *  If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
**/
// endregion
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