package com.yiwen.playground.configuration;

import com.yiwen.playground.util.MappingUtility;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class WebConfig {

    @Bean
    public ModelMapper modelMapper(List<PropertyMap> propertyMapList) {
        ModelMapper modelMapper = new ModelMapper();

        propertyMapList.forEach(modelMapper::addMappings);
        return modelMapper;
    }
}
