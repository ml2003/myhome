package smart.myhome.model;


import javax.persistence.*;

@Entity
@Table(name = "device_param_link")
public class DeviceParamLink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}