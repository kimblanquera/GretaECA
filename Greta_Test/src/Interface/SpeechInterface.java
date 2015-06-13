package Interface;

import java.util.ArrayList;
import Bean.XMLinfo;

import Bean.Speech;

public interface SpeechInterface {

	public ArrayList<Speech> allSpeech();
	public int getType(int textTypeID, int intentTypeID);
	public XMLinfo getXML(int type, String lang, int y);
	public ArrayList<Speech> getQuestionByStep(int i);
	
}
