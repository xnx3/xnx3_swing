package com.xnx3.swing;

import java.awt.AWTException;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.ImageIcon;

/**
 * 托盘相关工具类
 * @author 管雷鸣
 *
 */
public class TrayUtil {

	/** 
     * 创建此程序的系统托盘，本程序的托盘创建、以及使用返回的对象进行托盘弹出信息提示等
     * <li>MyEclipse编辑时一般菜单会出现中文乱码，不用在意。打包出去后会正常。
     * <li>简单使用：<pre>SystemUtil.createTray(MyClassName.class.getResource("res/icon.png"), "显示文字", null)</pre>
     * <li>高级使用：<a href="http://www.xnx3.com/doc/j2se_util/20150307/131.html">http://www.xnx3.com/doc/j2se_util/20150307/131.html</a>
     * @param imageIcon 托盘的图标所在路径。若图片过大会不显示！建议尺寸15*15的png图片。 如 <pre>new ImageIcon(MyClassName.class.getResource("res/icon.png"))</pre> 其中trayico.png在当前的目录下的res文件夹内，MyClassName为当前生成次托盘的类名
     * @param title 鼠标放到托盘图标上时显示的文字
     * @param popupMenu 托盘右键点击后弹出的菜单项。若不想有菜单项或者不需要，可传入null
     * @return {@link TrayIcon} 对象。若是返回null，则创建失败
     */  
    public static TrayIcon createTray(ImageIcon imageIcon,String title,PopupMenu popupMenu) {  
    	TrayIcon trayIcon=null;
    	SystemTray sysTray= SystemTray.getSystemTray();// 获得当前操作系统的托盘对象  
    	
        trayIcon=new TrayIcon(imageIcon.getImage(), title, popupMenu);
        
        try {
			sysTray.add(trayIcon);		//将托盘添加到操作系统的托盘  
			return trayIcon;
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
    }  
    
}
