package com.games.abyssal.Presentation.Views;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.games.abyssal.Domain.Entities.Achievement;
import com.games.abyssal.Presentation.Controllers.AchievementsController;
import javax.swing.JLabel;

public class AchievementsWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7864247107799356278L;

	private JPanel contentPane;
	
	private AchievementsView view;
	private InputController input;
	private JList<String> list;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AchievementsWindow frame = new AchievementsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AchievementsWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				Long selectedIndex = (long) list.getSelectedIndex();
				view.onAchievementClicked(selectedIndex);
				textArea.setText((view.model.viewingAchievement == null ? "" : view.model.viewingAchievement.getDescription()));
			}
		});
		list.setBounds(32, 34, 206, 134);
		contentPane.add(list);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(32, 213, 206, 83);
		contentPane.add(textArea);
		
		AchievementsController controller = new AchievementsController();
		this.input = controller.view.input;
		this.view = controller.view;
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Achievement a : view.model.playerAchievements.values()) {
		    model.addElement(a.getTitle());
		}
		list.setModel(model);
		
		JLabel lblYourAchievements = new JLabel("Your achievements");
		lblYourAchievements.setBounds(32, 11, 93, 14);
		contentPane.add(lblYourAchievements);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(32, 188, 67, 14);
		contentPane.add(lblDescription);
		
	}
	public JList<String> getList() {
		return list;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
}
