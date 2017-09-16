package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {
	private Model mModel;
	private View mView;
	
	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub
		mModel = model;
		mView = view;
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

	/*
	public void loadImage() {
		mModel.loadImage();
	}
	
	public void clearImage() {
		mModel.clearImage();
	}*/
}
