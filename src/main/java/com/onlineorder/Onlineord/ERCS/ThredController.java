package com.onlineorder.Onlineord.ERCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thd")
public class ThredController {

	private ThreadService threadService;
	@Autowired
	public ThredController(ThreadService tsd) {
		this.threadService=tsd;
	}
	
	
@PostMapping("/thd")
public String restthd() {
	
Runnable  work =()-> threadService.incCount();

Thread t1=new Thread(work);
Thread t2=new Thread(work);

 t1.start();
 t2.start();
return "counteradd";


}




}
