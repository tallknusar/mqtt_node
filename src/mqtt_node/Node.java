package mqtt_node;

import java.util.ArrayList;

public class Node {
	private String topic;
	private String name;
	private String message;
	private boolean run = false;	
	private static int id = 0;

	public Node(String topic, String name, ArrayList<Node> arrayTopics){
		id++;
		this.topic = topic;
		this.name = name;
		
		arrayTopics.add(this);
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Node.id = id;
	}
	public String getMessage() {
		return message;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	

}
