package com.cloud.bbs;

public class SingleTonTest {
	private static SingleTonTest stt = new SingleTonTest();
	
	private SingleTonTest() {
		
	}
	
	public static SingleTonTest getInstance() {
		if(stt==null) {
			stt=new SingleTonTest();
		}
		return stt;
	}

}