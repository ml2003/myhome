package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.Param;

import java.util.List;

@Repository
public interface ParamRepository extends JpaRepository<Param, Long> {
    @Override
    List<Param> findAll();
}
