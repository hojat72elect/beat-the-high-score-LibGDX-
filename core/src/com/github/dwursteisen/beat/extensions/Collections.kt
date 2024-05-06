package com.github.dwursteisen.beat.extensions

import com.badlogic.gdx.utils.Array as GdxArray

inline fun <reified T> Collection<T>.asGdx(): GdxArray<T> {
    return GdxArray(toTypedArray())
}