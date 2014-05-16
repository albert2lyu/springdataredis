package com.mypack.message.listener;



public class SampleMessageListener implements MessageDelegate {

	@Override
	public void handleMessage(String message) {
		System.out.println("String message:" + message);
	}


}
