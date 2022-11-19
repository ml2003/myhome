package smart.myhome.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import smart.myhome.dto.DeviceDto;
import smart.myhome.exceptions.DeviceNotFoundException;
import smart.myhome.model.Device;
import smart.myhome.repository.DeviceRepository;

import java.util.Optional;

@Data
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;


    public Device findById(long id) throws DeviceNotFoundException {
        Optional<Device> oDevice = deviceRepository.findById(id);
        if (oDevice.isEmpty()){
            throw new DeviceNotFoundException();
        }
         return oDevice.get();
    }

    public DeviceDto devToDto(long id) throws DeviceNotFoundException  {
        Optional<Device> oDevice = deviceRepository.findById(id);
        if (oDevice.isEmpty()){
            throw new DeviceNotFoundException();
        }
       return modelMapper.map(oDevice.get(), DeviceDto.class);
    }
}
