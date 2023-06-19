package io.mystwraith.parentheorem.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.mystwraith.parentheorem.event.TextFieldWidgetKeyPressedCallback;
import io.mystwraith.parentheorem.event.TextFieldWidgetWriteCallback;

import net.minecraft.client.gui.widget.TextFieldWidget;

@Mixin(TextFieldWidget.class)
public class TextFieldMixin {
    @Shadow
    String text;

    @Shadow
    public String getSelectedText() {return "";}
    
    @Inject(method = "charTyped(CI)Z", at = @At(value = "INVOKE", target = "java/lang/Character.toString (C)Ljava/lang/String;"))
    public void onKeyPressed(char chr, int modifiers, CallbackInfoReturnable<Void> ci) {
        TextFieldWidgetKeyPressedCallback.EVENT.invoker().keyPressed(chr, modifiers);
    }

    @ModifyVariable(method="write(Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "net/minecraft/SharedConstants.stripInvalidChars (Ljava/lang/String;)Ljava/lang/String;", shift = At.Shift.BY, by = 2), ordinal = 1)
    public String onWrite(String string) {
        return TextFieldWidgetWriteCallback.EVENT.invoker().write(text, getSelectedText(), string);
    }
}
