package ru.test.homework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
public class OmdbController {


    private String apiKey = "266b43cd";

    private final String apiUrl = "https://www.omdbapi.com";

    @GetMapping("/omdbSearch")
    public Map<String, Object> searchMovies(
            @RequestParam String title,
            @RequestParam(defaultValue = "20") int viewSize,
            @RequestParam(defaultValue = "1") int page
    ) {
        RestTemplate restTemplate = new RestTemplate();


        String fullUrl = apiUrl + "?s=" + title + "&apiKey=" + apiKey + "&page=" + page;


        Map<String, Object> response = restTemplate.getForObject(fullUrl, Map.class);

        int totalResults =  Integer.parseInt(response.get("totalResults").toString());
        int pages = (int) Math.ceil((double) totalResults / viewSize);
        int start = (page - 1) * viewSize + 1;
        int end = Math.min(page * viewSize, totalResults);


        Map<String, Object> customResponse = new HashMap<>();
        customResponse.put("Search", response.get("Search"));
        customResponse.put("totalResults", totalResults);
        customResponse.put("SearchRange", start + " - " + end + " movie ");
        customResponse.put("currentPage", page);
        customResponse.put("viewSize", viewSize);
        customResponse.put("pages", pages);
        customResponse.put("owner", "Max");
        customResponse.put("group", 411);

        return customResponse;
    }
}
