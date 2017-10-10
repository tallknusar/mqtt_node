package mqtt_node;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Main {
public static ArrayList<Node> list;
	public static void main(String[] args) throws MqttPersistenceException, MqttException {
		
		//MQTTclient client = 
		MQTTclient client = new MQTTclient("base/#");
		client.addTopic("base/temp/","temp");
		client.addTopic("base/temp1/","temp1");
		client.addTopic("base/temp2/","temp2");
		
						
		while(true){
			String paa = "on";
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();					
		}
				if(!paa.equals(null) && paa.equals(PostOffice.deliver(client.getArrayTopic(), "temp"))){
					client.publish("growbox", "message arrived");
					System.out.println("ON");
					PostOffice.post(client.getArrayTopic(), "temp");					
			}
		}
	}
	}
