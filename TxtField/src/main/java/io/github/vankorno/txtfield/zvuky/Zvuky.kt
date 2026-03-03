package io.github.vankorno.txtfield.zvuky

fun getClickSound(lastChar: Char) = if (lastChar == ' '  ||  lastChar == '\n')
                                        KlavaSoundClickLarge
                                    else
                                        KlavaSoundClick