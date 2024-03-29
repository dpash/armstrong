package uk.co.codingcraft.armstrong.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.dao.EntryRepository;
import uk.co.codingcraft.armstrong.model.Entry;
import uk.co.codingcraft.armstrong.model.User;

import java.util.Collection;

@Service
public class EntryManager {

	@Autowired
	private EntryRepository repository;

    public Collection<Entry> findEntriesForUser(User user, Pageable page) {
        return repository.findEntriesForUser(user, page);
    }

	public Collection<Entry> findUnreadEntries(User user, Pageable page) {
		return repository.findUnreadEntries(user,page);
	}

}
