package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.Device;

import java.util.List;

@Repository
public interface DeviceRepository  extends JpaRepository<Device, Long> {
    @Override
    List<Device> findAll();
}
