package uk.co.codingcraft.armstrong.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.dao.EntryRepository;
import uk.co.codingcraft.armstrong.dao.FeedRepository;
import uk.co.codingcraft.armstrong.model.Feed;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Collections;
import java.util.Set;

@Service
public class FeedManager {

    @Autowired
	private FeedRepository repository;


	public Set<Feed> findFeedsByUser(User user) {
		return repository.findFeedsByUser(user);
	}
}
