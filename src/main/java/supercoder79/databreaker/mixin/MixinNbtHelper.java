package supercoder79.databreaker.mixin;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.Dynamic;
import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.datafixer.NbtOps;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(NbtHelper.class)
public class MixinNbtHelper {
    /**
     * @author
     */
    @Overwrite
    public static CompoundTag update(DataFixer fixer, DataFixTypes fixTypes, CompoundTag tag, int oldVersion, int currentVersion) {
        return (CompoundTag)fixer.update(fixTypes.getTypeReference(), new Dynamic(NbtOps.INSTANCE, tag), oldVersion, currentVersion).getValue();
    }

}
