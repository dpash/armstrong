package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.codingcraft.armstrong.model.Feed;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface FeedRepository extends CrudRepository<Feed,Long> {

    @Query("select f from Feed f")
    public Set<Feed> findFeedsByUser(@Param("user") User user);

	public List<Feed> findAllFeedsByNextCheckLessThan(Date date);
}