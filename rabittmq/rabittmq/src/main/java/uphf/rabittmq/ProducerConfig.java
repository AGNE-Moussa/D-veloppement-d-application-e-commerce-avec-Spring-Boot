package uphf.rabittmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("exchange.direct");
    }
}
