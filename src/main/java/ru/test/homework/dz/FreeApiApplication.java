package ru.test.homework.dz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class FreeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(JokeService jokeService) {
        return args -> {
            jokeService.printRandomJoke();
            jokeService.printProgrammingJokes();
        };
    }
}
