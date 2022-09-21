package java_study.co.kr.jungbu;

import java.io.IOException;

public class L20InputOutputStream {

	public static void main(String[] args) {
		//입출력IO 장치와 스트립
		//입력(input)과 출력(output) : 컴퓨터 내부(cpu,memory), 외부(장치)에서 프로그램간에 데이터를 주고 받는 것(오류를 동반)
		//파일을 입력받거나 출력하는 행위
		//소리를 출력, 키보드 or 마우스 입력
		//모니터에 출력 
		try {
			int i=System.in.read(); //InputStream : byte 기반의 입출력 클래스라 문자열을 입력 받을 수 없다.
			System.out.println("입력한 값: "+i); 
			//아스키코드(1byte):최초로 만들어진 문자표, 유니코드(2byte):모든 문자를 사용하기 위해 만들어진 문자표
			//입출력은 기본 1byte를 기준으로 data를 입력하거나 출력한다. 
			//예) char(97 + 26) (255 77) (0 44) (99 254) -1 (문서) =>유니코드로 변환
			//예) char(97) (16) (255) (77) (0) (44) (99) (254) -1 (문서) =>유니코드로 변환
			
			// 2^0 0 0 0 0 0 0 0 0 2^7  약속 byte type이라 하겠다.
			// 2^1 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0 0 0  2^15  약속 char type이라 하겠다.
			//   1 0 0 0 0 0 1 0 0/1 1 0 0 0 0 0 0 0

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}