package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.UserSys;

import java.util.Optional;

@Repository
public interface UserSysRepository extends JpaRepository<UserSys, Long> {
    Optional<UserSys> findByEmail(String email);

    UserSys findByUsername(String username);
}
