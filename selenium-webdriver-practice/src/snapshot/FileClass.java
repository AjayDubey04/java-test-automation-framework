package snapshot;

import java.io.File;
import java.io.IOException;

public class FileClass {


	public static void main(String[] args) throws IOException {

		FileClass obj=new FileClass();
		//		obj.makeSingleFolder();
		obj.fileDemo();

	}


	public void makeSingleFolder() throws IOException {

		File obj=new File("C:\\Users\\hp\\OneDrive\\Desktop\\vtiger.txt");
		//		obj.mkdir();  // create new folder
		obj.createNewFile(); // create new file

		System.out.println(obj.canExecute());
		System.out.println(obj.canRead());
		System.out.println(obj.canWrite());
		System.out.println(obj.exists());
		System.out.println(obj.getName());
		System.out.println(obj.isFile());
		System.out.println(obj.isHidden());
		obj.deleteOnExit(); 	

	}


	public void makeMultipleFolder() {

		File obj=new File("C:\\Users\\hp\\OneDrive\\Desktop\\selenium.txt");
		obj.mkdirs(); // create folder inside folder

		//		System.out.println(obj.canExecute());
		//		System.out.println(obj.canRead());
		//		System.out.println(obj.canWrite());
		//		System.out.println(obj.exists());
		//		System.out.println(obj.getName());
		//		System.out.println(obj.getAbsolutePath());
		//		System.out.println(obj.isFile());
		//		System.out.println(obj.isHidden());

		obj.delete();

	}
	
	public static void fileClass() {

		File obj=new File("C:\\Users\\hp\\OneDrive\\Desktop//hello.txt");
		System.out.println(obj.canExecute());
		System.out.println(obj.canRead());
		System.out.println(obj.canWrite());
		System.out.println(obj.exists());
		obj.delete();

	}
	
	public void fileDemo() {
		
		File f=new File("C:\\Users\\hp\\eclipse-workspace\\org.selenium.webdriver\\hii");
		f.delete();
		
	}

	
}
