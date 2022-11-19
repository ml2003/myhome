package smart.myhome.config;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

@Configuration
public class MqttInConfig {


    @Bean
    IntegrationFlow inboundFlow(MqttPahoMessageDrivenChannelAdapter inboundAdapter) {
        return IntegrationFlows
                .from(inboundAdapter)
                .handle((GenericHandler<String>) (payload, headers) -> {
                    System.out.println("new message ! " + payload);
                    headers.forEach((k, v) -> System.out.println(k + "=" + v));
                    return null;
                })
                .get();
    }

    @Bean
    MqttPahoMessageDrivenChannelAdapter inboundAdapter(@Value("${mqtt.topic}") String topic,
                                                       MqttPahoClientFactory clientFactory) {
        return new MqttPahoMessageDrivenChannelAdapter("consumer", clientFactory, topic);
    }

}

