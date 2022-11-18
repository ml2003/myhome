package smart.myhome.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import smart.myhome.dto.HomespaceDto;
import smart.myhome.exceptions.HomespaceNotFoundException;
import smart.myhome.model.HomeSpace;
import smart.myhome.repository.HomespaceRepository;

import java.util.Optional;

@Data
@Service
public class HomespaceService {
    private final HomespaceRepository homespaceRepository;
    private final ModelMapper modelMapper;

        public HomespaceDto homeToDto(long id) throws HomespaceNotFoundException{
        Optional<HomeSpace> oHomespace = homespaceRepository.findById(id);
        if (oHomespace.isEmpty()) {
            throw new HomespaceNotFoundException();
        }
        return modelMapper.map(oHomespace.get(), HomespaceDto.class);
    }

}
