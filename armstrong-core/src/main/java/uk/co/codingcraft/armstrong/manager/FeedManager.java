package uk.co.codingcraft.armstrong.manager;

import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.model.Feed;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Collections;
import java.util.Set;

@Service
public class FeedManager {

	public Set<Feed> findFeedsByUser(User user) {
		return Collections.emptySet();
	}
}
