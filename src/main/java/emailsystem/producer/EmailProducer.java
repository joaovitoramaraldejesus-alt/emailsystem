package emailsystem.producer;

import emailsystem.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;


  public void enviarMensagem(String mensagem){

    rabbitTemplate.convertAndSend(

            RabbitMQConfig.EXCHANGE_EMAIL,
            RabbitMQConfig.ROUTING_KEY,
            mensagem

    );

    System.out.println(
            "Mensagem enviada para fila: "
                    + mensagem
    );

}

}