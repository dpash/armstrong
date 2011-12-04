package uk.co.codingcraft.armstrong.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.dao.EntryRepository;

@Service
public class EntryManager {

	@Autowired
	private EntryRepository repository;


}
