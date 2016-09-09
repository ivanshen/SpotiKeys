package SpotiKeys;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Properties;

import javax.swing.JCheckBox;

import org.jnativehook.GlobalScreen;

import java.util.ArrayList;
import java.util.Arrays;
public class keyBindings {
	static Properties props = new Properties();
	public static ArrayList<String> playPauseKey = new ArrayList<String>();
	public static ArrayList<String> nextTrackKey = new ArrayList<String>();
	public static ArrayList<String> prevTrackKey = new ArrayList<String>();
	public static ArrayList<String> incVolKey = new ArrayList<String>();
	public static ArrayList<String> decVolKey = new ArrayList<String>();
	public static ArrayList<String> muteVolKey = new ArrayList<String>();
	public static ArrayList<String> quitKey = new ArrayList<String>();
	public static final String name = "data/keys.properties";
	public static ArrayList<String> tmp = new ArrayList<String>();
	public static void readKeys() throws Exception {
		FileInputStream in = new FileInputStream(name);
		props.load(in);
		playPauseKey.addAll((Arrays.asList(props.getProperty("playpause").split("\\s*,\\s*"))));
		nextTrackKey.addAll((Arrays.asList(props.getProperty("nextTrack").split("\\s*,\\s*"))));
		prevTrackKey.addAll((Arrays.asList(props.getProperty("prevTrack").split("\\s*,\\s*"))));
		incVolKey.addAll((Arrays.asList(props.getProperty("incVol").split("\\s*,\\s*"))));
		decVolKey.addAll((Arrays.asList(props.getProperty("decVol").split("\\s*,\\s*"))));
		muteVolKey.addAll((Arrays.asList(props.getProperty("muteVol").split("\\s*,\\s*"))));
		quitKey.addAll((Arrays.asList(props.getProperty("quit").split("\\s*,\\s*"))));
		GUI.chckbxPlaypause.setSelected(Boolean.valueOf(props.getProperty("playPauseEnabled")));
		GUI.chckbxNextTrack.setSelected(Boolean.valueOf(props.getProperty("nextTrackEnabled")));
		GUI.chckbxPreviousTrack.setSelected(Boolean.valueOf(props.getProperty("prevTrackEnabled")));
		GUI.chckbxIncreaseVolume.setSelected(Boolean.valueOf(props.getProperty("incVolEnabled")));
		GUI.chckbxDecreaseVolume.setSelected(Boolean.valueOf(props.getProperty("decVolEnabled")));
		GUI.chckbxMuteVolume.setSelected(Boolean.valueOf(props.getProperty("muteVolEnabled")));
		GUI.chckbxQuitSpotify.setSelected(Boolean.valueOf(props.getProperty("quitEnabled")));
		in.close();
	}
	public static void storeKeys(String action, int keyCode, ArrayList<String> keys) throws IOException {
		FileOutputStream out = new FileOutputStream(name);
		String key = String.valueOf(macKeyConversion.map.get(keyCode));
		if (key != "null" && !tmp.contains(key))
			tmp.add(key);
		props.setProperty(action, tmp.toString().replace("[", "").replace("]", "").replace(" ", "").trim());
		props.store(out, null);
		try {
			readSpecificKey(action, keys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readSpecificKey(String action, ArrayList<String> keys) throws IOException{
		keys.clear();
		FileInputStream in = new FileInputStream(name);
		props.load(in);
		keys.addAll((Arrays.asList(props.getProperty(action).split("\\s*,\\s*"))));
		in.close();
	}
	public static void updateEnabled(String action, boolean selected) throws IOException{
		FileOutputStream out = new FileOutputStream(name);
		props.setProperty(action, Boolean.toString(selected));
		props.store(out, null);
		
	}
}
