package io.github.vankorno.txtfield._data

import io.github.vankorno.txtfield.R

enum class KlavaSound(                                                          val file: Int
) {
    Error(R.raw.error_easy),
    Click(R.raw.keyboard_normal_click),
    ClickLarge(R.raw.keyboard_large_key_click),
    ClickUnique(R.raw.keyboard_key_press_unique), // TODO Not used yet
}