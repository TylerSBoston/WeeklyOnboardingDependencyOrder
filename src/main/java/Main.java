import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	
	// no hackerrank style solution? all test hardcoded for now then, each need their own try catch
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DependencyOrganizer orginizer = new DependencyOrganizer();
		
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("a");
			projects.add("b");
			projects.add("c");
			projects.add("d");
			projects.add("e");
			projects.add("f");
			projects.add("g");
			projects.add("h");
			
			String[][] dependencies = {{"a","e"},{"a","c"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println(Arrays.deepToString(dependencies));
			System.out.println(orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("g");
			projects.add("b");
			projects.add("c");
			projects.add("d");
			projects.add("e");
			projects.add("f");
			projects.add("a");
			projects.add("h");
			
			String[][] dependencies = {{"a","e"},{"a","c"},{"f","g"},{"g","a"},{"h","g"},{"h","e"},{"c","d"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println("Dependencies: " + Arrays.deepToString(dependencies));
			System.out.println("Result: "+orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("g");
			projects.add("a");
			projects.add("c");
			projects.add("a");
			projects.add("e");
			projects.add("f");
			projects.add("a");
			projects.add("h");
			
			String[][] dependencies = {{"a","e"},{"a","c"},{"f","g"},{"g","a"},{"h","g"},{"h","e"},{"c","d"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println("Dependencies: " + Arrays.deepToString(dependencies));
			System.out.println("Result: "+orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("g");
			projects.add("b");
			projects.add("c");
			projects.add("d");
			projects.add("e");
			projects.add("f");
			projects.add("a");
			projects.add("h");
			
			String[][] dependencies = {{"a","e"},{"d","c"},{"c","b"},{"b","e"},{"e","d"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println("Dependencies: " + Arrays.deepToString(dependencies));
			System.out.println("Result: "+orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("g");
			projects.add("b");
			projects.add("c");
			projects.add("d");
			projects.add("e");
			projects.add("f");
			projects.add("a");
			projects.add("h");
			
			String[][] dependencies = {{"a","elipo"},{"d","c"},{"c","b"},{"b","e"},{"e","d"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println("Dependencies: " + Arrays.deepToString(dependencies));
			System.out.println("Result: "+orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		try {

			LinkedList<String> projects = new LinkedList<String>();
			projects.add("g");
			projects.add("b");
			projects.add("c");
			projects.add("d");
			projects.add("e");
			projects.add("f");
			projects.add("a");
			projects.add("h");
			projects.add("aa");
			projects.add("bb");
			projects.add("cc");
			projects.add("dd");
			projects.add("ee");
			projects.add("ff");
			projects.add("gg");
			projects.add("hh");
			
			String[][] dependencies = {{"a","e"},{"d","c"},{"c","b"},{"b","e"},{"e","aa"},{"aa","gg"},{"g","d"},{"hh","b"},{"hh","ff"},{"b","bb"},{"ee","a"},{"gg","dd"},{"a","hh"},{"hh","f"},{"a","bb"}};
			
			System.out.println("Projects: " + projects.toString());
			System.out.println("Dependencies: " + Arrays.deepToString(dependencies));
			System.out.println("Result: "+orginizer.generateBootOrder(projects, dependencies));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		//	e.printStackTrace();
		}
		
		
	}	
}
