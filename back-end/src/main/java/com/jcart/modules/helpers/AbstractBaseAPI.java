package com.jcart.modules.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.jcart.modules.exceptions.ApplicationException;
import com.jcart.modules.helpers.util.Constant;

import java.text.SimpleDateFormat;

public class AbstractBaseAPI  {

    // Mapper object is used to convert object and etc...
    public final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
                .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                .setDateFormat(new SimpleDateFormat(Constant.API_FORMAT_DATE));
    }

    protected String writeObjectToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            throw new ApplicationException(ex.getCause());
        }
    }
}
