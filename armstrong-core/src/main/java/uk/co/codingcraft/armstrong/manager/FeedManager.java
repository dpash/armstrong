package uk.co.codingcraft.armstrong.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.dao.FeedRepository;
import uk.co.codingcraft.armstrong.model.Feed;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class FeedManager {

    @Autowired
	private FeedRepository repository;

	public Feed find(long id) {
		return repository.findOne(id);
	}

	public Set<Feed> findFeedsByUser(User user) {
		return repository.findFeedsByUser(user);
	}

	public List<Feed> findFeedsNeedingUpdating() {
		return repository.findAllFeedsByNextCheckLessThan(new Date());
	}

	public Feed save(Feed feed) {
		return repository.save(feed);
	}
}
