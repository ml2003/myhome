package smart.myhome.config;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    MqttPahoClientFactory clientFactory(@Value("${mqtt.hostname}") String host) {
        var factory = new DefaultMqttPahoClientFactory();
        var options = new MqttConnectOptions();
        options.setServerURIs(new String[]{host});
        options.setUserName("test");
        options.setPassword("test".toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }

}
