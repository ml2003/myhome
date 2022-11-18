package smart.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.myhome.model.DeviceParamLink;

import java.util.List;
@Repository
public interface DeviceParamLinkRepository  extends JpaRepository<DeviceParamLink, Long> {
    @Override
    List<DeviceParamLink> findAll();
}
