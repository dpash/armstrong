package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uk.co.codingcraft.armstrong.model.Entry;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Set;

public interface EntryRepository  extends CrudRepository<Entry,Long> {

    @Query("select e from Entry e inner join e.feed where f.subscribedUsers.user = :user")
    public Set<Entry> findEntriesForUser(User user, Pageable page);

    @Query("select e from Entry e inner join e.feed where f.subscribedUsers.user = :user")
    public Set<Entry> findUnreadEntries(User user, Pageable page);
}
