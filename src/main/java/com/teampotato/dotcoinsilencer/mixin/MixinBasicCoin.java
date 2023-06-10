package com.teampotato.dotcoinsilencer.mixin;

import com.teampotato.dotcoinsilencer.DotCoinSilencer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import uk.co.dotcode.coin.item.BasicCoin;

import java.util.UUID;

@Mixin(BasicCoin.class)
public abstract class MixinBasicCoin {
    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;sendMessage(Lnet/minecraft/util/text/ITextComponent;Ljava/util/UUID;)V"))
    private void onUse(PlayerEntity player, ITextComponent text, UUID uuid) {
        if (DotCoinSilencer.sendMessage.get()) player.sendMessage(text, uuid);
    }
}
