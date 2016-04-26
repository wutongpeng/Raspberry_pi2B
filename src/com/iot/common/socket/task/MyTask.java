package com.iot.common.socket.task;

import java.net.Socket;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iot.common.socket.SocketVirtualController;
import com.iot.common.socket.thread.MyThread;


/**
 * 控制线程的任务
 * */
public class MyTask extends TimerTask {	
	private static Logger LOG = LoggerFactory.getLogger(MyTask.class);
	MyThread mt;
	static Socket socket;
	public MyTask(){
		startThread();
	}
	
	/**
	 * 开启线程
	 * */
	public void startThread(){
		String IP="localhost"; 
		int PORT = 6789;
		try {
			
			socket = new Socket(IP, PORT);
			mt=new MyThread(socket);
			mt.setStatus(true);
			mt.start();
		}catch(Exception e){
            e.printStackTrace();
		}
		
	}
	
	/**
	 * 关闭线程
	 * */
	public void stopThread(){
		mt.setStatus(false);
	}
	
	@Override
	public void run() {
		
		System.out.println("********");
		SocketVirtualController iw=new SocketVirtualController();
		if(iw.isCmdstatus()){			
			if(!mt.isStatus()){
				startThread();
			}												
		}else if(!iw.isCmdstatus()){	
			if(mt.isStatus()){
				stopThread();
			}			
		}
	}	

}