package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.repository.CrudRepository;
import uk.co.codingcraft.armstrong.model.Entry;

public interface EntryRepository  extends CrudRepository<Entry,Long> {
}
