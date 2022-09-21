package java_study.co.kr.jungbu;

import java.time.LocalTime;

public class L10RunableLamda {

	public static void main(String[] args) {
		//극복1
		//인터페이스는 객체를 생성할 수 없다 = > 생성과 동시에 추상메서드를 구현{바디}하면 된다,
//		Thread clockTread=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(LocalTime.now());
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
		
		//극복2
		Runnable clock=()->{
			while(true) {
				System.out.println(LocalTime.now());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();}
				}
		};
		
		Thread clockThread = new Thread(clock);
		clockThread.start();
		System.out.println("main thread");
	}

	}
