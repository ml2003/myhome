package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.HomeSpace;

import java.util.List;

@Repository
public interface HomespaceRepository  extends JpaRepository<HomeSpace, Long> {
    @Override
    List<HomeSpace> findAll();

}
