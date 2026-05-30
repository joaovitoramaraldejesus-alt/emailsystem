package emailsystem.controller;

import emailsystem.entity.EmailEntity;
import emailsystem.producer.EmailProducer;
import emailsystem.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private EmailProducer producer;


    @PostMapping
    public EmailEntity salvar(
            @RequestBody EmailEntity email
    ) {

        EmailEntity emailSalvo =
                repository.save(email);

        producer.enviarMensagem(
                "Email enviado para: "
                        + email.getEmail()
        );

        return emailSalvo;

    }


    @GetMapping
    public List<EmailEntity> listar() {

        return repository.findAll();

    }


    @PostMapping("/enviar-lote")
    public String enviarLote() {

        List<EmailEntity> emails =
                repository.findAll();

        for (EmailEntity email : emails) {

            producer.enviarMensagem(

                    "Assunto: "
                            + email.getAssunto()
                            + " | Destinatário: "
                            + email.getEmail()

            );

        }

        return "Envio em lote solicitado com sucesso!";

    }

}