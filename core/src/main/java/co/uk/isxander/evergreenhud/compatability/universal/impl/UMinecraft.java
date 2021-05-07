/*
 * Copyright (C) isXander [2019 - 2021]
 * This program comes with ABSOLUTELY NO WARRANTY
 * This is free software, and you are welcome to redistribute it
 * under the certain conditions that can be found here
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * If you have any questions or concerns, please create
 * an issue on the github page that can be found here
 * https://github.com/isXander/EvergreenHUD
 *
 * If you have a private concern, please contact
 * isXander @ business.isxander@gmail.com
 */

package co.uk.isxander.evergreenhud.compatability.universal.impl;

import co.uk.isxander.evergreenhud.compatability.universal.impl.entity.UPlayer;
import co.uk.isxander.evergreenhud.compatability.universal.impl.gui.screen.UGuiScreenImp;

import java.io.File;

public interface UMinecraft {

    UPlayer player();

    UFontRenderer fontRenderer();

    File dataDir();

    boolean inGameHasFocus();

    void openGui(UGuiScreenImp gui);

    int getFps();

    int renderedEntityCount();

    ServerInfo getServerInfo();

}
