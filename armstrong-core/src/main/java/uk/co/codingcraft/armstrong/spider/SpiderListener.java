package uk.co.codingcraft.armstrong.spider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.codingcraft.armstrong.manager.FeedManager;
import uk.co.codingcraft.armstrong.model.Feed;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpiderListener implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(SpiderListener.class);

	static final private DateFormat httpDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
	
	@Autowired
	private FeedManager feedManager;
	
	@Override
	public void onMessage(Message message) {
		
		try {
			logger.debug("processing message: {}", message.getJMSMessageID());
			logger.debug("message: {}", message);
			Feed feed = feedManager.find(message.getLongProperty("feed"));

			logger.info("fetching {}", feed);
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(feed.getFeedUrl());
			String last_modified = httpDateFormat.format(feed.getLastModified());
			httpget.addHeader("If-Modified-Since",last_modified);

			HttpResponse response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_MODIFIED) {
				logger.debug("Not modified: {}", response.getStatusLine());
			} else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.warn("Method failed: " + response.getStatusLine());
			} else {
				String contentType = response.getFirstHeader("content-type").getValue().replaceAll(";.*$", "");
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instream = entity.getContent();
					int l;
					byte[] tmp = new byte[2048];
					while ((l = instream.read(tmp)) != -1) {
					}
				}
			}
			Date now = new Date();
      		now.setTime(now.getTime() + 3600000); // Check again in an hour
			feed.setNextCheck(now);
			feedManager.save(feed);

		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}

	}
}
