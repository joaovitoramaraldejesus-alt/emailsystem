O sistema foi desenvolvido utilizando Java Spring Boot, PgAdmin e RabbitMQ. Os e-mails são cadastrados através de uma interface HTML simples e armazenados no banco de dados.

Quando o usuário solicita o envio em lote, a aplicação consulta os registros cadastrados e publica mensagens em uma Exchange do RabbitMQ utilizando uma Routing Key. As mensagens são encaminhadas para a fila configurada e consumidas por um Consumer, que processa as mensagens de forma assíncrona.

Principais Classes:

RabbitMQConfig: configuração da fila, exchange, routing key e binding.
EmailProducer: responsável por publicar mensagens no RabbitMQ.
EmailConsumer: responsável por consumir as mensagens da fila.
EmailController: disponibiliza os endpoints da aplicação.
EmailRepository: acesso aos dados armazenados no banco.
EmailEntity: entidade utilizada para persistência dos e-mails.

Tecnologias Utilizadas:

Java
Spring Boot
PgAdmin
RabbitMQ
HTML
