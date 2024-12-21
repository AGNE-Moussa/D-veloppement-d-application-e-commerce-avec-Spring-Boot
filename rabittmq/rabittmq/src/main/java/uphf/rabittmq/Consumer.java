package uphf.rabittmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "#{autoDeleteQueue.name}")
    public void receive(Client client) {
        System.out.println(" [x] Received '" + client + "'");
    }
}