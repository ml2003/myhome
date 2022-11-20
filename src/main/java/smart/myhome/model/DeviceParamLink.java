package smart.myhome.model;


import javax.persistence.*;

@Entity
@Table(name = "device_param_link")
public class DeviceParamLink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "param_id")
    private Param param;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private MqttTopic mqttTopic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }

    public MqttTopic getMqttTopic() {
        return mqttTopic;
    }

    public void setMqttTopic(MqttTopic mqttTopic) {
        this.mqttTopic = mqttTopic;
    }
}