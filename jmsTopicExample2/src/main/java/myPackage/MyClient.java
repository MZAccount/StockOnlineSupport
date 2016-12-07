package myPackage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyClient implements MessageListener {

	public boolean didsomething=false;
	
	public void onMessage(Message message) {
		//Message msg = replyConsumer_ClientConsumer.receive(5000);
        TextMessage replyMessage = (TextMessage)message;
        System.out.println("Received reply " + replyMessage.toString());
        try {
			System.out.println("Received answer: " + replyMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Action completed from MyClient instance.");
        didsomething=true;
	}

	
	
}
