package AhmetBuyukyilmaz;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String UserName;
	private String Password;
	private ArrayList<Child> Childs;
	private ArrayList<Mode> Modes;


	public Parent(String userName, String password) {
		UserName = userName;
		Password = password;
		Childs = new ArrayList<Child>();
		Modes = new ArrayList<Mode>();
	}

	public Parent() {
		Childs = new ArrayList<Child>();
		Modes = new ArrayList<Mode>();
	}

	public ArrayList<Mode> getModes() {
		return Modes;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public ArrayList<Child> getChilds() {
		return Childs;
	}

	public Child getChild(String Name){
		for (Child child:this.getChilds()) {
			if(child.getName().equals(Name)){
				return child;
			}
		}
		return null;
	}
	public void addChild(Child C){
		if(getChild(C.getName())==null){
			Childs.add(C);
		}
	}

	public boolean deleteChild(String name){
		for (Child child:Childs) {
			if(child.getName().equals(name)){
				if(Childs.remove(child)) return true;
			}
		}
		return false;
	}

	public String [] listChilds(){
		String[] str = new String[this.getChilds().size()];
		for (int i = 0;i<getChilds().size();i++) {
			str[i] = getChilds().get(i).getName();
		}
		return str;
	}
	public String [] listModes(){
		String[] str = new String[this.getModes().size()];
		for (int i = 0;i<getModes().size();i++) {
			str[i] = getModes().get(i).toString();
		}
		return str;
	}

	public void addMode(Mode m){
		if(this.getMode(m.getName())==null){
			Modes.add(m);
		}
	}
	public Mode getMode(String Name){
		for (Mode mode:this.getModes()) {
			if(mode.getName().equals(Name)){
				return mode;
			}
		}
		return null;
	}

	public boolean deleteMode(String name){
		for (Mode mode:Modes) {
			if(mode.getName().equals(name)){
				Modes.remove(mode);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Exam> getHighScores(){
		ArrayList<Exam> tmp = new ArrayList<Exam>();
		for(Child child:this.getChilds()){
			for(Exam exam:child.getExams()){
				tmp.add(exam);
			}
		}

		tmp.sort(Comparator.comparingInt(o1-> o1.getScore()));
		return tmp;
	}

	public Object[][] listHighScores(){
		int min = this.getHighScores().size();
		if(min>5) min = 5;

		Object [][] obj = new Object[min][];
		for(int i = 0;i<min;i++){
			Exam exam = getHighScores().get(getHighScores().size()-1-i);
			obj[i] = new Object[]{exam.getChildName(), exam.getScore(),exam.getQuestionsNumber(), exam.getTime()};
		}
		return obj;
	}
	public void saveParent(Parent parent) {
		try {
			String fileName="Parent.dat";
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(parent.getUserName());
			writer.writeObject(parent.getPassword());
			writer.writeObject(parent.getChilds().size());
			for(Child child: parent.getChilds()){
				writer.writeObject(child);
			}
			writer.writeObject(parent.getModes().size());
			for(Mode mode:parent.getModes()){
				writer.writeObject(mode);
			}
			writer.close();
			System.out.println("File saved");
		}catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void readParent(Parent parent) throws ClassNotFoundException {
		try {
			String fileName="Parent.dat";
			ObjectInputStream reader= new ObjectInputStream(new FileInputStream(fileName));
			parent.setUserName((String) reader.readObject());
			parent.setPassword((String) reader.readObject());
			int a = (int)reader.readObject();
			for(int i = 0 ;i<a;i++){
				parent.addChild((Child) reader.readObject());
			}
			a = (int)reader.readObject();
			for(int i = 0 ;i<a;i++){
				parent.addMode((Mode) reader.readObject());
			}
			reader.close();
			System.out.println("Readed");
		}catch(IOException e){
			System.out.println("An error occured during file operation");
			e.printStackTrace();
		}
	}
}
