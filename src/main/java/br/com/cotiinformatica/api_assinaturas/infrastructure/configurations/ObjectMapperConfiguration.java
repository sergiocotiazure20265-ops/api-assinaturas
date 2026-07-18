package br.com.cotiinformatica.api_assinaturas.infrastructure.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        // Suporte para LocalDate, LocalTime e LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());

        // Evita que datas sejam serializadas como arrays ou timestamps
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Formato para tipos antigos como java.util.Date
        objectMapper.setDateFormat(
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        );

        return objectMapper;
    }
}