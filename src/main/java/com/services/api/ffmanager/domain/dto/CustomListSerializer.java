package com.services.api.ffmanager.domain.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.services.api.ffmanager.domain.entities.Complejos;

public class CustomListSerializer extends StdSerializer<List<Complejos>>{

	   public CustomListSerializer() {
	        this(null);
	    }

	    public CustomListSerializer(Class<List<Complejos>> t) {
	        super(t);
	    }

	    @Override
	    public void serialize(
	      List<Complejos> complejos, 
	      JsonGenerator generator, 
	      SerializerProvider provider) 
	      throws IOException, JsonProcessingException {
	        
	        List<Integer> ids = new ArrayList<>();
	        for (Complejos c : complejos) {
	            ids.add(c.getIdComplejo());
	        }
	        generator.writeObject(ids);
	    }

		
	}