package com.oracle.gdms.util;

import java.util.ResourceBundle;

public class Factory {
	
	private Factory() {}
	
	private static Factory fac = null;
	
	public static Factory getInstance() {
		fac = fac == null?new Factory():fac;
		return fac;
	}
	
	private static ResourceBundle rb = null;
	static {
		rb = ResourceBundle.getBundle("config/application");
	}
	
	public Object getObject(String key) {
		String clsname = rb.getString(key);
		
		try {
			return Class.forName(clsname).newInstance();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}
	
}