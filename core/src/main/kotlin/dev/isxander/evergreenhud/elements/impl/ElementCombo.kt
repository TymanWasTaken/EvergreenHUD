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
import dev.isxander.evergreenhud.elements.type.SimpleTextElement
import dev.isxander.evergreenhud.event.ClientTickEvent
import dev.isxander.evergreenhud.event.ServerDamageEntity
import dev.isxander.settxi.impl.int
import dev.isxander.settxi.impl.string
import me.kbrewster.eventbus.Subscribe

@ElementMeta(id = "COMBO_DISPLAY", name = "Combo Display", description = "Display how many hits you get on a player before they hit you.", category = "Combat")
class ElementCombo : SimpleTextElement() {
    var discardTime by int(
        default = 3,
        name = "Discard Time",
        category = "Combo",
        description = "How many seconds until the combo is reset.",
        min = 1,
        max = 10
    )

    var noHitMessage by string(
        default = "0",
        name = "No Hit Message",
        category = "Combo",
        description = "What message is shown when no combo is in progress."
    )

    private var hitTime = 0L
    private var attackId = 0
    private var currentCombo = 0

    init {
        title = "Combo"
    }

    override fun calculateValue(): String {
        if (currentCombo == 0) return noHitMessage
        return currentCombo.toString()
    }

    @Subscribe
    fun onClientTick(event: ClientTickEvent) {
        if (System.currentTimeMillis() - hitTime >= discardTime * 1000L) {
            currentCombo = 0
        }
    }

    @Subscribe
    fun onServerAttackEntity(event: ServerDamageEntity) {
        if (event.attacker.id == mc.player.id) {
            if (event.victim.id == attackId) {
                currentCombo++
            } else {
                currentCombo = 1
            }

            hitTime = System.currentTimeMillis()
            attackId = event.victim.id
        }
    }

}