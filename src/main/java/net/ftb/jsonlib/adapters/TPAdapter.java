package net.ftb.jsonlib.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.ftb.jsonlib.JsonLib;
import net.ftb.jsonlib.lists.TPs;
import net.ftb.jsonlib.types.TP;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by progwml6 on 5/26/15.
 */
public class TPAdapter implements JsonSerializer<TPs>, JsonDeserializer<TPs> {
    @Override public TPs deserialize (JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = element.getAsJsonObject();

        TPs tps = new TPs();

        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            TP tp = JsonLib.getGSON().fromJson(entry.getValue(), TP.class);
            tps.tps.add(tp);
        }

        return tps;
    }

    @Override public JsonElement serialize (TPs src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        for (TP tp : src.tps) {
            json.addProperty(tp.dir, JsonLib.getGSON().toJson(tp));
        }

        return json;
    }
}
