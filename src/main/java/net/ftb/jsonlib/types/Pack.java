package net.ftb.jsonlib.types;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by progwml6 on 5/26/15.
 */
public class Pack extends BaseType {
    public String clientPack;
    public Optional<String> serverPack = Optional.absent();
    public List<Mod> mods;
    @SerializedName("public")
    public boolean isPublic;
    public Optional<Boolean> bundledMap = Optional.absent();
    public Optional<Boolean> customTP = Optional.absent();
    public Optional<String> minJRE = Optional.absent();
    public Optional<String> minRam = Optional.absent();
    public Optional<String> minLaunchSpec = Optional.absent();
    public Optional<String> warning = Optional.absent();
    public Optional<String> animation = Optional.absent();

}
