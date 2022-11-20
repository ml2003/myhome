package smart.myhome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.myhome.dto.DeviceDto;
import smart.myhome.model.Device;
import smart.myhome.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/devices",
        produces = "application/json")
@Tag(name = "Устройства", description = "mqtt устройства, отправляющие данные")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //  @GetMapping(params = "/all")
//  public ResponseEntity<List<DeviceDto>> getAllDevices() throws Exception {
//        return  deviceService.findAll();
//    }
    @GetMapping("/{id}")
    @Operation(summary = "Получение устройства по ИД", description = "Позволяет получить устройство по ИД")
    public DeviceDto getDevDtoById(@PathVariable @Parameter(description = "идентификатор устройства") long id) throws Exception {
        return deviceService.devToDto(id);
    }

//    @PostMapping(consumes="application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Device postDeviceDto (@RequestBody Device device){
//        return deviceService.save(device);
//    }

}
