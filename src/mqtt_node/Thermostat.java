package mqtt_node;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Thermostat {
	private int setpoint;
	private boolean status;
	private String topic;
	private MQTTclient client;
	
public Thermostat(String topic, MQTTclient client){
	this.topic = topic;
	this.client = client;
	
	}
	
		
	public void compare(String temperature){
		if(Double.parseDouble(temperature) < setpoint && status != true){
			try {
				System.out.println("on");
				client.publish(topic, "on");
				status = true;
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(Double.parseDouble(temperature) > (setpoint +1) && status != false){
			try {
				System.out.println("off");
				client.publish(topic, "off");
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = false;
		}
	}
	
	public int getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(int setpoint) {
		this.setpoint = setpoint;
	}

	public boolean getStatus() {
		return status;
	}
}
