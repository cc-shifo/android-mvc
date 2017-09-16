package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
@SuppressWarnings("serial")
public class View extends JFrame{
	private final JButton mBtnLoad = new JButton("Load");
	private final JButton mBtnClear = new JButton("Clear");
	private final JLabel mLabel = new JLabel();
	
	public View(Model model) {
		// TODO Auto-generated constructor stub
		
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		root.setPreferredSize(new Dimension(480, 320));
		mLabel.setIcon(new ImageIcon());
		root.add(mLabel, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(mBtnLoad);
		btnPanel.add(mBtnClear);
		
		root.add(btnPanel, BorderLayout.SOUTH);
		
		setContentPane(root);
		pack();
		setTitle("Classic MVC");
		setVisible(true);
	}
	
	// 给按钮注册监听器
	public void addLoadListener(ActionListener listener) {
		mBtnLoad.addActionListener(listener);
	}
	
	public void addClearListener(ActionListener listener) {
		mBtnClear.addActionListener(listener);
	}
	
	// 更新View，由Controller触发
	public void setMyIconImage(Image image) {
		if (image == null) {
			mLabel.setIcon(new ImageIcon());
		} else {
			mLabel.setIcon(new ImageIcon(image));
		}
	}
}
