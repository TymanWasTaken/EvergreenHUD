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

package dev.isxander.evergreenhud.elements.impl

import dev.isxander.evergreenhud.api.mc
import dev.isxander.evergreenhud.elements.ElementMeta
import dev.isxander.evergreenhud.elements.type.MultiLineTextElement
import dev.isxander.evergreenhud.utils.Facing
import dev.isxander.settxi.impl.*
import java.text.DecimalFormat

@ElementMeta(id = "COORDINATES", name = "Coordinates", description = "Show your current coordinates in the world.", category = "World")
class ElementCoordinates : MultiLineTextElement() {
    var displayMode by option(
        default = DisplayMode.VERTICAL,
        name = "Mode",
        category = "Coordinates",
        description = "How the coordinates should be displayed.",
    )

    var showAxis by boolean(
        default = true,
        name = "Show Axis",
        category = "Coordinates",
        description = "Show the 'X: ' before the number."
    )

    var showDirection by boolean(
        default = false,
        name = "Show Direction",
        category = "Coordinates",
        description = "Show if the axis is going to increase or decrease depending on the direction you are facing."
    )

    var showX by boolean(
        default = true,
        name = "Show X",
        category = "Coordinates",
        description = "Show the X axis."
    )

    var showY by boolean(
        default = true,
        name = "Show Y",
        category = "Coordinates",
        description = "Show the Y axis."
    )

    var showZ by boolean(
        default = true,
        name = "Show Z",
        category = "Coordinates",
        description = "Show the Z axis."
    )

    var accuracy by int(
        default = 0,
        name = "Accuracy",
        category = "Coordinates",
        description = "How many decimal places the value should display.",
        min = 0,
        max = 16
    )

    var trailingZeros by boolean(
        default = false,
        name = "Trailing Zeros",
        category = "Coordinates",
        description = "Match the accuracy using zeros."
    )

    init {
        title = "Coords"
    }

    override fun calculateValue(): ArrayList<String> {
        val lines = arrayListOf<String>()
        if (mc.player.equals(null)) {
            lines.add("Unknown")
            return lines
        }

        val formatter = if (trailingZeros) "0" else "#"
        val formatBuilder = StringBuilder(if (accuracy < 1) formatter else "$formatter.")
        for (i in 0 until accuracy) formatBuilder.append(formatter)
        val df = DecimalFormat(formatBuilder.toString())

        val sb = StringBuilder()
        val facing = Facing.parseExact(mc.player.yaw)
        if (showX) {
            sb.append(if (showAxis) "X: " else "")
            sb.append(df.format(mc.player.x))
            if (showDirection) {
                sb.append(" (")

                sb.append(when (facing) {
                    Facing.EAST, Facing.NORTH_EAST, Facing.SOUTH_EAST -> "+"
                    Facing.WEST, Facing.NORTH_WEST, Facing.SOUTH_WEST -> "-"
                    else -> " "
                })

                sb.append(")")
            }
            if (displayMode == DisplayMode.VERTICAL) {
                lines.add(sb.toString())
                sb.setLength(0)
            } else if (showY || showZ) {
                sb.append(", ")
            }
        }
        if (showY) {
            sb.append(if (showAxis) "Y: " else "")
            sb.append(df.format(mc.player.y))
            if (displayMode == DisplayMode.VERTICAL) {
                lines.add(sb.toString())
                sb.setLength(0)
            } else if (showZ) {
                sb.append(", ")
            }
        }
        if (showZ) {
            sb.append(if (showAxis) "Z: " else "")
            sb.append(df.format(mc.player.z))
            if (showDirection) {
                sb.append(" (")

                sb.append(when (facing) {
                    Facing.NORTH, Facing.NORTH_EAST, Facing.NORTH_WEST -> "-"
                    Facing.SOUTH, Facing.SOUTH_WEST, Facing.SOUTH_EAST -> "+"
                    else -> " "
                })

                sb.append(")")
            }
            if (displayMode == DisplayMode.VERTICAL) {
                lines.add(sb.toString())
                sb.setLength(0)
            }
        }

        if (displayMode == DisplayMode.HORIZONTAL) {
            lines.add(sb.toString())
        }
        return lines
    }

    object DisplayMode : OptionContainer() {
        val VERTICAL = option("Vertical", "Display each axis in a list.")
        val HORIZONTAL = option("Horizontal", "Display each axis in-line, seperated by a comma.")
    }

}