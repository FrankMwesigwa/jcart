package com.jcart.modules.helpers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class JsonHelper {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T fileToObject(String filePath, final Class clazz) {
        try {
            final InputStream content = getClass().getClassLoader().getResourceAsStream(filePath);
            return (T) getObjectMapper().readValue(content, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T StringToObject(String content, final Class clazz) {
        try {
            return (T) getObjectMapper().readValue(content, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String objectToString(final Object obj) {
        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectMapper getObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
