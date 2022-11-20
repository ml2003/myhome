package smart.myhome.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import smart.myhome.dto.ParamDto;
import smart.myhome.exceptions.ParamNotFoundException;
import smart.myhome.model.Param;
import smart.myhome.repository.ParamRepository;

import java.util.List;
import java.util.Optional;

@Data
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

    public List<ParamDto> getALLParams (){
        return null;
    }

}
