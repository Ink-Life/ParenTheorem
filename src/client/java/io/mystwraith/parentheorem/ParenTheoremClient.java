package io.mystwraith.parentheorem;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mystwraith.parentheorem.event.TextFieldWidgetKeyPressedCallback;
import io.mystwraith.parentheorem.event.TextFieldWidgetWriteCallback;

public class ParenTheoremClient implements ClientModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("myfirstmod");

    @Override
    public void onInitializeClient() {

        TextFieldWidgetKeyPressedCallback.EVENT.register((chr, modifiers) -> {
            //LOGGER.info("Hi, " + Character.toString(chr) + " was pressed.");
        });

        TextFieldWidgetWriteCallback.EVENT.register((text, sText, string) -> {
            if (string.equals("(")) {
                return "(" + sText + ")";
            }
            return string;
        });
    }
}