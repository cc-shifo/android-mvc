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
		// ����JFame��Ϊ��ͼ����
		JFrame container = new JFrame();

		// ����JPanel��Ϊ��ͼ������
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());

		// ����JLabelװ����ͼƬ��������ͼ����λ��
		final JLabel label = new JLabel();
		setMyLabelIcon(label);
		root.add(label, BorderLayout.CENTER);

		// ����JPanel��Ϊ��ť�Ĳ��֣���������ͼ�ײ�
		JPanel btnLayout = new JPanel();
		btnLayout.setLayout(new FlowLayout());
		//�����ȡͼƬ��ťbtnLoad��������btnLayout������
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMyLabelIcon(label);
			}
		});
		btnLayout.add(btnLoad);

		// �������ͼƬ��ťbtnClear��������btnLayout��
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(new ImageIcon());
			}
		});
		btnLayout.add(btnClear);

		root.add(btnLayout, BorderLayout.SOUTH);

		// ����ͼ������װ�ص���ͼ������
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
