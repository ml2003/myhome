package smart.myhome.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceDto implements Serializable {
    private static final long serialVersionUID = -1826984753959217581L;

    private Long id;
    private String nameDevice;


}
