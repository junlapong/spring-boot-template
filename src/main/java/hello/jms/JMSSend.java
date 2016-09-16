package hello.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class JMSSend {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired(required = false)
    private DestinationResolver destinationResolver;

    @Autowired
    JmsTemplate jmsTemplate;

    @Bean
    public DefaultJmsListenerContainerFactory myContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDestinationResolver(destinationResolver);
        factory.setConcurrency("3-10");
        return factory;
    }

    public void sendMsg(final String payload) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(payload);
            }
        };
        jmsTemplate.send("myQueue", messageCreator);
    }

}
