package smart.myhome.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "datadevice")
public class DataDevice implements Serializable {
    private static final long serialVersionUID = -1826984753958217525L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paramlink")
    private DeviceParamLink deviceParamLink;


    @Column(name = "md5stamp")
    private String md5stamp;

    @Column(name = "cortime")
    private LocalDateTime cortime;

    @Column(name = "curtime")
    private LocalDateTime curtime;

    @Column(name = "topic")
    private String topic;

    @Column(name = "value")
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMd5stamp() {
        return md5stamp;
    }

    public void setMd5stamp(String md5stamp) {
        this.md5stamp = md5stamp;
    }

    public LocalDateTime getCortime() {
        return cortime;
    }

    public void setCortime(LocalDateTime cortime) {
        this.cortime = cortime;
    }

    public LocalDateTime getCurtime() {
        return curtime;
    }

    public void setCurtime(LocalDateTime curtime) {
        this.curtime = curtime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public DeviceParamLink getDeviceParamLink() {
        return deviceParamLink;
    }

    public void setDeviceParamLink(DeviceParamLink deviceParamLink) {
        this.deviceParamLink = deviceParamLink;
    }
}
