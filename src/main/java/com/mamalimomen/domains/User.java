package com.mamalimomen.domains;

import com.mamalimomen.base.controllers.utilities.InValidDataException;
import com.mamalimomen.base.controllers.utilities.SecurityManager;
import com.mamalimomen.base.domains.BaseEntity;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SelectBeforeUpdate
@Table(name = "tbl_user")
@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = "User.findOneByUsername",
                query = "SELECT u FROM User u WHERE u.username = ?1")
})
public class User extends BaseEntity implements Comparable<User> {

    @Transient
    private static Long usersCount = 1L;

    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
        setId((long) Objects.hash(usersCount));
        usersCount++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InValidDataException {
        if (!username.matches("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$")) {
            throw new InValidDataException("Username");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InValidDataException {
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")) {
            throw new InValidDataException("Password");
        }
        this.password = SecurityManager.getPasswordHash(password);
    }

    @Override
    public String toString() {
        return String.format("%d<br/>%s", getId(), getUsername());
    }

    @Override
    public int compareTo(User u) {
        return this.getId().compareTo(u.getId());
    }
}
