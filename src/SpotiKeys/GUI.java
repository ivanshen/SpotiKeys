package SpotiKeys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.apple.eawt.AppEvent.AboutEvent;
import com.apple.eawt.Application;
import com.apple.eawt.QuitStrategy;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.apple.eawt.AboutHandler;
public class GUI extends JFrame implements KeyListener{
	private JPanel contentPane;
	private String bindOn = "Binding";
	private String bindOff = "Bind Keys";
	public static boolean playListen = false;
	public static boolean nextTrackListen = false;
	public static boolean prevTrackListen = false;
	public static boolean incVolListen = false;
	public static boolean decVolListen = false;
	public static boolean muteListen = false;
	public static boolean quitListen = false;

	public static JCheckBox chckbxPlaypause = new JCheckBox("Play/Pause");
	public static JCheckBox chckbxPreviousTrack = new JCheckBox("Previous Track");
	public static JCheckBox chckbxNextTrack = new JCheckBox("Next Track");
	public static JCheckBox chckbxIncreaseVolume = new JCheckBox("Increase Volume");
	public static JCheckBox chckbxDecreaseVolume = new JCheckBox("Decrease Volume");
	public static JCheckBox chckbxMuteVolume = new JCheckBox("Mute Volume");
	public static JCheckBox chckbxQuitSpotify = new JCheckBox("Quit Spotify");

	/**
	 * Launch the application.
	 */  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main.run();
				try {
					GUI frame = new GUI();
					frame.setAboutHandler();;
					frame.setVisible(true);
					frame.setquitHandler();
				} catch (Exception e) {
					e.printStackTrace();  
				}  
			}
		});
	}
	/**
	 * Create about page
	 */
	private void setAboutHandler() {
		Application a = Application.getApplication();
		a.setAboutHandler(new AboutHandler() {
			
			@Override
			public void handleAbout(AboutEvent e){
				ImageIcon icon = new ImageIcon("icon/application.png"); 
				JLabel label = new JLabel();
				label.setText("<html>© 2016 Ivan Shen<br>This is a FREE software.<br>Please visit my website: <a href='ivanshen.github.io'>ivanshen.github.io</a></html>");
				JOptionPane.showMessageDialog(null, label, "SpotiKeys",
						JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});
	}
	private void setquitHandler(){
		Application a = Application.getApplication();
		a.setQuitStrategy(QuitStrategy.SYSTEM_EXIT_0);
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
	    System.setProperty("apple.laf.useScreenMenuBar", "true");
	    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "SpotiKeys");
		setExtendedState(JFrame.ICONIFIED);
		setBounds(200, 200, 500, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		InputMap im = (InputMap) UIManager.get("Button.focusInputMap");
		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im.put(KeyStroke.getKeyStroke("released SPACE"), "none");
		InputMap im2 = (InputMap) UIManager.get("CheckBox.focusInputMap");
		im2.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im2.put(KeyStroke.getKeyStroke("released SPACE"), "none");
		
		chckbxPlaypause.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("playPauseEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("playPauseEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxPlaypause.setBounds(5, 90, 140, 33);
		contentPane.add(chckbxPlaypause);

		final JLabel playPauseLabel = new JLabel(labelConversion(keyBindings.playPauseKey));
		playPauseLabel.setBounds(286, 99, 208, 16);
		contentPane.add(playPauseLabel);

		final JButton playPause = new JButton(bindOff);
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playListen = !playListen;
				if (playListen && !nextTrackListen && !prevTrackListen && !incVolListen && !decVolListen && !muteListen && !quitListen) {
					playPause.setText(bindOn);
					playPause.addKeyListener(new KeyListener() { // playPause Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(playListen, playPauseLabel, e, "playpause", keyBindings.playPauseKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					playPause.setText(bindOff);
					keyBindings.tmp.clear();
					playListen = false;
				}
			}
		});
		
		playPause.setBounds(157, 94, 117, 29);
		contentPane.add(playPause);

		chckbxNextTrack.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("nextTrackEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("nextTrackEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxNextTrack.setBounds(6, 135, 117, 39);
		contentPane.add(chckbxNextTrack);

		final JLabel nextTrackLabel = new JLabel(labelConversion(keyBindings.nextTrackKey));
		nextTrackLabel.setBounds(286, 147, 208, 16);
		contentPane.add(nextTrackLabel);

		final JButton nextTrack = new JButton(bindOff);
		nextTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextTrackListen = !nextTrackListen;
				if (nextTrackListen && !playListen && !prevTrackListen && !incVolListen && !decVolListen && !muteListen && !quitListen) {
					nextTrack.setText(bindOn);
					nextTrack.addKeyListener(new KeyListener() { // prevTrack Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(nextTrackListen, nextTrackLabel, e, "nextTrack", keyBindings.nextTrackKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					nextTrack.setText(bindOff);
					keyBindings.tmp.clear();
					nextTrackListen = false;
				}
			}
		});
		
		nextTrack.setBounds(157, 142, 117, 29);
		contentPane.add(nextTrack);

		chckbxPreviousTrack.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("prevTrackEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("prevTrackEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxPreviousTrack.setBounds(6, 183, 128, 39);
		contentPane.add(chckbxPreviousTrack);

		final JLabel prevTrackLabel = new JLabel(labelConversion(keyBindings.prevTrackKey));
		prevTrackLabel.setBounds(286, 189, 208, 16);
		contentPane.add(prevTrackLabel);

		final JButton prevTrack = new JButton(bindOff);
		prevTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevTrackListen = !prevTrackListen;
				if (prevTrackListen && !nextTrackListen && !playListen && !incVolListen && !decVolListen && !muteListen && !quitListen) {
					prevTrack.setText(bindOn);
					prevTrack.addKeyListener(new KeyListener() { // prevTrack Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(prevTrackListen, prevTrackLabel, e, "prevTrack", keyBindings.prevTrackKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					prevTrack.setText(bindOff);
					keyBindings.tmp.clear();
					prevTrackListen = false;
				}
			}
		});
		
		prevTrack.setBounds(157, 190, 117, 29);
		contentPane.add(prevTrack);

		chckbxIncreaseVolume.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("incVolEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("incVolEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxIncreaseVolume.setBounds(6, 234, 140, 39);
		contentPane.add(chckbxIncreaseVolume);

		final JLabel incVolLabel = new JLabel(labelConversion(keyBindings.incVolKey));
		incVolLabel.setBounds(286, 234, 208, 16);
		contentPane.add(incVolLabel);

		final JButton incVol = new JButton(bindOff);
		incVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incVolListen = !incVolListen;
				if (incVolListen && !nextTrackListen && !prevTrackListen && !playListen && !decVolListen && !muteListen && !quitListen) {
					incVol.setText(bindOn);
					incVol.addKeyListener(new KeyListener() { // decVol Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(incVolListen, incVolLabel, e, "incVol", keyBindings.incVolKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					incVol.setText(bindOff);
					keyBindings.tmp.clear();
					incVolListen = false;
				}
			}
		});
		
		incVol.setBounds(157, 241, 117, 29);
		contentPane.add(incVol);

		chckbxDecreaseVolume.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("decVolEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("decVolEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxDecreaseVolume.setBounds(6, 285, 140, 29);
		contentPane.add(chckbxDecreaseVolume);

		final JLabel decVolLabel = new JLabel(labelConversion(keyBindings.decVolKey));
		decVolLabel.setBounds(286, 280, 208, 16);
		contentPane.add(decVolLabel);

		final JButton decVol = new JButton(bindOff);
		decVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decVolListen = !decVolListen;
				if (decVolListen && !nextTrackListen && !prevTrackListen && !incVolListen && !playListen && !muteListen && !quitListen) {
					decVol.setText(bindOn);
					decVol.addKeyListener(new KeyListener() { // decVol Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(decVolListen, decVolLabel, e, "decVol", keyBindings.decVolKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				}else {
					decVol.setText(bindOff);
					keyBindings.tmp.clear();
					decVolListen = false;
				}
			}
		});
		decVol.setBounds(157, 287, 117, 29);
		
		contentPane.add(decVol);

		chckbxMuteVolume.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("muteVolEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("muteVolEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxMuteVolume.setBounds(6, 326, 128, 39);
		contentPane.add(chckbxMuteVolume);

		final JLabel muteLabel = new JLabel(labelConversion(keyBindings.muteVolKey));
		muteLabel.setBounds(286, 326, 208, 16);
		contentPane.add(muteLabel);

		final JButton mute = new JButton(bindOff);
		mute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muteListen = !muteListen;
				if (muteListen && !nextTrackListen && !prevTrackListen && !incVolListen && !decVolListen && !playListen && !quitListen) {
					mute.setText(bindOn);
					mute.addKeyListener(new KeyListener() { // Mute Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(muteListen, muteLabel, e, "muteVol", keyBindings.muteVolKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					mute.setText(bindOff);
					keyBindings.tmp.clear();
					muteListen = false;
				}

			}
		});
		mute.setBounds(157, 333, 117, 29);
		contentPane.add(mute);

		chckbxQuitSpotify.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == e.SELECTED)
					try {
						keyBindings.updateEnabled("quitEnabled", true);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				else
					try {
						keyBindings.updateEnabled("quitEnabled", false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		chckbxQuitSpotify.setBounds(6, 377, 128, 33);
		contentPane.add(chckbxQuitSpotify);

		final JLabel quitLabel = new JLabel(labelConversion(keyBindings.quitKey));
		quitLabel.setBounds(286, 377, 208, 16);
		contentPane.add(quitLabel);

		final JButton quit = new JButton(bindOff);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitListen = !quitListen;
				if (quitListen && !nextTrackListen && !prevTrackListen && !incVolListen && !decVolListen && !muteListen && !playListen) {
					quit.setText(bindOn);
					quit.addKeyListener(new KeyListener() { // Mute Binding
						@Override
						public void keyPressed(KeyEvent e) {
							updateKeys(quitListen, quitLabel, e, "quit", keyBindings.quitKey);
						}

						@Override
						public void keyReleased(KeyEvent e) {
							;
						}

						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub

						}

					});
				} else {
					quit.setText(bindOff);
					keyBindings.tmp.clear();
					quitListen = false;
				}
			}
		});
		quit.setBounds(157, 381, 117, 29);
		contentPane.add(quit);

		JLabel lblBindYourOwn = new JLabel("Bind your own custom global hotkeys to control Spotify.");
		lblBindYourOwn.setBounds(59, 23, 389, 16);
		contentPane.add(lblBindYourOwn);

		JLabel lblCheckToEnable = new JLabel("Check to enable. Uncheck to disable.");
		lblCheckToEnable.setBounds(109, 62, 274, 16);
		contentPane.add(lblCheckToEnable);

		JLabel lblClickBindKeys = new JLabel("Click Bind Keys to set your keys. Click the button again to save.");
		lblClickBindKeys.setBounds(35, 45, 426, 16);
		contentPane.add(lblClickBindKeys);

	}

	public static void updateKeys(boolean isListening, JLabel label, KeyEvent e, String action,
			ArrayList<String> keys) {
		if (isListening) {
			try {
				keyBindings.storeKeys(action, e.getKeyCode(), keys);
				label.setText(labelConversion(keyBindings.tmp).toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static String labelConversion(ArrayList<String> keys) {
		ArrayList<String> formatted = new ArrayList<String>();
		for (int i = 0; i < keys.size(); i++) {
			formatted.add(macKeyConversion.strMap.get(Integer.parseInt(keys.get(i))));
		}
		return formatted.toString().replace("[", "").replace("]", "");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
