package java_study.co.kr.jungbu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L19StreamAPIEx5 {
	class Student{
		private String name;
		private boolean isMale;
		private int hak;
		private int ban;
		private int score;
		public Student(String name,boolean isMale,int hak,int ban,int score) {
			this.name=name;
			this.isMale=isMale;
			this.hak=hak;
			this.ban=ban;
			this.score=score;
		}
		public String getName() {return name;}
		public boolean isMale() {return isMale;}
		public int getHak() {return hak;}
		public int getBan() {return ban;}
		public int getScore() {return score;}
		
		
		@Override
		public String toString() {
			return "{"+name +","+isMale+","+hak+","+ban+","+ score+"}";
		}
	}

	public static void main(String[] args) {
		List<Student> studentList=new ArrayList<Student>();
		L19StreamAPIEx5 out=new L19StreamAPIEx5();
		studentList.add(out.new Student("나자바", true, 1, 1, 300));
		studentList.add(out.new Student("김지미", false, 1, 1, 250));
		studentList.add(out.new Student("김자바", true, 1, 1, 200));
		studentList.add(out.new Student("이지미", false, 1, 2, 150));
		studentList.add(out.new Student("남자바", true, 1, 2, 100));
		studentList.add(out.new Student("안지미", false, 1, 2, 50));
		studentList.add(out.new Student("황지미", false, 1, 3, 100));
		studentList.add(out.new Student("강지미", false, 1, 3, 150));
		
		studentList.add(out.new Student("나자바", true, 2, 1, 300));
		studentList.add(out.new Student("김지미", false, 2, 1, 250));
		studentList.add(out.new Student("김자바", true, 2, 1, 200));
		studentList.add(out.new Student("이지미", false, 2, 2, 150));
		studentList.add(out.new Student("남자바", true, 2, 2, 100));
		studentList.add(out.new Student("안지미", false, 2, 2, 50));
		studentList.add(out.new Student("황지미", false, 2, 3, 100));
		studentList.add(out.new Student("강지미", false, 2, 3, 150));

		studentList.add(out.new Student("나자바", true, 3, 1, 300));
		studentList.add(out.new Student("김지미", false, 3, 1, 250));
		studentList.add(out.new Student("김자바", true, 3, 1, 200));
		studentList.add(out.new Student("이지미", false, 3, 2, 150));
		studentList.add(out.new Student("남자바", true, 3, 2, 100));
		studentList.add(out.new Student("안지미", false, 3, 2, 50));
		studentList.add(out.new Student("황지미", false, 3, 3, 100));
		studentList.add(out.new Student("강지미", false, 3, 3, 150));
		
		//1학년 남자들의 점수 //2학년 여자들의 점수
		Optional <String> boySum2 = studentList.stream()
				.filter(p->p.isMale==true)
				.filter(p->p.hak==1)
				.map(p->p.score+"")
				.reduce((s1,s2)->s1+","+s2);
		System.out.println(boySum2.get());
		
		Optional <String> girlSum2 = studentList.stream()
				.filter(p->p.isMale==false)
				.filter(p->p.hak==1)
				.map(p->p.score+"")
				.reduce((s1,s2)->s1+","+s2);
		System.out.println(girlSum2.get());
			

		
		//1한년의 남자 여자의 수를 collect로 구현하세요!
		Map<Object, List<Student>> boyCount = studentList.stream()
				.filter(p->p.hak==1)
				.collect(Collectors.groupingBy(p->p.isMale));
		System.out.println("1학년남자의수: "+boyCount.get(true).size());
		System.out.println("1학년여자의수: "+boyCount.get(false).size());
		
		
		//1한년을 남자 여자의 그룹으로 나누고 다시 통과(score>=150)와 낙제 그룹으로 나누세요.
		Map<Object, List<Student>> failure = studentList.stream()
				.filter(p->p.hak==1)
				.filter(p->p.score>=150)
				.collect(Collectors.groupingBy(p->p.isMale));
		System.out.println("1학년 남자 통과:"+failure.get(true));
		System.out.println("1학년 여자 통과:"+failure.get(false));

		
		
		//1학년 남자,여자 그룹의 평균 점수를 구하세요
		OptionalDouble boySum = studentList.stream()
				.filter(p->p.hak==1)
				.filter(p->p.isMale==true)
				.mapToInt(p->p.score)
				.average();
		System.out.println("1학년 남자 여자 그룹의 평균 점수를 구하세요."+boySum);
		
		OptionalDouble girlSum = studentList.stream()
				.filter(p->p.hak==1)
				.filter(p->p.isMale==false)
				.mapToInt(p->p.score)
				.average();
		System.out.println("1학년 여자 그룹의 평균 점수를 구하세요."+girlSum);
			
		//각학년별 남자 여자 그룹의  접수가 가장 높은 사람을 구하세요
		Map<Integer, Map<Boolean, Optional<Student>>> map= studentList.stream()
		.collect(Collectors.groupingBy(Student::getHak,
		Collectors.partitioningBy(Student::isMale
		,Collectors.maxBy(Comparator.comparingInt(Student::getScore)))));
		System.out.println(map);
		
		
		//2한년을 남자 여자의 그룹으로 나누고 다시 통과한 사람과 낙제 한 사람의 수를 구하세요
		Map<Object, List<Student>> failure2 = studentList.stream()
				.filter(p->p.hak==2)
				.filter(p->p.score>=150)
				.collect(Collectors.groupingBy(p->p.isMale));
		System.out.println("2학년 남자 통과수: "+failure2.size());
		System.out.println("2학년 여자 통과수: "+failure2.size());
		
		//모든 학년을 그룹으로 나누고 학년 마다  남자와 여자 그룹의 수를 구하세요
		Map<Object, List<Student>> allHak = studentList.stream()
				.collect(Collectors.groupingBy(p->p.hak));
		
		for(int i=0;i<3;i++) {
			long c = allHak.get(i+1).stream()
					.filter(p->p.isMale==true)
					.count();
			System.out.println(i+1+"학년 남자 수: "+c);
		}
		
		for(int i=0;i<3;i++) {
			long c = allHak.get(i+1).stream()
					.filter(p->p.isMale==false)
					.count();
			System.out.println(i+1+"학년 여자 수: "+c);
		}

		//모든 학년을 그룹으로 나누고 학년 마다 반 그룹으로 나누세요
		Map<Object, List<Student>> allHak2 = studentList.stream()
				.collect(Collectors.groupingBy(p->p.hak));
		
		for(int i=0;i<3;i++) {
			Map<Object, List<Student>> c = allHak2.get(i+1).stream()
					.collect(Collectors.groupingBy(p->p.ban));
			for(int j =0;j<3;j++) {
				System.out.println(i+1+"학년"+(j+1)+"반"+c.get(j+1));
			}
		}
	
				

	}

}
