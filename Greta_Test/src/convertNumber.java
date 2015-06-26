
public class convertNumber {

	private final String[] tens = {
		
		"beynte",
		"trenta",
		"kwarenta",
		"singkwenta",
		"seisenta",
		"setenta",
		"otsenta",
		"nobenta"
			
	};
	
	private final String[] teens = {
		
		"diyes",
		"onse",
		"dose",
		"trese",
		"katorse",
		"kinse",
		"disi-sais",
		"disi-siyete",
		"disi-otso",
		"disi-nuwebe"
			
	};
	
	private final String[] ones = {
			
		"uno",
		"dos",
		"tres",
		"kwatro",
		"sinko",
		"sais",
		"syete",
		"otso",
		"nuwebe"
		
			
	};
	
	public String convertToWords(int number) {
		
		String words = new String();
		String numStr = new String();
		String tenStr = new String();
		
		int places;
		
		numStr = words.toString();
		places = numStr.length();
		
		if(places == 1) {
			// ones
			return ones[number];
			
		}
		else if(places == 2) {
			// tens
			tenStr = getTens(numStr, number);
			return tenStr;
		}
		
		return "";
		
	}
	
	public String getTens(String numStr, int number) {
		
		String str = new String();
		char z = numStr.charAt(0);
		
		int x = Character.getNumericValue(numStr.charAt(1));
	
		if(z == '1') {
			// teens
			return teens[x];
		}
		else {
			
			str = tens[x].concat(" ").concat(ones[number]);
			return str;
		}
		
		
	}
		
}
