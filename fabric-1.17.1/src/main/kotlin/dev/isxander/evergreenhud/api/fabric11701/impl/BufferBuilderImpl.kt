/*
 * EvergreenHUD - A mod to improve on your heads-up-display.
 * Copyright (C) isXander [2019 - 2021]
 *
 * This program comes with ABSOLUTELY NO WARRANTY
 * This is free software, and you are welcome to redistribute it
 * under the certain conditions that can be found here
 * https://www.gnu.org/licenses/lgpl-2.1.en.html
 *
 * If you have any questions or concerns, please create
 * an issue on the github page that can be found here
 * https://github.com/isXander/EvergreenHUD
 *
 * If you have a private concern, please contact
 * isXander @ business.isxander@gmail.com
 */

package dev.isxander.evergreenhud.api.fabric11701.impl

import dev.isxander.evergreenhud.api.impl.render.DrawMode
import dev.isxander.evergreenhud.api.impl.render.UBufferBuilder
import dev.isxander.evergreenhud.api.impl.render.VertexFormats
import net.minecraft.client.render.BufferBuilder
import net.minecraft.client.render.BufferRenderer
import net.minecraft.client.render.Tessellator
import net.minecraft.client.render.VertexFormat
import net.minecraft.client.render.VertexFormats as MinecraftVertexFormats

class BufferBuilderImpl : UBufferBuilder() {

    private val tes = Tessellator.getInstance()
    private val buf: BufferBuilder = tes.buffer

    override fun vertex(x: Double, y: Double, z: Double): UBufferBuilder {
        buf.vertex(x, y, z)
        return this
    }

    override fun color(r: Float, g: Float, b: Float, a: Float): UBufferBuilder {
        buf.color(r, g, b, a)
        return this
    }

    override fun tex(u: Double, v: Double): UBufferBuilder {
        buf.texture(u.toFloat(), v.toFloat())
        return this
    }

    override fun next(): UBufferBuilder {
        buf.next()
        return this
    }
    override fun end(): UBufferBuilder {
        buf.end()
        return this
    }

    override fun begin(mode: DrawMode, format: VertexFormats): UBufferBuilder {
        val parsedFormat = when (format) {
            VertexFormats.POSITION -> MinecraftVertexFormats.POSITION
            VertexFormats.POSITION_COLOR -> MinecraftVertexFormats.POSITION_COLOR
            VertexFormats.POSITION_TEXTURE -> MinecraftVertexFormats.POSITION_TEXTURE
            VertexFormats.POSITION_COLOR_TEXTURE -> MinecraftVertexFormats.POSITION_COLOR_TEXTURE
        }
        val parsedMode = when (mode) {
            DrawMode.LINES -> VertexFormat.DrawMode.LINES
            DrawMode.LINE_STRIP -> VertexFormat.DrawMode.LINE_STRIP
            DrawMode.TRIANGLES -> VertexFormat.DrawMode.TRIANGLES
            DrawMode.TRIANGLE_STRIP -> VertexFormat.DrawMode.TRIANGLE_STRIP
            DrawMode.TRIANGLE_FAN -> VertexFormat.DrawMode.TRIANGLE_FAN
            DrawMode.QUADS -> VertexFormat.DrawMode.QUADS
        }

        buf.begin(parsedMode, parsedFormat)

        return this
    }

    override fun draw() = BufferRenderer.draw(buf)

}