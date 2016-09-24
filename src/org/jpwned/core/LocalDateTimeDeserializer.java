package org.jpwned.core;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
	
	@Override
	public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {		
		
		try {
			return ZonedDateTime.parse(json.getAsString()).toLocalDateTime();
		} catch(DateTimeParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
