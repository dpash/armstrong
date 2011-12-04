package uk.co.codingcraft.armstrong.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.co.codingcraft.armstrong.model.Entry;
import uk.co.codingcraft.armstrong.model.Feed;

import java.util.List;

@Controller
@RequestMapping("/")
public class FeedController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("feeds");
		List<Feed> feeds;
		List<Entry> entries;

		mav.addObject("feeds", feeds);
		mav.addObject("entries", entries);

		return mav;
	}
}
