package uk.co.codingcraft.armstrong.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Role implements GrantedAuthority {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Long id;

    @Column(name = "user_id")
	private Integer userId;

    @Column(name = "role", length=20)
	private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (this.role != null ? !this.role.equals(role.role) : role.role != null) return false;
        if (userId != null ? !userId.equals(role.userId) : role.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

	@Override
	public String getAuthority() {
		return role;
	}
}
