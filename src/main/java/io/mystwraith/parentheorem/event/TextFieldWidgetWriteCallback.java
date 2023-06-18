package io.mystwraith.parentheorem.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
//import net.minecraft.client.gui.widget.TextFieldWidget;

public interface TextFieldWidgetWriteCallback {
    Event<TextFieldWidgetWriteCallback> EVENT = EventFactory.createArrayBacked(TextFieldWidgetWriteCallback.class, 
        (listeners) -> (text, sText, string) -> {
            String og = string;
            for (TextFieldWidgetWriteCallback listener : listeners) {
                string = listener.write(text, sText, string);

                if (string != og) {
                    return string;
                }
            }
            return og;
        }
    );

    String write(String text, String sText, String string);
}
