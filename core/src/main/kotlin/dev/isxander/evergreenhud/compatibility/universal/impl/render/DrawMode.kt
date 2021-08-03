/*
 | EvergreenHUD - A mod to improve on your heads-up-display.
 | Copyright (C) isXander [2019 - 2021]
 |
 | This program comes with ABSOLUTELY NO WARRANTY
 | This is free software, and you are welcome to redistribute it
 | under the certain conditions that can be found here
 | https://www.gnu.org/licenses/lgpl-3.0.en.html
 |
 | If you have any questions or concerns, please create
 | an issue on the github page that can be found here
 | https://github.com/isXander/EvergreenHUD
 |
 | If you have a private concern, please contact
 | isXander @ business.isxander@gmail.com
 */

package dev.isxander.evergreenhud.compatibility.universal.impl.render

enum class DrawMode(val glNum: Int) {
    LINES(AIGL11.GL_LINES),
    LINE_STRIP(AIGL11.GL_LINE_STRIP),

    TRIANGLES(AIGL11.GL_TRIANGLES),
    TRIANGLE_STRIP(AIGL11.GL_TRIANGLE_STRIP),
    TRIANGLE_FAN(AIGL11.GL_TRIANGLE_FAN),

    QUADS(AIGL11.GL_QUADS)
}