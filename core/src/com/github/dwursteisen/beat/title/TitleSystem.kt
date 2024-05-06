package com.github.dwursteisen.beat.title

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family.all
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.math.Interpolation
import com.github.dwursteisen.beat.game.EntityRender
import com.github.dwursteisen.beat.game.Position
import com.github.dwursteisen.beat.game.Size
import com.github.dwursteisen.beat.game.invoke
import com.github.dwursteisen.libgdx.ashley.StateComponent
import com.github.dwursteisen.libgdx.ashley.get

class TitleSystem : IteratingSystem(all(Title::class.java).get()) {
    private val duration = 1f
    private val state: ComponentMapper<StateComponent> = get()
    private val render: ComponentMapper<EntityRender> = get()
    private val size: ComponentMapper<Size> = get()
    private val position: ComponentMapper<Position> = get()
    private val title: ComponentMapper<Title> = get()

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val alpha = Interpolation.bounceOut.invoke(Math.min(duration, entity[state].time / duration))
        val w = entity[render].texture.regionWidth * alpha
        val h = entity[render].texture.regionHeight * alpha

        entity[size].size.set(w, h)

        val x = entity[title].target.x - w * 0.5f
        val y = entity[title].target.y - h * 0.5f
        entity[position].position.set(x, y)
    }
}