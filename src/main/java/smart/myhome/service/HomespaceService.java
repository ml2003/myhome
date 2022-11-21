package smart.myhome.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import smart.myhome.dto.DeviceDto;
import smart.myhome.dto.HomespaceDto;
import smart.myhome.exceptions.DeviceNotFoundException;
import smart.myhome.exceptions.HomespaceNotFoundException;
import smart.myhome.model.Device;
import smart.myhome.model.HomeSpace;
import smart.myhome.repository.HomespaceRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class HomespaceService {
    private final HomespaceRepository homespaceRepository;
    private final ModelMapper modelMapper;


    public List<HomespaceDto> returnAllHomespace() throws Exception {
        List<HomeSpace> all =  homespaceRepository.findAll();

        List<HomespaceDto> allDtos = modelMapper.map(all, new TypeToken<List<HomespaceDto>>(){}.getType());
//        for (HomeSpace home: all
//             ) {
//            allDtos.add(modelMapper.map(home, HomespaceDto.class));
//        }
        return allDtos;
    }

        public HomespaceDto homeToDto(long id) throws HomespaceNotFoundException{
        Optional<HomeSpace> oHomespace = homespaceRepository.findById(id);
        if (oHomespace.isEmpty()) {
            throw new HomespaceNotFoundException();
        }
        return modelMapper.map(oHomespace.get(), HomespaceDto.class);
    }

    public HomespaceDto createHomespaceFromDto (HomespaceDto dto) throws Exception{
       HomeSpace homeSpace = convertToEntity(dto);
        homespaceRepository.save(homeSpace);
        HomespaceDto returnedDto = homeToDto(homeSpace.getId());
        if (returnedDto == null) {
            throw new DeviceNotFoundException();
        }
        return returnedDto;
    }

    private HomeSpace convertToEntity (HomespaceDto homespaceDto) throws Exception {
        try {
            HomeSpace homeSpace= modelMapper.map(homespaceDto, HomeSpace.class);
            return homeSpace;
        } catch (Exception e) {
            throw new DeviceNotFoundException();
        }

    }

    public HomespaceDto putFromDto(HomespaceDto homespaceDto) throws  Exception{
        HomeSpace homeSpace= modelMapper.map(homespaceDto, HomeSpace.class);
        HomeSpace editHomespace = homespaceRepository.findById(homeSpace.getId()).get();
        editHomespace.setNameHomespace(homeSpace.getNameHomespace());
        editHomespace.setDevicespace(homeSpace.getDevicespace());
        editHomespace.setUserSys(homeSpace.getUserSys());
        homespaceRepository.save(editHomespace);
        HomespaceDto returnedDto = homeToDto(homeSpace.getId());
        if (returnedDto == null) {
            throw new DeviceNotFoundException();
        }
            return returnedDto;
    }

    public void deleteById(Long homespaceDto){
            homespaceRepository.deleteById(modelMapper.map(homespaceDto, HomeSpace.class).getId());
                }

}
