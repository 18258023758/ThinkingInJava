package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/8
 */
public class Rabbit {
    private static final String exchangeName= "E_n";
    private static final   String   routingKey = "test";

    public void send(String message) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

       try(Connection connection = connectionFactory.newConnection();
           Channel channel = connection.createChannel()){

           channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT,true);



           channel.basicPublish(exchangeName,routingKey, null,message.getBytes());
       }
    }

    public void get() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel()){
            channel.exchangeDeclare(exchangeName,BuiltinExchangeType.DIRECT,true);
            String queue = channel.queueDeclare().getQueue();
            channel.queueBind(queue,exchangeName,routingKey);


        }
    }
}
