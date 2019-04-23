package com.xnx3.swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;

/**
 * 文件选择、打开文件 工具类
 * @author 管雷鸣
 *
 */
public class FileChooserUtil {
	public static final String ENCODE="UTF-8";	//默认文件编码UTF-8
	
	/**
	 * 打开文件，获得其 UTF-8 格式字符串
	 * @return 选中文件的UTF-8格式的字符串
	 */
	public static String readFileByJFileChooser(){
		return readFileByJFileChooser(ENCODE);
	}
	
    /**
     * 读取文件内容，通过用户自己打开文件选择框的方式
     * @param encode 以什么编码读取文件，如：UTF-8
     * @return 文件的内容，若用户没有打开或者打开失败，返回null
     */
    public static String readFileByJFileChooser(String encode){
    	String xnx3_content = null;
    	JFileChooser jfc=new JFileChooser(".");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result=jfc.showOpenDialog(jfc);
		if(result==0){	//用户选择了打开
			try{
				File file=jfc.getSelectedFile();
				xnx3_content = read(file, encode);
				file=null;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		jfc=null;
		return xnx3_content;
    }
    

	/**
	 * 读文件，返回文件内容
	 * @param file 要读取的文件
	 * @param encode 编码，如FileUtil.GBK
	 * @return String 读取的文件文本信息
	 */
	private static String read(File file,String encode){
		StringBuffer xnx3_content=new StringBuffer();
		try{
			BufferedReader xnx3_reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),encode));
			String date=null;
			while((date=xnx3_reader.readLine())!=null){
				xnx3_content.append(date);
			}
			xnx3_reader.close();
		}catch (Exception e) {
		}
		
		return xnx3_content.toString();
	}
    
}
