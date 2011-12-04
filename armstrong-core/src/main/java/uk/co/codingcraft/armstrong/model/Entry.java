package uk.co.codingcraft.armstrong.model;

import org.apache.commons.lang.builder.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entries")
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "entry_id")
	private Long id;

	@ManyToOne
    @JoinColumn(name="feed", nullable=false)
	private Feed feed;
	
	@Column(name = "author_email", length = 1000)
	private String authorEmail;

	@Column(name = "author_name", length = 1000)
	private String authorName;

	@Column(name = "author_url", length = 1000)
	private String authorUrl;

	@Column(name = "content")
	private String content;
	
	@Column(name = "created")
	private Date created;


	@Column(name = "guid", length = 1000)
	private String guid;

	@Column(name = "issued")
	private Date issued;

	@Column(name = "link", length = 1000)
	private String link;

	@Column(name = "modified")
	private Date modified;

	@Column(name = "title", length = 1000)
	private String title;

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorUrl() {
		return authorUrl;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getIssued() {
		return issued;
	}

	public void setIssued(Date issued) {
		this.issued = issued;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Entry)) return false;

		Entry entry = (Entry) o;

		return !(guid != null ? !guid.equals(entry.guid) : entry.guid != null);

	}

	@Override
	public int hashCode() {
		return guid != null ? guid.hashCode() : 0;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).
				append("authorEmail", authorEmail).
				append("id", id).
				append("feed", feed).
				append("authorName", authorName).
				append("authorUrl", authorUrl).
				append("content", content).
				append("created", created).
				append("guid", guid).
				append("issued", issued).
				append("link", link).
				append("modified", modified).
				append("title", title).
				toString();
	}
}
