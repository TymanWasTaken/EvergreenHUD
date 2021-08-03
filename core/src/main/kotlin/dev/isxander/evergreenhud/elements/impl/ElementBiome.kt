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

package dev.isxander.evergreenhud.elements.impl

import dev.isxander.evergreenhud.compatibility.universal.MC
import dev.isxander.evergreenhud.compatibility.universal.WORLD
import dev.isxander.evergreenhud.elements.ElementMeta
import dev.isxander.evergreenhud.elements.type.SimpleTextElement

@ElementMeta(id = "BIOME", name = "Biome Display", description = "Displays the current biome you are in.", category = "World")
class ElementBiome : SimpleTextElement() {

    override var title: String = "Biome"

    override fun calculateValue(): String {
        val player = MC.player
        if (player.equals(null)) return "Unknown"
        return WORLD.getBiomeAt(player.x.toInt(), player.y.toInt(), player.z.toInt()).display
    }

}