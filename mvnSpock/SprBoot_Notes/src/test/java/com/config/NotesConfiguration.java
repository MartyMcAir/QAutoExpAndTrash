package com.config;

import com.services.NotesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com"})
public class NotesConfiguration {

    @Bean
    public NotesService notesService() {
        return new NotesService();
    }

}