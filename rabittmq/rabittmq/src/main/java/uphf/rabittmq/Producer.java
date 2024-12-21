package uphf.rabittmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private DirectExchange direct;
    @Scheduled(fixedDelay = 5000)
    public void send() {
        Client client = new Client("Moussa");
        template.convertAndSend(direct.getName(), "key.1", client);
    }
}