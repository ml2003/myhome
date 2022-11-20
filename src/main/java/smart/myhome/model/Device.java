package smart.myhome.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device")
public class Device    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_dev")
    private String nameDevice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id")
    private HomeSpace homeSpace;

    @Override
    public String toString() {
        return "Device{"+"id=" + id +"name:" + nameDevice + "}";
    }


    public HomeSpace getSpace() {
        return homeSpace;
    }

    public void setSpace(HomeSpace homeSpace) {
        this.homeSpace = homeSpace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String devname) {
        this.nameDevice = devname;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }



}
