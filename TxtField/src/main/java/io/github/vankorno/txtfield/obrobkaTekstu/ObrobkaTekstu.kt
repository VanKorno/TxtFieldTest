package io.github.vankorno.txtfield.obrobkaTekstu

internal fun formatTypedText(                                                        txt: String
): String {
    if (txt.isEmpty())
        return txt //\/\/\/\/\/\
    
    val enterArrow = "⤵\n"
    return txt.replace("\n", enterArrow)
        .replace(" ", "\u00A0· ")
}