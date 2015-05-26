package net.ftb.jsonlib.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.ftb.jsonlib.JsonLib;
import net.ftb.jsonlib.lists.Packs;
import net.ftb.jsonlib.types.Pack;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by progwml6 on 5/26/15.
 */
public class PackAdapter implements JsonSerializer<Packs>, JsonDeserializer<Packs> {
    @Override public Packs deserialize (JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = element.getAsJsonObject();

        Packs packs = new Packs();

        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            Pack pack = JsonLib.getGSON().fromJson(entry.getValue(), Pack.class);
            packs.packs.add(pack);
        }

        return packs;
    }

    @Override public JsonElement serialize (Packs src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        for (Pack pack : src.packs) {
            json.addProperty(pack.dir, JsonLib.getGSON().toJson(pack));
        }

        return json;
    }
}
