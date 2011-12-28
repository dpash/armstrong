package uk.co.codingcraft.armstrong.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "feeds")
public class Feed {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feed_id")
	private Long id;

    // The URL of the HTML version of the site
	@Column(name = "url", length = 100)
	private String url;

	@Column(name = "feed_name", length=255)
	private String feedName;

    @Column(name = "feed_url", length=255)
    private String feedUrl;

    @Column(name="last_modified")
    private Date lastModified;

    @Column(name="last_checked")
    private Date lastChecked;

    @Column(name="next_check")
    private Date nextCheck;

    @Column(name="check_interval")
    private Integer checkInterval;

    @Column(name="minimum_check_interval")
    private Integer minimumCheckInterval;

    @Column(name = "title", length=500)
    private String title;

    @Column(name="status")
    private Integer status;

    @Column(name = "status_message", length=200)
    private String statusMessage;

	public Collection<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Collection<Entry> entries) {
		this.entries = entries;
	}

	public Set<User> getSubscribedUsers() {
		return subscribedUsers;
	}

	public void setSubscribedUsers(Set<User> subscribedUsers) {
		this.subscribedUsers = subscribedUsers;
	}

	@OneToMany
	@JoinColumn(name = "feed")
	private Collection<Entry> entries;
	
    @ManyToMany
	@JoinTable(
			name = "subscriptions",
			joinColumns = {@JoinColumn(name = "feed_id", referencedColumnName = "feed_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
	)
	private Set<User> subscribedUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Date lastChecked) {
        this.lastChecked = lastChecked;
    }

    public Date getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(Date nextCheck) {
        this.nextCheck = nextCheck;
    }

    public Integer getCheckInterval() {
        return checkInterval;
    }

    public void setCheckInterval(Integer checkInterval) {
        this.checkInterval = checkInterval;
    }

    public Integer getMinimumCheckInterval() {
        return minimumCheckInterval;
    }

    public void setMinimumCheckInterval(Integer minimumCheckInterval) {
        this.minimumCheckInterval = minimumCheckInterval;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feed feed = (Feed) o;

        if (checkInterval != null ? !checkInterval.equals(feed.checkInterval) : feed.checkInterval != null)
            return false;
        if (feedName != null ? !feedName.equals(feed.feedName) : feed.feedName != null) return false;
        if (feedUrl != null ? !feedUrl.equals(feed.feedUrl) : feed.feedUrl != null) return false;
        if (id != null ? !id.equals(feed.id) : feed.id != null) return false;
        if (lastChecked != null ? !lastChecked.equals(feed.lastChecked) : feed.lastChecked != null) return false;
        if (lastModified != null ? !lastModified.equals(feed.lastModified) : feed.lastModified != null) return false;
        if (minimumCheckInterval != null ? !minimumCheckInterval.equals(feed.minimumCheckInterval) : feed.minimumCheckInterval != null)
            return false;
        if (nextCheck != null ? !nextCheck.equals(feed.nextCheck) : feed.nextCheck != null) return false;
        if (status != null ? !status.equals(feed.status) : feed.status != null) return false;
        if (statusMessage != null ? !statusMessage.equals(feed.statusMessage) : feed.statusMessage != null)
            return false;
        if (title != null ? !title.equals(feed.title) : feed.title != null) return false;
        if (url != null ? !url.equals(feed.url) : feed.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (feedName != null ? feedName.hashCode() : 0);
        result = 31 * result + (feedUrl != null ? feedUrl.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (lastChecked != null ? lastChecked.hashCode() : 0);
        result = 31 * result + (nextCheck != null ? nextCheck.hashCode() : 0);
        result = 31 * result + (checkInterval != null ? checkInterval.hashCode() : 0);
        result = 31 * result + (minimumCheckInterval != null ? minimumCheckInterval.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusMessage != null ? statusMessage.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return new ToStringBuilder(this).
				append("id", id).
				append("feedName", feedName).
				append("feedUrl", feedUrl).
				toString();
	}
}
