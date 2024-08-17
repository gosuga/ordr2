package com.onlineorder.Onlineord.ERCS;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;
@Service
public class ThreadService {
	
	
	private int counter=0;
	
	public final java.util.concurrent.locks.Lock lock= new ReentrantLock();
	
	
	public void incCount() {
		
		lock.lock();
			try {
			Thread.sleep(1500);
			} catch (Exception e) {
			e.getMessage();
		}finally {
			lock.unlock();
		}
		counter++;
		System.out.println("number of count"+counter);
		}
	

}
