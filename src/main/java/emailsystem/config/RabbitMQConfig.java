package emailsystem.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_EMAIL =
            "fila-email";

    public static final String EXCHANGE_EMAIL =
            "exchange-email";

    public static final String ROUTING_KEY =
            "email-routing-key";


    @Bean
    public Queue fila() {

        return new Queue(FILA_EMAIL, true);

    }

    @Bean
    public DirectExchange exchange() {

        return new DirectExchange(EXCHANGE_EMAIL);

    }

    @Bean
    public Binding binding(
            Queue fila,
            DirectExchange exchange
    ) {

        return BindingBuilder
                .bind(fila)
                .to(exchange)
                .with(ROUTING_KEY);

    }

}