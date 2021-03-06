package controller;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.Model;
import view.View;

public class Controller implements Model.OnStateChangeListener {
	private Model mModel;
	private View mView;
	
	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub
		mModel = model;
		mView = view;
		
		// 向Model注册监听事件
		model.setOnStateChangeListener(this);
		
		/*model.setOnStateChangeListener(view);*/
		mView.addLoadListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mModel.loadImage();
			}
		});
		mView.addClearListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mModel.clearImage();
			}
		});
	}

	// 在Model里被调用
	@Override
	public void onStateChanged(Image image) {
		mView.setMyIconImage(image);
	}
	
	/*
	public void loadImage() {
		mModel.loadImage();
	}
	
	public void clearImage() {
		mModel.clearImage();
	}*/
}
