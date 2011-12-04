package uk.co.codingcraft.armstrong.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.co.codingcraft.armstrong.dao.UserRepository;
import uk.co.codingcraft.armstrong.model.User;

@Service
public class UserManager implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserManager.class);

	@Autowired
	private UserRepository repository;

	public User getCurrentUser() {
		User currentUser;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			currentUser = (User)principal;
		} else {
			currentUser = repository.findByUsername(principal.toString());
		}
		return currentUser;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		logger.debug("loadUserByUsername({})", username);
		UserDetails user = repository.findByUsername(username);
		if (user == null) { throw new UsernameNotFoundException(username);}
		return user;
	}
}
