package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.DeviceType;

import java.util.List;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
    @Override
    List<DeviceType> findAll();
}
