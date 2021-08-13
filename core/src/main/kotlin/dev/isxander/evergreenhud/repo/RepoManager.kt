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

package dev.isxander.evergreenhud.repo

import com.typesafe.config.ConfigFactory
import dev.isxander.evergreenhud.EvergreenInfo
import dev.isxander.evergreenhud.utils.asConfig
import dev.isxander.evergreenhud.utils.getRemoteString
import dev.isxander.evergreenhud.utils.int
import java.lang.Exception

object RepoManager {

    private const val jsonUrl = "https://dl.isxander.dev/mods/evergreenhud/info.json"

    fun getResponse(): RepoResponse {
        val out = try { getRemoteString(jsonUrl) }
        catch (e: Exception) { return RepoResponse(outdated = false, blacklisted = false) }

        val data = ConfigFactory.parseString(out)

        val blacklisted = data.getStringList("blacklisted").contains(EvergreenInfo.REVISION)

        val latestJson = data.getObject("latest")
        val major = latestJson.getOrDefault("major", 1.asConfig()).int()
        val minor = latestJson.getOrDefault("minor", 0.asConfig()).int()
        val patch = latestJson.getOrDefault("patch", 0.asConfig()).int()
        val prerelease = latestJson.getOrDefault("patch", (-1).asConfig()).int()

        val outdated = (EvergreenInfo.VERSION_MAJOR < major
                || EvergreenInfo.VERSION_MINOR < minor
                || EvergreenInfo.VERSION_PATCH < patch
                || (EvergreenInfo.VERSION_PRERELEASE ?: -1) < prerelease)
        return RepoResponse(outdated, blacklisted)
    }

}

data class RepoResponse(val outdated: Boolean, val blacklisted: Boolean)