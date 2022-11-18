package smart.myhome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import smart.myhome.dto.DeviceDto;
import smart.myhome.model.Device;
import smart.myhome.service.DeviceService;

@RestController
@Tag(name = "Устройства", description = "mqtt устройства, отправляющие данные")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

//    @GetMapping("/api/device/{id}")
//    public Device getDeviceById(@PathVariable long id) throws Exception {
//        return deviceService.findById(id);
//    }
    @GetMapping("/api/device/{id}")
    @Operation( summary = "Получение устройства по ИД", description = "Позволяет получить устройство по ИД")
    public DeviceDto getDevDtoById(@PathVariable @Parameter(description = "идентификатор устройства") long id) throws Exception {
        return deviceService.devToDto(id);
    }
}
