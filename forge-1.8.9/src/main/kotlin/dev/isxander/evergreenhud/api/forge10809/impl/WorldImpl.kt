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

package dev.isxander.evergreenhud.api.forge10809.impl

import dev.isxander.evergreenhud.api.forge10809.mc
import dev.isxander.evergreenhud.api.impl.UWorld
import net.minecraft.util.BlockPos

class WorldImpl : UWorld() {
    override val isNull: Boolean = mc.theWorld == null

    override fun getBiomeAt(x: Int, y: Int, z: Int): String =
        mc.theWorld.getBiomeGenForCoords(BlockPos(x, y, z)).biomeName

    override val time: Long
        get() = mc.theWorld.worldTime
}