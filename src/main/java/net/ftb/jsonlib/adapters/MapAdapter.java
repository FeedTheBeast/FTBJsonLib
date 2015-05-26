package net.ftb.jsonlib.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.ftb.jsonlib.JsonLib;
import net.ftb.jsonlib.lists.Maps;
import net.ftb.jsonlib.types.Map;

import java.lang.reflect.Type;

/**
 * Created by progwml6 on 5/26/15.
 */
public class MapAdapter implements JsonSerializer<Maps>, JsonDeserializer<Maps> {

    @Override public Maps deserialize (JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = element.getAsJsonObject();

        Maps maps = new Maps();

        for (java.util.Map.Entry<String, JsonElement> entry : json.entrySet()) {
            Map map = JsonLib.getGSON().fromJson(entry.getValue(), Map.class);
            maps.maps.add(map);
        }

        return maps;
    }

    @Override public JsonElement serialize (Maps src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        for (Map map : src.maps) {
            json.addProperty(map.dir, JsonLib.getGSON().toJson(map));
        }

        return json;
    }
}
