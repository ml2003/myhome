package smart.myhome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.myhome.dto.DeviceDto;
import smart.myhome.dto.HomespaceDto;
import smart.myhome.model.Device;
import smart.myhome.service.DeviceService;

import java.util.List;

@RestController
@Data
@RequestMapping(path = "/api/devices",
        produces = "application/json")
@Tag(name = "Устройства", description = "mqtt устройства, отправляющие данные")
public class DeviceController {

    private final DeviceService deviceService;


    @GetMapping("/all")
    @Tag(name = "Устройства", description = "Получить все устройства")
    public List<DeviceDto> getHome() throws Exception {
        return deviceService.returnAllDevice();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение устройства по ИД", description = "Позволяет получить устройство по ИД")
    public DeviceDto getDevDtoById(@PathVariable @Parameter(description = "идентификатор устройства") long id) throws Exception {
        return deviceService.devToDto(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceDto postDeviceDto(@RequestBody DeviceDto deviceDto) throws Exception {
        return deviceService.createDeviceFromDto(deviceDto);
    }

    @DeleteMapping(path = "/{id}")
    @Tag(name = "Устройства", description = "Удалить устройство по ИД")
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        try {
            deviceService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    @Tag(name = "Устройства", description = "Обновить устройство по ИД")
    public DeviceDto putDevice(
            @PathVariable("id") Long id,
            @RequestBody DeviceDto deviceDto) throws Exception {
        return deviceService.putFromDto(deviceDto);
    }


}
