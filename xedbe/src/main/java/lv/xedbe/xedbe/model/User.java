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
}
