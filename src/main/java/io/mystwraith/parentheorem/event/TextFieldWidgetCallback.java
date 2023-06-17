package io.mystwraith.parentheorem.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface TextFieldWidgetCallback {
    Event<TextFieldWidgetCallback> EVENT = EventFactory.createArrayBacked(TextFieldWidgetCallback.class, 
        (listeners) -> (chr, modifiers) -> {
            for (TextFieldWidgetCallback listener : listeners) {
                listener.keyPressed(chr, modifiers);
            }
        }
    );

    void keyPressed(char chr, int modifiers);
}
