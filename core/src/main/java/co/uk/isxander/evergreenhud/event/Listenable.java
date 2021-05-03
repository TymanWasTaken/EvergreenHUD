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

package co.uk.isxander.evergreenhud.event;

import co.uk.isxander.evergreenhud.event.impl.*;

public interface Listenable {

    boolean canReceiveEvents();

    default void onClientTick(ClientTickEvent event) {

    }

    default void onRenderTick(RenderEvent event) {

    }

    default void onRenderHud(RenderHud event) {

    }

    default void onAttackEntity(AttackEntityEvent event) {

    }

    default void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {

    }

    default void onLivingHurt(LivingHurtEvent event) {

    }

    default void onPacketReceive(PacketEvent.Incoming event) {

    }

}