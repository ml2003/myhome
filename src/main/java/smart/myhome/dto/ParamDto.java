package smart.myhome.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParamDto implements Serializable {

    private static final long serialVersionUID = -1736984753959217581L;

    private Long id;
    private String name;

}
