package net.ftb.jsonlib.adapters;

import com.google.common.base.Optional;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * from
 * http://stackoverflow.com/questions/12161366/how-to-serialize-optionalt-classes-with-gson
 */
public class OptionalAdapter<T> implements JsonSerializer<Optional<T>>, JsonDeserializer<Optional<T>> {

    @Override
    public Optional<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        final JsonArray asJsonArray = json.getAsJsonArray();
        final JsonElement jsonElement = asJsonArray.get(0);
        final T value = context.deserialize(jsonElement, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]);
        return Optional.fromNullable(value);
    }

    @Override
    public JsonElement serialize(Optional<T> src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonElement element = context.serialize(src.orNull());
        final JsonArray result = new JsonArray();
        result.add(element);
        return result;
    }



}

