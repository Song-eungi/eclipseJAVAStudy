package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class L16StreamAPIEx2 {
	//{"products":{{"name:"desk","price":12222,"category":4,"quantity:55}, {"name:"desk","price":35000,"category":4,"quantity:55}  }
	//쇼핑몰에서 판매하는 상품 자료 type=Variable Object(VO), Data Transfer Object(DTO)
	
	//JSON(JavaSriptObjectNotaion)
	//key:value로 되어 있는 가장 인기 있는 자료구조 
	//자바스크립트 객체 명세서(객체 설명서) =>리터러 표기법으로 만들어짐 =>문자열 통신으로 사용 
	//장점: 문자열, 가볍고, 데이터 타입을 정의, data traveling이 용이....
	
	//열거형: 각 필드가 고유값을 갖는 상수기 때문에 수를 사용하는 다른 상수와 섞어 쓰지 않는다. (단점:자바 내부에서만 사용가능)
    //enum Cate {식품,의료,가구,문구류,침구류}
	//번호와 문자열을 동시에 쓰고 싶은 경우
	interface Cate { //DB에 저장하는 분류가 보통 수로 되어 있기 때문에 수로 된 상수를 사용
		public static int 식품=0;
		public static int 의류=1;
		public static int 가구=2;
		public static int 문구=3;
		public static int 침구=4;
	}
	
	class ProductDTO {
		//class의 전역에 선언된 변수 : 전역변수, 객체의 필드로 생성됨(속성)
		String name=null;
		int price=0;
		int category; //0:식품,1:의류,2:가구,3:문구류,4:침구류 (약속) or 열거형(enum Cate)
		int quantity=10;
		
		//생성자로 필드를 초기화
		//생성자의 return이 없는 이유 : 생성자는 new연 산자로 호출하면 객체를 반환하는데 이름이 반환하는 타입의 함수다.
		//product는 이름이 아니라 타입, 즉 이름이 없는 것
		public ProductDTO(String name, int price, int  category) { //클래스와 같은 이름
			//필드 접근자! this
			this.name = name;
			this.price = price;
			this.category = category;
		}
		public ProductDTO(String name, int price, int  category, int quantity) { //클래스와 같은 이름
			//필드 접근자! this
			this.name = name;
			this.price = price;
			this.category = category;
			this.quantity = quantity;
		}
		public int sum(int a,int b) {return a+b;} //함수는 반환하는 data의 type을 명시한다.(int,String...)
		
		@Override
		//JSON처럼 출력
		public String toString() {
			return "ProductDTO: {name:" + name + ", price:" + price + ", category:" + category + ", quantity:" + quantity
					+ "}";
		}
	}
	
	public static void main(String[] args) {
		L16StreamAPIEx2 ex2 = new L16StreamAPIEx2(); //or static
		List<ProductDTO> products = new ArrayList<ProductDTO>();
//		products.add(ex2.new ProductDTO("허쉬 초콜릿", 1000, Cate.식품));    //enum Cate {식품,...}
		products.add(ex2.new ProductDTO("허쉬 초콜릿", 1000, Cate.식품)); //interface Cate2 {public static int 식품=0....}
		products.add(ex2.new ProductDTO("허쉬 초콜릿 우유", 1200, Cate.식품, 5));
		products.add(ex2.new ProductDTO("바나나 단지 우유", 1500, Cate.식품, 3));
		products.add(ex2.new ProductDTO("돼지바", 900, Cate.식품, 15));
		
		products.add(ex2.new ProductDTO("허쉬 초콜릿", 1000, Cate.식품));
		products.add(ex2.new ProductDTO("허쉬 초콜릿 우유", 1200, Cate.식품, 5));
		products.add(ex2.new ProductDTO("바나나 단지 우유", 1500, Cate.식품, 3));
		products.add(ex2.new ProductDTO("돼지바", 900, Cate.식품, 15));
		products.add(ex2.new ProductDTO("하겐다즈 바닐라", 5000, Cate.식품,11));
		products.add(ex2.new ProductDTO("소세지 도시락", 3500, Cate.식품,3));
		products.add(ex2.new ProductDTO("도시락 컵라면", 800, Cate.식품,50));
		
		products.add(ex2.new ProductDTO("hp 연필", 500, Cate.문구,200));
		products.add(ex2.new ProductDTO("지우개", 500, Cate.문구,50));
		products.add(ex2.new ProductDTO("볼펜", 1000, Cate.문구,100));
		products.add(ex2.new ProductDTO("화이트 지우개", 2500, Cate.문구,3));
		
		products.add(ex2.new ProductDTO("흰색 셔츠", 10000, Cate.의류,0));
		products.add(ex2.new ProductDTO("나이키 반팔 티", 25000, Cate.의류,5));
		products.add(ex2.new ProductDTO("나이키 신발", 110000, Cate.의류,2));
		products.add(ex2.new ProductDTO("아디다스 신발", 95000, Cate.의류,2));
		
		products.add(ex2.new ProductDTO("여름용 이불", 25000, Cate.침구,1));
		products.add(ex2.new ProductDTO("솜 베게", 2000, Cate.침구,10));
		products.add(ex2.new ProductDTO("대나무 베게", 2000, Cate.침구,0));
		products.add(ex2.new ProductDTO("침대 커버 퀸", 15000, Cate.침구,3));
		
		products.add(ex2.new ProductDTO("행거", 60000, Cate.가구,5));
		products.add(ex2.new ProductDTO("책상", 45000, Cate.가구,10));
		products.add(ex2.new ProductDTO("듀오백의자", 145000, Cate.가구,3));
		
		
		System.out.println(products); //Object.toString() : 객체 정보
		
		//편의점 관리 프로그램
		//편의점의 상품 저장
		
		//편의점 상품 분류, 상품의 수가 없는 것을 확인, 분류 별로 상품의 가격 평균 => 관리(자료를 다루는 방법)
		// 식품 중에 2000원 이상인 것을 검색하고 싶다.
		//외부 반복문 검사식(함수형 언어가 지원하는 내부 반복문 보다 복잡도가 높다)
		List<ProductDTO>foods = new ArrayList<ProductDTO>();
		for(ProductDTO p : products) {
			if(p.category==Cate.식품 && p.price>=2000 ) { 
				foods.add(p); }}
		System.out.println("외부 반복문 검사식: "+foods.toString());
		
		//Stream //내부 반복문을 사용하면 stream 자료를 query처럼 제어할 수 있다.
		Optional<String> namesOPt=products.stream()
		.filter((p)->p.category==Cate.식품)
		.filter((p)->p.price>=2000) //중간연산을 수정 삭제하기 편하고 재사용 할 수 있다
		.map((p)->p.name) //이름만 반환
		.reduce((s,s1)->s+","+s1); //매개변수 무조건 2개
		//최종연산 BinaryOperator : (s1,s2)->{return s3}
		//reduce 동작 원리: {10,20,30,40,50,60,70} result=0;
		//(s1,s2)->s1+s2; 
		//0:result+=nums[0]+nums[1];
		//1:result+=nums[2];
		//2:result+=nums[3];
		//...
		//result+=nums[nums.length-1]; return result
		
//		.forEach((p)->{System.out.print("Stream 반복문 검사식: "+p); });
//		.forEach(System.out::println);
		System.out.println(namesOPt.get());
		
		//카테고리가 가구 인것의 합을 구하세요 (reduce)
		int sum = products.stream()
		.filter((p)->p.category==Cate.가구)
		.mapToInt((p)->p.price*p.quantity) 
		//중간 연산이 IntStream을 반환(기본형 스트림의 장점: 1.null없음 2.연산하는 함수를 제공)
		.sum();  //average;
		System.out.println("가구의 가격 총합: " + sum);
//		.reduce((i,i2)->i+i2); //
//		.forEach(System.out::println);     
//		System.out.println(sumOpt.get());//Optional<Integer> sumOpt
		
		
		
		
		//NULL OPTIONAL
		Integer i = null;
//		System.out.println(i+10); //오류 null.intValue()
		i=30;
		System.out.println(i+10);
		//Optional: data가 null 일 수 있으니 처리하도록 명시하는 타입
		Optional<Integer> i_opt=Optional.empty(); //Optional 선언법
		i_opt=Optional.ofNullable(99); //Optional data를 참조하는 방법
//		i_opt=Optional.ofNullable(null);// null이 아닌 객체만 참조(사용하지 않는다)
//		System.out.println(i_opt+20);
//		System.out.println(i_opt.get()+20);
		//반환되는 데이터가 Null일 수 있음을 type으로 명시
		if(i_opt.isPresent()) {
			System.out.println(i_opt.get()+20);
		} else {
			System.out.println("isPresent() 는 값이 있을 때만 True를 반환, isEmpty()는 Null일 때만 True 반환");
		}
		
		i_opt.ifPresent((num)-> 
			{System.out.println("값이 있을 때만 실행하는 함수");
		});
		
		i_opt.ifPresentOrElse((num)->{System.out.println("값이 있을 때만 실행");}
		, ()->{ System.out.println("null일때 실행");
		});
		
		
		////////////////steam groupingBy ///////////////////
		Map<Object, List<ProductDTO>> groupingList = products.stream()
			.collect(Collectors.groupingBy(p->p.category));
		//해당 객체의 특정 필드로 반환하면 해당 필드를 key로 하는 list로 그룹핑 된다.
		
		System.out.println(groupingList);
		System.out.println(groupingList.get(Cate.의류));
		System.out.println(groupingList.get(Cate.가구));
		////////////////steam partitioningBy true or false의 2 그룹으로 나누는 것 ///////////////////
		
	}
}





