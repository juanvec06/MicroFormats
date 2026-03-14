package edu.co.unicauca.microformatos.FacadeServicesLayer.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean 
    public ModelMapper crearMapper() {
        ModelMapper objMapper = new ModelMapper();
        objMapper.getConfiguration()
                 .setFieldMatchingEnabled(true)
                 .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return objMapper;
    }
}

