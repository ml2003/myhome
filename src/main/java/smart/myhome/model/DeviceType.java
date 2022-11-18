package smart.myhome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device_type")
public class DeviceType implements Serializable {
    private static final long serialVersionUID = -1826984753959217595L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_type")
    private String nameType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

}
