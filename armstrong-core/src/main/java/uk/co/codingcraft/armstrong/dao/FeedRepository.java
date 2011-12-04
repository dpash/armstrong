package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.repository.CrudRepository;
import uk.co.codingcraft.armstrong.model.Feed;

public interface FeedRepository extends CrudRepository<Feed,Long> {
}