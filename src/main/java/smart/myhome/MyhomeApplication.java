package smart.myhome;


import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;


@SpringBootApplication
public class MyhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyhomeApplication.class, args);
    }

    @Bean
    MqttPahoClientFactory clientFactory(@Value("${mqtt.hostname}") String host) {
        var factory = new DefaultMqttPahoClientFactory();
        var options = new MqttConnectOptions();
        options.setServerURIs(new String[]{host});
        options.setUserName("test");
        options.setPassword( "test".toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }
}

@Configuration
class OutConfiguration {

    @Bean
    RouterFunction<ServerResponse> http(MessageChannel out) {
        return route()
                .GET("send/{name}", request -> {

                    var name = request.pathVariable("name");
                    var message = MessageBuilder.withPayload("отправлено с mqtt" + name).build();
                    out.send(message);
                    return ServerResponse.ok().build();
                })
                .build();
    }

    @Bean
    MqttPahoMessageHandler outboundAdapter(
            @Value("${mqtt.topic}") String topic,
            MqttPahoClientFactory factory) {
        var mh = new MqttPahoMessageHandler("producer", factory);
        mh.setDefaultTopic(topic);
        return mh;
    }

    @Bean
    IntegrationFlow outboundFlow(MessageChannel out,
                                 MqttPahoMessageHandler outboundAdapter) {
        return IntegrationFlows
                .from(out)
                .handle(outboundAdapter)
                .get();
    }


    @Bean
    MessageChannel out() {
        return MessageChannels.direct().get();
    }

}

@Configuration
class InConfiguration {

    @Bean
    IntegrationFlowBuilder inboundFlow (MqttPahoMessageDrivenChannelAdapter inboundAdapter) {
        return IntegrationFlows
                .from (inboundAdapter)
                .handle((GenericHandler<String>) (payload, headers) -> {
                    System.out.println("new message ! " + payload);
                    headers.forEach((k, v) -> System.out.println(k + "=" + v));
                    return null;
                });
    }

    @Bean
    MqttPahoMessageDrivenChannelAdapter inboundAdapter (@Value("${mqtt.topic}") String topic,
                                                        MqttPahoClientFactory clientFactory) {
        return new MqttPahoMessageDrivenChannelAdapter("consumer", clientFactory, topic);
    }

}




