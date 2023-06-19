package io.mystwraith.parentheorem.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface TextFieldWidgetKeyPressedCallback {
    Event<TextFieldWidgetKeyPressedCallback> EVENT = EventFactory.createArrayBacked(TextFieldWidgetKeyPressedCallback.class, 
        (listeners) -> (chr, modifiers) -> {
            for (TextFieldWidgetKeyPressedCallback listener : listeners) {
                listener.keyPressed(chr, modifiers);
            }
        }
    );

    void keyPressed(char chr, int modifiers);
}
