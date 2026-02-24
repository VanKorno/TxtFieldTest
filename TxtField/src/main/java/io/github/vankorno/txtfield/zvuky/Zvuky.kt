package io.github.vankorno.txtfield.zvuky

fun getClickSound(lastChar: Char) = if (lastChar == ' '  ||  lastChar == '\n')
                                        KlavaSound.ClickLarge.file
                                    else
                                        KlavaSound.Click.file