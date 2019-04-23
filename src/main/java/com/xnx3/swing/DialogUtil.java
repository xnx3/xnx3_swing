package com.xnx3.swing;

import java.awt.CardLayout;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 * 弹出窗口、消息提醒相关工具类
 * @author 管雷鸣
 *
 */
public class DialogUtil {
	/**
	 * confirm弹出提示框-选择了是
	 */
	public final static int CONFIRM_YES=0;
	
	/**
	 * confirm弹出提示框-选择了否
	 */
	public final static int CONFIRM_NO=1;
	
	/**
	 * confirm弹出提示框-选择了取消
	 */
	public final static int CONFIRM_CENCEL=2;

	
	/**
	 * 鼠标跟随提示信息的显示界面
	 */
	static JFrame jframeMessageForMouse;
	static JLabel jlabelMessageForMouse;
	static{
		jframeMessageForMouse=new JFrame();
		jframeMessageForMouse.setUndecorated(true);
		jframeMessageForMouse.setType(Type.POPUP);
		jframeMessageForMouse.setAlwaysOnTop(true);
		JPanel jp = new JPanel();
		jp.setBorder(new LineBorder(java.awt.Color.RED, 1, true));
		jframeMessageForMouse.setContentPane(jp);
		jp.setLayout(new CardLayout(0, 0));
		
		jlabelMessageForMouse = new JLabel("New label");
		jlabelMessageForMouse.setVerticalAlignment(SwingConstants.TOP);
		jlabelMessageForMouse.setHorizontalAlignment(SwingConstants.LEFT);
		jlabelMessageForMouse.setHorizontalTextPosition(SwingConstants.LEFT);
		jlabelMessageForMouse.setAutoscrolls(true);
		jlabelMessageForMouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jframeMessageForMouse.setVisible(false);
			}
		});
		jlabelMessageForMouse.setBorder(new EmptyBorder(10, 10, 10, 10));
		jp.add(jlabelMessageForMouse, "name_24011468992203");
	}
	


	/**
	 * 在当前屏幕上显示一段信息提示，配合{@link UI#hiddenMessageForMouse()} 使用
	 * @param x 信息显示框的左上角在屏幕的x坐标
	 * @param y 信息显示框的左上角在屏幕的y坐标
	 * @param width 显示的提示框宽度
	 * @param height 显示的提示框高度
	 * @param html 显示的文字，支持html格式
	 * @return 显示文字的组件JLabel，可对此组件进行调整
	 * @see UI#showMessageForMouse(MouseEvent, int, int, String)
	 */
	public static JLabel showMessageForMouse(int x,int y,int width,int height,String html){
		jlabelMessageForMouse.setText("<html>"+html);
		jframeMessageForMouse.setBounds(x+10, y+10, width, height);
		jframeMessageForMouse.setVisible(true);
		
		return jlabelMessageForMouse;
	}
	
	
	/**
	 * 隐藏鼠标跟随的信息提示 配合 {@link UI#showMessageForMouse(MouseEvent, int, int, String)} 使用
	 */
	public static void hiddenMessageForMouse(){
		jframeMessageForMouse.setVisible(false);
	}
	
	/**
	 * 显示鼠标跟随的信息提示，配合{@link UI#hiddenMessageForMouse()} 使用
	 * @param mouseEvent 添加鼠标监听后，传入鼠标的监听对象 java.awt.event.MouseEvent
	 * @param width 显示的提示框宽度
	 * @param height 显示的提示框高度
	 * @param html 显示的文字，支持html格式
	 * @return 显示文字的组件JLabel，可对此组件进行调整
	 * @see UI#showMessageForMouse(int, int, int, int, String)
	 */
	public static JLabel showMessageForMouse(MouseEvent mouseEvent,int width,int height,String html){
		int x=0;
		int y=0;
		if(mouseEvent!=null){
			x=mouseEvent.getXOnScreen();
			y=mouseEvent.getYOnScreen();
		}
		
		return showMessageForMouse(x, y, width, height, html);
	}
	

	/**
	 * 弹出提示框
	 * @param message 要显示的信息，支持HTML
	 */
	public static void showMessageDialog(String message){
		JOptionPane.showMessageDialog(null, "<html>"+message);
	}
	
	/**
	 * 弹出选择、确认框 
	 * @param message 要显示的信息 ，支持HTML
	 * @return int {@link #CONFIRM_YES} {@link #CONFIRM_NO} {@link #CONFIRM_CENCEL}
	 */
	public static int showConfirmDialog(String message){
		return JOptionPane.showConfirmDialog(null,"<html>"+message);
	}
	
}
