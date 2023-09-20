# :envelope: Producer / Consumer - Mensageria
O projeto em questão teve como intuito ampliar os conceitos a respeito da comunicação assíncrona entre microsserviços por meio de um message broker. Nesse caso,o message broker escolhido foi o RabbitMQ.

A ideia era desenvolver uma ideia simples no qual haveria um producer (responsável por enviar a mensagem) e um consumer (responsável por receber e processar a mensagem), de forma com que a mensagem após enviada e recebida fosse salva pelo consumer em um banco de dados.

## :hammer: Ferramentas utilizadas
- Java 17
- Spring Web
- Spring Data JPA
- Spring Web
- Spring for RabbitMQ
- MySQL
- Flyway
- Lombok
- Model Mapper
## :computer: Funcionalidades 
Quanto a parte de funcionalidades, o producer fica responsável por enviar uma mensagem por meio de uma requisição do tipo ``` POST ```, onde no corpo da requisição deve conter o nome do cliente e o valor do pedido.

Ex: ``` http://localhost:8081/order-producer - POST ``` 
```
{
    "customerName": "Customer 01",
    "price": 50.0
}
```
O customer então consome a mensagem que foi enviada para o RabbitMQ e após a leitura,salva a informação em seu banco de dados.Para consultarmos os pedidos realizados, basta fazermos ums requisição do tipo ``` GET ```.

Ex: ``` http://localhost:8080/order-consumer - GET ```
```
{
    "id": 1,
    "customerName": "Customer 01",
    "price": 50.0
}
```
## :ballot_box_with_check: Conclusão
Por meio desse estudo foi possível aprender um pouco mais sobre os conceitos de mensageria e como sua aplicação se faz necessária dentro da arquitetura de microsserviços. Além de aprender sobre conceitos fundamentais como: eventos, filas, exchanges e etc.


