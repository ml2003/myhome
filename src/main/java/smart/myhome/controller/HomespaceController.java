package smart.myhome.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import smart.myhome.dto.HomespaceDto;
import smart.myhome.service.HomespaceService;

import java.util.List;

@RestController
@Data
@RequestMapping(path = "/api/homespace",
        produces = "application/json")
@Tag(name = "Комнаты", description = "Комнаты для устройств")
public class HomespaceController {
    private final HomespaceService homespaceService;


    @GetMapping("/all")
    @Tag(name = "Комнаты", description = "Получить все комнаты")
    public List<HomespaceDto> getHome() throws Exception {
        return homespaceService.returnAllHomespace();
    }


    @GetMapping("/{id}")
    @Tag(name = "Комнаты", description = "Получить комнату по ИД")
    public HomespaceDto getHomeById(@PathVariable Long id) throws Exception {
        return homespaceService.homeToDto(id);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @Tag(name = "Комнаты", description = "Создать новую комнату")
    @ResponseStatus(HttpStatus.CREATED)
    public HomespaceDto postHomespaceDto(@RequestBody HomespaceDto homespaceDto) throws Exception {
        return homespaceService.createHomespaceFromDto(homespaceDto);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    @Tag(name = "Комнаты", description = "Обновить комнату по ИД")
    public HomespaceDto putHomespace(
            @PathVariable("id") Long id,
            @RequestBody HomespaceDto homespaceDto) throws Exception {
        return homespaceService.putFromDto(homespaceDto);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json")
    @Tag(name = "Комнаты", description = "Удалить комнату по ИД")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHomespace(@PathVariable("id") Long id) {
        try {
            homespaceService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {

        }
    }


}
