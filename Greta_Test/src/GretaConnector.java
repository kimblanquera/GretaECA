
import com.cmlabs.air.JavaAIRPlug;
import com.cmlabs.air.Message;
import com.cmlabs.air.Time;


public class GretaConnector {
    
    JavaAIRPlug plug;
    
 
    public GretaConnector(){
        plug = connect("127.0.0.1",10000);
    }
    
    private JavaAIRPlug connect(String host,int port){
        plug = new JavaAIRPlug("SimpleBMLSender", host, port);
        if (!plug.init()) {
        	System.out.println("Could not connect to the Server on " + host + " on port " + port + ". Exit.");
            System.exit(1);
            return null;
        }
        
        
        if (!plug.openTwoWayConnectionTo("Greta.Whiteboard")) {
            System.out.println("Could not open callback connection to Greta.Whiteboard. Exit.");
            System.exit(1);
            return null;
        }
        
        String xml = "<module name=\"SimpleBMLSender\" allowselftriggering=\"yes\">"+
                "              <spec>"+
                "                 <context name=\"Psyclone.System.Ready\">"+
                 "   <phase id=\"Phase One\">" +
                "                       <post to=\"Greta.Whiteboard\" type=\"Greta.Data.BML\" />" +
                "                       <post to=\"Greta.Whiteboard\" type=\"Greta.Data.FML\" />"  +
                "                       <post to=\"Greta.Whiteboard\" type=\"Greta.RealtimePlayer.Command\" />"   +"</phase>" + "   </context>"+
                "              </spec>"+
                "           </module>";
        
        
        if (!plug.sendRegistration(xml)) {
           
            return null;
            
        } else {
        	
        	//System.out.println("Reg sent: " + xml);
            return plug;
            
        }
    }   
    
    /**
     * Processes data to be sent to Greta
     * @param send The message to be sent
     * @param message_type The message type
     */
    public void process(String send,String message_type){        
        
            Time now;
            
           
            Message msg_ans = new Message("SimpleBMLSender","Greta.Whiteboard", message_type);
            
            try{
                
                msg_ans.content = send;
                                
                boolean posted = plug.postOutputMessage(msg_ans);
                if (!posted) {
                    System.out.println("I could not post message...");                
                }  else {
                    now = new Time();
                    System.out.println("Message posted at:" + now.printTime());     
                }
            }
            
            catch (Exception myexception){
                
                System.out.println("I could not generate answer..."+ myexception);                
        }
        
    }
    
}
