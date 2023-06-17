package io.mystwraith.myfirstmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.mystwraith.myfirstmod.event.TextFieldWidgetCallback;
import net.minecraft.client.gui.widget.TextFieldWidget;

@Mixin(TextFieldWidget.class)
public class TextFieldMixin {
    
    @Inject(method = "charTyped(CI)Z", at = @At(value = "INVOKE", target = "java/lang/Character.toString (C)Ljava/lang/String"))
    public void onKeyPressed(char chr, int modifiers, CallbackInfoReturnable<Void> ci) {
        TextFieldWidgetCallback.EVENT.invoker().keyPressed(chr, modifiers);
    }
}
