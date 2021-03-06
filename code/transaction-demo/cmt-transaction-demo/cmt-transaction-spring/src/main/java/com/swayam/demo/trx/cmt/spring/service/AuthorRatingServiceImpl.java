package com.swayam.demo.trx.cmt.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swayam.demo.trx.cmt.spring.dao.AuthorDao;
import com.swayam.demo.trx.cmt.spring.dao.RatingDao;
import com.swayam.demo.trx.cmt.spring.entity.Author;
import com.swayam.demo.trx.cmt.spring.entity.Rating;
import com.swayam.demo.trx.cmt.spring.web.dto.AuthorRatingRequest;

@Service
public class AuthorRatingServiceImpl implements AuthorRatingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorRatingServiceImpl.class);

	private final RatingDao ratingDao;
	private final AuthorDao authorDao;

	public AuthorRatingServiceImpl(RatingDao ratingDao, AuthorDao authorDao) {
		this.ratingDao = ratingDao;
		this.authorDao = authorDao;
	}

	@Override
	public List<Rating> getRatings() {
		return ratingDao.getRatings();
	}

	@Transactional
	@Override
	public Map<String, Long> addAuthorRating(AuthorRatingRequest authorRatingRequest) {
		long ratingId = ratingDao.addRating(new Rating(null, authorRatingRequest.getUserName(),
				authorRatingRequest.getAuthorId(), authorRatingRequest.getRating()));

		LOGGER.info("saved ratingId: {}", ratingId);

		long authorId = authorDao.addAuthor(new Author(authorRatingRequest.getAuthorId(),
				authorRatingRequest.getAuthorFirstName(), authorRatingRequest.getAuthorLastName()));

		LOGGER.info("saved authorId: {}", authorId);

		Map<String, Long> map = new HashMap<>();
		map.put("ratingId", ratingId);
		map.put("authorId", authorId);
		return map;
	}

}
