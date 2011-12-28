package uk.co.codingcraft.armstrong.spider;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uk.co.codingcraft.armstrong.manager.FeedManager;
import uk.co.codingcraft.armstrong.model.Feed;

import javax.jms.*;
import java.util.Collection;

@Component
public class Queuer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Destination destination;
	
	private static final Logger logger = LoggerFactory.getLogger(Queuer.class);
	
	@Autowired
	private FeedManager feedManager;
	
	@Scheduled(fixedRate = 60000) // Every 60 seconds
	public void run() {
		logger.info("Queuing spidering");
		Collection<Feed> feeds = feedManager.findFeedsNeedingUpdating();
		for (final Feed feed: feeds) {
			logger.debug("scheduling {}", feed);
			jmsTemplate.send(destination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					Message message = session.createMessage();
					message.setLongProperty("feed", feed.getId());
					return message;
				}
			});
		}
		
		logger.info("queued {} feeds", feeds.size());
	}
}
