package com.ms.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	/*
	 * @Autowired private RatingService ratingService;
	 * 
	 * @Test void testCreateRating() { Rating
	 * rating=Rating.builder().userId("").hotelId("").rating(4).
	 * feedback("This is created by Feign Client .").build(); ResponseEntity<Rating>
	 * createdRating = ratingService.createRating(rating);
	 * System.out.println(createdRating); }
	 */
}
