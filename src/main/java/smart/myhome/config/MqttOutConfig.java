package smart.myhome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class MqttOutConfig {


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

