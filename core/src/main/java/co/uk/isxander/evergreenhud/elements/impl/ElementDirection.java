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

package co.uk.isxander.evergreenhud.elements.impl;

import co.uk.isxander.evergreenhud.elements.Element;
import co.uk.isxander.xanderlib.utils.Facing;
import co.uk.isxander.evergreenhud.settings.impl.BooleanSetting;
import co.uk.isxander.evergreenhud.elements.ElementData;

public class ElementDirection extends Element {

    private BooleanSetting abbreviated;

    @Override
    public void initialise() {
        addSettings(abbreviated = new BooleanSetting("Abbreviated", "If the direction should be abbreviated to \"N\" from \"North\"", true));
    }

    @Override
    public ElementData metadata() {
        return new ElementData("Direction", "Shows what direction you are facing.");
    }

    @Override
    protected String getValue() {
        Facing facing = Facing.parse(mc.player().getYaw());

        if (abbreviated.get())
            return facing.getAbbreviated();
        return facing.getNormal();
    }

    @Override
    public String getDisplayTitle() {
        return "Direction";
    }

}