package lv.xedbe.xedbe.repository;

import lv.xedbe.xedbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
