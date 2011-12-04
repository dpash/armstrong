package uk.co.codingcraft.armstrong.model;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "host_id")
	private Long id;

	@Column(name = "server_name", length = 200)
	private String serverName;

	@Column(name = "server_port")
	private Integer serverPort;

}
