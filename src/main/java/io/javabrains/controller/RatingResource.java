package io.javabrains.controller;

import io.javabrains.model.Rating;
import io.javabrains.model.UserRating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by 38066 on 19.03.2019.
 */
@Slf4j
@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        log.info("INTO getRating() with ID: {}", movieId );
        return new Rating(movieId, 4);
    }

    @GetMapping("users/{userId}")
    public UserRating getRatingList(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setRatingList(Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        ));
        return userRating;
    }
}
