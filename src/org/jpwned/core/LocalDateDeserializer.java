package org.jpwned.core;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * 
 * @author Dariush Moshiri
 *
 */
class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		
		try {
			return LocalDate.parse(json.getAsString());
		} catch(DateTimeParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
