package mqtt_node;

import java.util.ArrayList;

public class PostOffice {
	
	public static boolean sort(ArrayList<Node> arrayTopic,String message,String topic){		
		for(int i = 0;i < arrayTopic.size();i++){
			if(topic.equals(arrayTopic.get(i).getTopic())){
				arrayTopic.get(i).setMessage(message);
				System.out.println("Message:" + message + "            Posted to : " + topic);			
			}
		}		
		return false;
	}

	public static String deliver(ArrayList<Node> arrayTopic,String name){
		String message = null;
		for(int i = 0;i < arrayTopic.size() ;i++){
			if(name.equals(arrayTopic.get(i).getName())){
				message = arrayTopic.get(i).getMessage();
				//System.out.println(message);
				return message;	
			}
		}
		return message;		
	}
	
	public static void post(ArrayList<Node> arrayTopic,String name){
		String message = null;
		for(int i = 0;i < arrayTopic.size() ;i++){
			if(name.equals(arrayTopic.get(i).getName())){
				 arrayTopic.get(i).setMessage("off");
				//System.out.println(message);
					
			}
		}
				
	}
	}
