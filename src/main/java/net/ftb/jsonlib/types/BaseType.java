package net.ftb.jsonlib.types;

import com.google.common.base.Optional;

/**
 * Created by progwml6 on 5/26/15.
 */
public class BaseType {
    public String icon;
    public String splash;
    public String author;
    public String description;
    public String title;
    public String version;
    public String dir;
    public String name;
    public int format;
    public Optional<String> curseProjectId = Optional.absent();
    public Optional<String> syncRule = Optional.absent();
    public Optional<String> squareImage = Optional.absent();
}
