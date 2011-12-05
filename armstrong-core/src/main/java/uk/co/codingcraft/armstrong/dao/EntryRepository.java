package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.codingcraft.armstrong.model.Entry;
import uk.co.codingcraft.armstrong.model.User;

import java.util.List;

public interface EntryRepository  extends CrudRepository<Entry,Long> {

    @Query("select e from Entry e inner join e.feed f inner join f.subscribedUsers u where u = :user")
    public List<Entry> findEntriesForUser(@Param("user") User user, Pageable page);

    @Query("select e from Entry e inner join e.feed f inner join f.subscribedUsers u where u = :user")
    public List<Entry> findUnreadEntries(User user, Pageable page);
}
