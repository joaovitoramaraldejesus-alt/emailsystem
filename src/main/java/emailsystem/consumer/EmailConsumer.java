package emailsystem.consumer;

import emailsystem.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(
            queues = RabbitMQConfig.FILA_EMAIL
    )
    public void consumirMensagem(String mensagem) {

        System.out.println("=================================");
        System.out.println("PROCESSANDO EMAIL...");
        System.out.println(mensagem);
        System.out.println("EMAIL ENVIADO COM SUCESSO!");
        System.out.println("=================================");

    }

}