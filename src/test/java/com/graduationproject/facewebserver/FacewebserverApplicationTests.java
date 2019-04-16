package com.graduationproject.facewebserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import socketconnect.SocketConnect;

@RunWith(SpringRunner.class)
@ComponentScan({"socketconnect"})
@SpringBootTest
public class FacewebserverApplicationTests {

	@Test
	public void contextLoads() {
		SocketConnect.testDetect("camcatch.png");
	}

}
