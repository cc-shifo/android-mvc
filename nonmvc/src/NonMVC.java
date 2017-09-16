package output;

import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.io.*;

public class NonMVC {
	public static void main(String[] args) {
		// 构造JFame作为视图容器
		JFrame container = new JFrame();

		// 构造JPanel作为视图根布局
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());

		// 构造JLabel装过在图片并置于视图中心位置
		final JLabel label = new JLabel();
		setMyLabelIcon(label);
		root.add(label, BorderLayout.CENTER);

		// 构造JPanel作为按钮的布局，并置于视图底部
		JPanel btnLayout = new JPanel();
		btnLayout.setLayout(new FlowLayout());
		//构造读取图片按钮btnLoad，并加入btnLayout布局中
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMyLabelIcon(label);
			}
		});
		btnLayout.add(btnLoad);

		// 构造清除图片按钮btnClear，并加入btnLayout中
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(new ImageIcon());
			}
		});
		btnLayout.add(btnClear);

		root.add(btnLayout, BorderLayout.SOUTH);

		// 将视图根布局装载到视图容器中
		container.setContentPane(root);
		container.pack();
		container.setTitle("Non MVC");
		container.setVisible(true);
	}

	private static void setMyLabelIcon(JLabel label) {
		try {
			File file=new File("D:/workspace/java/nonmvc/res/96x96PX.png");
			InputStream is=new FileInputStream(file);
			Image image = ImageIO.read(is);
			label.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
