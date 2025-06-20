package ru.test.homework.dz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
class AppConfiguration {

    @Bean
    public List<String> jokeCategories() {
        return Arrays.asList("Programming", "Christmas", "Spooky");
    }
}