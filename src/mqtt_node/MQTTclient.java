package mqtt_node;

import java.util.ArrayList;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class MQTTclient implements MqttCallback {
	private ArrayList<Node> arrayTopic = new ArrayList<Node>();
	
private String message;
MqttClient client;
public MQTTclient(String topic) {
    try {
        client = new MqttClient("tcp://localhost:1883", topic);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        System.out.println("Connecting to broker...");
        client.connect(connOpts);
        
        System.out.println("Connected");
        client.setCallback(this);
        client.subscribe(topic);
        
    } catch (MqttException e) {
        e.printStackTrace();
    }
}
@Override
public void connectionLost(Throwable cause) {
}

public void messageArrived(String topic, MqttMessage message)
        throws Exception {
		this.message = message.toString();
		//DBpost.post(message.toString(), topic);	
		PostOffice.sort(arrayTopic, message.toString(), topic);
		//System.out.println(topic +" " +message.toString());
		
}

@Override
public void deliveryComplete(IMqttDeliveryToken token) {
}
public String getNode(String name){
	String message = PostOffice.deliver(arrayTopic, name);
	return message;
}
//Make new topic object and add to list
public void addTopic(String topic, String name){
	new Node(topic,name, arrayTopic);
}
public ArrayList<Node> getArrayTopic() {
	return arrayTopic;
}

public void publish(String topic, String message2) throws MqttPersistenceException, MqttException{
	String content = message2;
	MqttMessage message3 = new MqttMessage(content.getBytes());
	client.publish(topic, message3);
	//client.publish(topic, );

}}
