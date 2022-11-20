package smart.myhome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import smart.myhome.dto.DeviceDto;
import smart.myhome.dto.ParamDto;
import smart.myhome.service.ParamService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/params",
        produces = "application/json")
@Tag(name = "Параметры", description = "Параметры с данными")
public class ParamController {

    private ParamService paramService;

   @GetMapping("/all")
   @Operation(summary = "Получение всех параметров", description = "Позволяет получить все параметры")
   public List<ParamDto> getAllParam () throws Exception {
      return paramService.getALLParams();
   }

    @GetMapping("/{id}")
    @Operation(summary = "Получение параметра по ИД", description = "Позволяет получить параметр по ИД")
    public ParamDto getParamDtoById (@PathVariable @Parameter(description = "идентификатор параметра") long id)  throws Exception {
        return paramService.paramToDto(id);
    }


    @GetMapping("/last/{id}")
    @Operation(summary = "Получение последнего значения параметра по ИД", description = "Позволяет получить последнее значение параметра по ИД")
    public ParamDto getLastParamDtoById (@PathVariable @Parameter(description = "идентификатор параметра") long id)  throws Exception {
        return paramService.paramToDto(id);
    }

//@PostMapping("/add")
//@Operation(summary = "Создать параметр", description = "Позволяет добавить новый параметр")
//public
}
