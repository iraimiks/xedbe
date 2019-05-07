package lv.xedbe.xedbe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@Entity
public class User {
    private @Id @GeneratedValue Long id;
    @Email
    private String email;
    private String nickname;
    private String password;
    private UserRole userRole;

    public User() {
    }

    /**
     *
     * @param email
     * @param nickname
     * @param password
     * Creating first user it allays need to be SIMUSER.
     */
    public User(@Email String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userRole = UserRole.SIMPUSER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
