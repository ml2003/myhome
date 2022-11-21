package smart.myhome.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import smart.myhome.dto.DeviceDto;
import smart.myhome.dto.ParamDto;
import smart.myhome.exceptions.ParamNotFoundException;
import smart.myhome.model.Device;
import smart.myhome.model.Param;
import smart.myhome.repository.ParamRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ParamService {

    private final ParamRepository paramRepository;
    private final ModelMapper modelMapper;


    public ParamDto paramToDto(long id) throws ParamNotFoundException {
        Optional<Param> oParam = paramRepository.findById(id);
        if (oParam.isEmpty()){
            throw new ParamNotFoundException();
        }
        return modelMapper.map(oParam.get(), ParamDto.class);
    }

    public List<ParamDto> getALLParams () throws Exception {
         List<Param> all =  paramRepository.findAll();
         List<ParamDto> allDtos = modelMapper.map(all, new TypeToken<List<ParamDto>>(){}.getType());
         return allDtos;
        }

}
