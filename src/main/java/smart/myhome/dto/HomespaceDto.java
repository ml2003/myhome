package smart.myhome.dto;

import lombok.Data;
import smart.myhome.model.Device;

import java.io.Serializable;
import java.util.List;

@Data
public class HomespaceDto implements Serializable {
    private static final long serialVersionUID = -1826984753959217525L;

    private Long id;
    private String nameHomespace;
    private List<DeviceDto> devicespace;

}
