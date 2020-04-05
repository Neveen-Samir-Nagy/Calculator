package eg.edu.alexu.csd.oop.calculator.cs58;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Calculator implements eg.edu.alexu.csd.oop.calculator.Calculator{

	 double number1;
	 double number2;
	 char operation;
	 LinkedList<String> List = new LinkedList<String>();
	 String current="";
	 int index;
	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		if(s.length()==0) {
			throw new UnsupportedOperationException("Error");
		}
		List.add(s);
		current=s;
		if(List.size()==6) {
			List.removeFirst();
		}
		index=List.size()-1;	
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		String result= getcurrent(current);
		return result;
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		if(List.size()==0 || current.length()==0) {
			return null;
		}
		return current;
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		if(index==0 || current.length()==0) {
		return null;
		}
		index = index-1;
		current = List.get(index);
        return current;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		if(index == List.size()-1 || current.length()==0) {
		return null;
		}
		current = List.get(index+1);
		index = index+1;
		return current;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		File save = new File("History.txt");
		try {
			save.createNewFile();
			PrintWriter fw = new PrintWriter(save, "UTF-8");
            for(int i=0;i<List.size();i++) {
            	fw.println(List.get(i));
            }
            fw.println(current);
            fw.print(index);
            fw.close();
        } catch (IOException e) {
            //do stuff with exception
        }
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		File save = new File("History.txt");
		if(!save.exists()) {
			throw new UnsupportedOperationException("Error");
		}
		List.clear();
		try {
			FileReader fr = new FileReader(save);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
		    while (line != null) {
		        List.add(line);
		        line = br.readLine();
		    }
		    index = Integer.parseInt(List.removeLast());
		    current = List.removeLast();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getcurrent(String s) {
		int i=0;
		String getnumb = "";
		for(i=0; i<s.length();i++) {
			if(s.charAt(i)=='-'&&i==0) {
				getnumb+= s.charAt(i);
			}else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/') {
				break;
			}else {
				getnumb+= s.charAt(i);
			}
		}
		number1 = Double.parseDouble(getnumb);
		if(i==s.length()) {
			throw new UnsupportedOperationException("Error");
		}else {
			operation = s.charAt(i);
			i++;
		}
		getnumb="";
		for(i=i; i<s.length();i++) {
			getnumb+= s.charAt(i);
		}
		number2 = Double.parseDouble(getnumb);
		getnumb="";
		if(operation=='+') {
			getnumb+=(number1+number2);
		}else if(operation=='-') {
			getnumb+= (number1-number2);
		}else if(operation=='*') {
			getnumb+= (number1*number2);
		}else if(operation=='/') {
			if(number2==0) {
				throw new UnsupportedOperationException("Division by zero!");
			}else {
				getnumb+= (number1/number2);
			}
		}else {
			getnumb = null;
		}
		return getnumb;
	}
    
}
