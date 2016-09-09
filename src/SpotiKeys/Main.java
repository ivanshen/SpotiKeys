package SpotiKeys;

import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import SpotiKeys.keyBindings;
import SpotiKeys.GUI;


public class Main implements NativeKeyListener {
	// OSASCRIPT COMMANDS
	protected static String ACTIVATE = "tell application \"Spotify\" to activate";
	protected String PLAYPAUSE = "tell application \"Spotify\" to playpause";
	protected String PREV_TRACK = "tell application \"Spotify\" to previous track";
	protected String NEXT_TRACK = "tell application \"Spotify\" to next track";
	protected String QUIT = "tell application \"Spotify\" to quit";
	protected String MUTE = "tell application \"Spotify\" to set sound volume to 0";
	protected String INC_VOL = "tell application \"Spotify\"\n" + 
		    "set currentvol to get sound volume\n" +
		    "if currentvol > 90 then\n" +
		        "set sound volume to 100\n" +
		    "else\n" +
		        "set sound volume to currentvol + 10\n" +
		    "end if\n" +
		"end tell";
	protected String DEC_VOL = "tell application \"Spotify\"\n" + 
		    "set currentvol to get sound volume\n" +
		    "if currentvol < 10 then\n" +
		        "set sound volume to 0\n" +
		    "else\n" +
		        "set sound volume to currentvol - 10\n" +
		    "end if\n" +
		"end tell";

	private int playPauseCounter = 0;
	private int nextTrackCounter = 0;
	private int prevTrackCounter = 0;
	private int incVolCounter = 0;
	private int decVolCounter = 0;
	private int muteVolCounter = 0;
	private int quitCounter = 0;
	public static void run() {
		try {
			GlobalScreen.registerNativeHook();
			keyBindings.readKeys();
		} catch(Exception e) {
			  
			e.printStackTrace();
		}
		exec(ACTIVATE);
		GlobalScreen.addNativeKeyListener(new Main());
	}
	@Override        
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (keyBindings.playPauseKey.contains(String.valueOf(e.getKeyCode()))) {
	        playPauseCounter++;
	        if (GUI.chckbxPlaypause.isSelected() && playPauseCounter == keyBindings.playPauseKey.size()){
	        	exec(PLAYPAUSE);
	        	playPauseCounter = 0;
	        }
	    }
	    if (keyBindings.nextTrackKey.contains(String.valueOf(e.getKeyCode()))) {
	    	nextTrackCounter++;
	    	if (GUI.chckbxNextTrack.isSelected() && nextTrackCounter == keyBindings.nextTrackKey.size()){
	        	exec(NEXT_TRACK);
	        	nextTrackCounter = 0;
	        }
	    }      
	    if (keyBindings.prevTrackKey.contains(String.valueOf(e.getKeyCode()))) {
	    	prevTrackCounter++;
	    	if (GUI.chckbxPreviousTrack.isSelected() && prevTrackCounter == keyBindings.prevTrackKey.size()){
	        	exec(PREV_TRACK);
	        	prevTrackCounter = 0;
	        }
	    }
	    if (keyBindings.decVolKey.contains(String.valueOf(e.getKeyCode()))) {
	    	decVolCounter++;
	    	System.out.println(decVolCounter);
	    	if (GUI.chckbxDecreaseVolume.isSelected() && decVolCounter == keyBindings.decVolKey.size()){
	        	exec(DEC_VOL);
	        	decVolCounter = 0;
	        }
	    }
	    if (keyBindings.incVolKey.contains(String.valueOf(e.getKeyCode()))) {
	    	incVolCounter++;
	    	if (GUI.chckbxIncreaseVolume.isSelected() && incVolCounter == keyBindings.incVolKey.size()){
	        	exec(INC_VOL);
	        	incVolCounter = 0;
	        }
	    }
	    if (keyBindings.muteVolKey.contains(String.valueOf(e.getKeyCode()))) {
	    	muteVolCounter++;
	    	if (GUI.chckbxMuteVolume.isSelected() && muteVolCounter == keyBindings.muteVolKey.size()){
	        	exec(MUTE);
	        	muteVolCounter = 0;
	        }
	    }
	    if (keyBindings.quitKey.contains(String.valueOf(e.getKeyCode()))) {
	    	quitCounter++;
	    	if (GUI.chckbxQuitSpotify.isSelected() && quitCounter == keyBindings.quitKey.size()){
	        	exec(QUIT);
	        	quitCounter = 0;
	        }
	    }
	} 

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (keyBindings.playPauseKey.contains(String.valueOf(e.getKeyCode()))) {
			playPauseCounter--;
			if (playPauseCounter < 0)
				playPauseCounter = 0;
		}
		if (keyBindings.nextTrackKey.contains(String.valueOf(e.getKeyCode())))  {
			nextTrackCounter--;
			if (nextTrackCounter < 0)
				nextTrackCounter = 0;
		}
		if (keyBindings.prevTrackKey.contains(String.valueOf(e.getKeyCode())))  {
			prevTrackCounter--;
			if (prevTrackCounter < 0)
				prevTrackCounter = 0;
		}
		if (keyBindings.incVolKey.contains(String.valueOf(e.getKeyCode())))  {
			incVolCounter--;
			if (incVolCounter < 0)
				incVolCounter = 0;
		}
		if (keyBindings.decVolKey.contains(String.valueOf(e.getKeyCode())))  {
			decVolCounter--;
			if (decVolCounter < 0)
				decVolCounter = 0;
		}
		if (keyBindings.muteVolKey.contains(String.valueOf(e.getKeyCode())))  {
			muteVolCounter--;
			if (muteVolCounter < 0)
				muteVolCounter = 0;
		}
		if (keyBindings.quitKey.contains(String.valueOf(e.getKeyCode())))  {
			quitCounter--;
			if (quitCounter < 0)
				quitCounter = 0;
		}
	}
	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void exec(String cmd)
	{
		if (!GUI.nextTrackListen && !GUI.playListen && !GUI.prevTrackListen && !GUI.incVolListen && !GUI.decVolListen && !GUI.muteListen && !GUI.quitListen){
			Runtime runtime = Runtime.getRuntime();
			String[] args = { "osascript", "-e", cmd };
		
			try
			{
				Process process = runtime.exec(args);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
