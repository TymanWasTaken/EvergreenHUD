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

package co.uk.isxander.evergreenhud.elements;

import co.uk.isxander.evergreenhud.elements.impl.*;

public enum ElementType {
    ARMOUR(ElementArmour.class),
    BIOME(ElementBiome.class),
    BLOCK_ABOVE(ElementBlockAbove.class),
    CHUNK_UPDATES(ElementChunkUpdates.class),
    COMBO(ElementCombo.class),
    COORDS(ElementCoordinates.class),
    CPS(ElementCps.class),
    DAY(ElementDay.class),
    DIRECTION(ElementDirection.class),
    ENTITY_COUNT(ElementEntityCount.class),
    FPS(ElementFps.class),
    HYPIXEL_GAME(ElementHypixelGame.class),
    HYPIXEL_MAP(ElementHypixelMap.class),
    HYPIXEL_MODE(ElementHypixelMode.class),
    IMAGE(ElementImage.class),
    LIGHT(ElementLight.class),
    MEMORY(ElementMemory.class),
    PING(ElementPing.class),
    PITCH(ElementPitch.class),
    PLAYER_PREVIEW(ElementPlayerPreview.class),
    REACH(ElementReach.class),
    SERVER(ElementServer.class),
    SPEED(ElementSpeed.class),
    TEXT(ElementText.class),
    TIME(ElementTime.class),
    YAW(ElementYaw.class);

    private final Class<? extends Element> element;
    ElementType(Class<? extends Element> element) {
        this.element = element;
    }

    public Class<? extends Element> getElementClass() {
        return element;
    }

    public Element getElement() {
        try {
            return element.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ElementType getType(Element element) {
        for (ElementType type : values()) {
            if (type.getElementClass().equals(element.getClass())) {
                return type;
            }
        }
        return null;
    }
}