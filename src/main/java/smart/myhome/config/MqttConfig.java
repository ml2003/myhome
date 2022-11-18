package smart.myhome.config;

public class MqttConfig {
    protected final String broker = "192.168.1.1";
    protected final int qos = 1;
    protected Boolean hasSSL = false;
    protected Integer port = 1883;
    protected final String password = "admin";
    protected final String userName = "admin";
    protected final String TCP = "tcp://";
    protected final String SSL = "ssl://";
}
