package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
