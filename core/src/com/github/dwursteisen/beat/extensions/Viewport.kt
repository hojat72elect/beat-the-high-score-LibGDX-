package com.github.dwursteisen.beat.extensions

import com.badlogic.gdx.utils.viewport.Viewport

/**
 * Centers the camera to the center of the [Viewport].
 */
fun Viewport.centerCamera() {
    camera.position.set(worldWidth / 2, worldHeight / 2, 0f)
    camera.update()
}