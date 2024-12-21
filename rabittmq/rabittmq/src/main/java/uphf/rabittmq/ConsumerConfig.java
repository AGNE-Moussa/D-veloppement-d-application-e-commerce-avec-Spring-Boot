package uphf.rabittmq;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.core.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    @Bean
    public Queue autoDeleteQueue() {
        return new AnonymousQueue();
    }
    @Bean
    public Binding binding(DirectExchange direct,
                           Queue autoDeleteQueue) {
        return BindingBuilder.bind(autoDeleteQueue)
                .to(direct)
                .with("key.1");
    }
}