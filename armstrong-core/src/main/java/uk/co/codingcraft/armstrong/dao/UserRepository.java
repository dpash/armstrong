package uk.co.codingcraft.armstrong.dao;

import org.springframework.data.repository.CrudRepository;
import uk.co.codingcraft.armstrong.model.User;

public interface UserRepository extends CrudRepository<User,Long> {

	public User findByUsername(String username);
}
