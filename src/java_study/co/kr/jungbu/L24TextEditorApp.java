package java_study.co.kr.jungbu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
class TextEditor extends JFrame {
	JTextArea ta;
	JMenuBar mb;
	JMenu menu;
	JMenuItem miNew, miOpen, miSave, miExit;
	public TextEditor() {
		super("텍스트 편집기"); //super: 부모 접근 지정자, super():부모의 생성자 호출 //부모jframe
		ta=new JTextArea();
		mb=new JMenuBar();
		menu = new JMenu("파일");
		miNew = new JMenuItem("새로만들기");
		miOpen= new JMenuItem("열기");
		miSave =  new JMenuItem("저장");
		miExit =  new JMenuItem("끝내기");
		menu.add(miNew);
		menu.add(miOpen);
		menu.add(miSave);
		menu.add(miExit);
		mb.add(menu);
		
		this.setJMenuBar(mb);
		this.add(ta);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		miOpen.addActionListener((e)->{
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showOpenDialog(this);
			if(option==JFileChooser.APPROVE_OPTION) { //파일이 선택되면
				File file = fileChooser.getSelectedFile();
				try {
					Scanner num = new Scanner(file);
						while(num.hasNext()) {
						String line = num.nextLine();
						System.out.println(line);
						ta.append(line+"\n");
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			//JFrame 창에 파일 가져와서 읽기 
						
			}
		});
	}
}

public class L24TextEditorApp {

	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setBounds(2000,10,400,400);
//		f.setVisible(true);
		TextEditor editor = new TextEditor(); //객체지향문법
		editor.setBounds(100,10,400,400);
		editor.setVisible(true);
		
		//git 수정 테스트
		
		
	}

}
