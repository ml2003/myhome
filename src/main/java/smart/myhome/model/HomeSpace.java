package smart.myhome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="homespace")
public class HomeSpace  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "homename_space")
    private String nameHomespace;

    @OneToMany(mappedBy = "homeSpace", fetch = FetchType.LAZY)
    private List<Device> devicespace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="usersys_id")
    private UserSys userSys;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHomespace() {
        return nameHomespace;
    }

    public void setNameHomespace(String nameSpace) {
        this.nameHomespace = nameSpace;
    }

    public List<Device> getDevicespace() {
        return devicespace;
    }

    public void setDevicespace(List<Device> devicespace) {
        this.devicespace = devicespace;
    }

    public UserSys getUserSys() {
        return userSys;
    }

    public void setUserSys(UserSys userSys) {
        this.userSys = userSys;
    }
}
