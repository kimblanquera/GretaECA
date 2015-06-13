import java.util.Random;

public class gretaSpeech {
	
	public String getXMLbyParam(int sT, int sS) {
		
		if (sT == 1 && sS == 1) { // QUESTION && NORMAL
			
			return randGenXML(1);
			
		}
		else if (sT == 1 && sS == 2) { // QUESTION && NEG

			return randGenXML(2);
			
		}
		else if (sT == 2 && sS == 1) { // REPLY && POSITIVE

			return randGenXML(3);
			
		}
		else if (sT == 2 && sS == 2) { // REPLY && NEG

			return randGenXML(4);
			
		}
		
		return "";
		
	}
	
	public String randGenXML(int type) {
		
		Random r = new Random();
		
		if(type == 1) {
		
			int x = r.nextInt(3);
			
			if(x == 0) { 
				
				return "bml/question_normal2.xml";
				
			}
			else if(x == 1) {
				
				return "bml/question_normal3.xml";
				
			}
			else if(x == 2) {
				
				return "bml/question_normal4.xml";
				
			}
			else if(x == 3) {
				
				return "bml/question_normal5.xml";
				
			}
			
		}
		else if(type == 2) {
			
			int x = r.nextInt(2);
			
			if(x == 0) {
				
				return "bml/question_gentle.xml";
				
			}
			else if(x == 1) {
				
				return "bml/question_gentle2.xml";
				
			}
			else if(x == 2) {
				
				return "bml/question_gentle3.xml";
				
			}
			
		}
		else if(type == 3) {
			
			int x = r.nextInt(2);
			
			if(x == 0) {
				
				return "bml/reply_pos1.xml";
				
			}
			else if(x == 1) {
				
				return "bml/reply_pos2.xml";
				
			}
			else if(x == 2) {
				
				return "bml/reply_pos3.xml";
				
			}
			
		}
		else if(type == 4) {
			
			int x = r.nextInt(2);
			
			if(x == 0) {
				
				return "bml/reply_neg1.xml";
				
			}
			else if(x == 1) {
				
				return "bml/reply_neg2.xml";
				
			}
			else if(x == 2) {
				
				return "bml/reply_neg3.xml";
				
			}
			
		}
		else if(type == 5) {
			
			return "bml/instruct_hospital.xml";
			
		}
		
		return "";
		
	}
	
	
	
	
	
}
