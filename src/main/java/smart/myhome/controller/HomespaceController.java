package smart.myhome.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import smart.myhome.dto.HomespaceDto;
import smart.myhome.service.HomespaceService;

@RestController
@Data
public class HomespaceController {
    private HomespaceService homespaceService;

    @GetMapping("/api/homespace/{id}")
    public HomespaceDto getHomeById(@PathVariable long id) throws Exception {
        return homespaceService.homeToDto(id);
    }

}
