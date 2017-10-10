package mqttTestPublish;


import java.text.DecimalFormat;
//import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MainTestPublisher {

	public static void main(String[] args) {
		
		
		
		for(int i = 0; i < i+1; i++){
			if (i == 100){
				i = 0;
			}else{
				//LocalDateTime timePoint = LocalDateTime.now();
				
				double tamp = Math.random() * 100;
				DecimalFormat df = new DecimalFormat("#.#"); 
				tamp = Double.valueOf(df.format(tamp));
				 
				String tempMsg = Double.toString(tamp);
				String message = Integer.toString(i);
				TestPublisher.publisher(tempMsg);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}
