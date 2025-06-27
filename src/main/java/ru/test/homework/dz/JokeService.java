package ru.test.homework.dz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
class JokeService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String categoryUrl;

    private final List<String> jokeCategories;

    public JokeService(RestTemplate restTemplate,
                       @Value("${joke.api.url}") String apiUrl,
                       @Value("${joke.api.category.url}") String categoryUrl, List<String> jokeCategories) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.categoryUrl = categoryUrl;
        this.jokeCategories = jokeCategories;
    }

    public void printRandomJoke() {
        Joke joke = restTemplate.getForObject(apiUrl, Joke.class);
        if (joke != null) {
            System.out.println("Random Joke: " + joke.getValue());
        } else {
            System.out.println("Failed to fetch a random joke.");
        }
    }

    public void printProgrammingJokes() {
        String fullCategoryUrl = categoryUrl + jokeCategories.get(0); // Getting programming Jokes
        Joke[] jokes = restTemplate.getForObject(fullCategoryUrl, Joke[].class);
        if (jokes != null && jokes.length > 0) {
            System.out.println("Programming Jokes: ");
            for (Joke joke : jokes) {
                System.out.println("- " + joke.getValue());
            }
        } else {
            System.out.println("Failed to fetch programming jokes.");
        }
    }
}
