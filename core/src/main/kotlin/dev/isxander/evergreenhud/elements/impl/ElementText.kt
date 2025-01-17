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

import dev.isxander.evergreenhud.elements.ElementMeta
import dev.isxander.evergreenhud.elements.type.SimpleTextElement
import dev.isxander.settxi.impl.string

@ElementMeta(id = "TEXT", name = "Text Display", category = "Other", description = "Displays custom text of your choosing.")
class ElementText : SimpleTextElement() {
    var text by string(
        default = "Sample Text",
        name = "Text",
        category = "Text",
        description = "The text to display."
    )

    init {
        title = ""
    }

    override fun calculateValue(): String = text
}