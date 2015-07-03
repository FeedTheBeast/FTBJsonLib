package net.ftb.jsonlib;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import net.ftb.jsonlib.adapters.DateAdapter;
import net.ftb.jsonlib.adapters.EnumAdaptorFactory;
import net.ftb.jsonlib.adapters.FileAdapter;
import net.ftb.jsonlib.adapters.MapAdapter;
import net.ftb.jsonlib.adapters.OptionalAdapter;
import net.ftb.jsonlib.adapters.PackAdapter;
import net.ftb.jsonlib.adapters.TPAdapter;
import net.ftb.jsonlib.lists.Maps;
import net.ftb.jsonlib.lists.Packs;
import net.ftb.jsonlib.lists.TPs;
import net.ftb.jsonlib.service.DownloadService;

import java.io.File;
import java.util.Date;

/**
 * Created by progwml6 on 5/26/15.
 */
public class JsonLib {

    @Getter
    private static Gson GSON;


    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(new EnumAdaptorFactory());
        builder.registerTypeAdapter(Date.class, new DateAdapter());
        builder.registerTypeAdapter(File.class, new FileAdapter());
        builder.registerTypeAdapter(Optional.class, new OptionalAdapter());
        builder.registerTypeAdapter(Maps.class, new MapAdapter());
        builder.registerTypeAdapter(TPs.class, new TPAdapter());
        builder.registerTypeAdapter(Packs.class, new PackAdapter());
        builder.enableComplexMapKeySerialization();
        builder.setPrettyPrinting();
        GSON = builder.create();
    }

}
