package uk.co.codingcraft.armstrong.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.co.codingcraft.armstrong.manager.EntryManager;
import uk.co.codingcraft.armstrong.manager.UserManager;
import uk.co.codingcraft.armstrong.model.Entry;
import uk.co.codingcraft.armstrong.model.Feed;
import uk.co.codingcraft.armstrong.model.User;

import java.util.*;

@Controller
@RequestMapping("/index.do")
@Transactional
public class FeedController {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private EntryManager entryManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		User user = userManager.getCurrentUser();
		ModelAndView mav = new ModelAndView("feeds");
		List<Feed> feeds = new ArrayList<Feed>(user.getSubscriptions());
				
		Collections.sort(feeds, new Comparator<Feed>() {
			@Override
			public int compare(Feed left, Feed right) {
				return left.getFeedName().compareTo(right.getFeedName());
			}
		});
		Collection<Entry> entries = entryManager.findUnreadEntries(user,
				new PageRequest(0, 50, new Sort(Sort.Direction.DESC, "modified")));

		mav.addObject("feeds", feeds);
		mav.addObject("entries", entries);
		mav.addObject("modified", new Date());

		return mav;
	}
}
