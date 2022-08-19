import java.io.File;
import java.io.IOException;

public class FileObjectTest{
	/** The main method(automatically called by JVM) that
	* uses file class.
	*/
	public static void main(String[] args){
		// watch out for IOException
		try{

			// if the user did not enter a file/directory name
			// at command prompt - exit.
			if (args.length != 1){
				System.out.println("Usage: FileObjectTest <File/Dir Name>");
				System.exit(0);
			}

			// Open a File or Directory entered at
			// command prompt args[0]
			File file = new File (args[0]);

			if (!file.exists()){
				System.out.println("File does not exist, creating new file");
				file.createNewFile();
			}
			else{
	
				if (file.isFile()){
					System.out.println("You have entered a file name");
					
					// get the file size.
					System.out.println("File size: " + file.length());
					System.out.println();
					
				}
				
				// if directory show the directory listing
				if (file.isDirectory()){
					System.out.println("You have entered a directory name");
					System.out.println("Files in the directory: ");
	
					// get the file names in the directory
					String[] strFiles = file.list();
					
					// loop through the files and display them
					for (int nI=0; nI < strFiles.length;nI++){
						System.out.println("	" +strFiles[nI]);
					}
					System.out.println();
				}
			}

			// show attributes
			System.out.println("Readable: " + file.canRead());
			System.out.println("Writable: " + file.canWrite());
			System.out.println("Hidden: " + file.isHidden());
			System.out.println("Absolute path: " + file.getAbsolutePath());
			System.out.println("Name: " + file.getName());
			System.out.println();
			
			File[] drives;

			// get the drive letters on the machine.
			drives=File.listRoots();
			System.out.println("Here are the Drives: ");
			
			// loop through the drive names and print them
			for (int nI=0; nI < drives.length;nI++){
				System.out.println("	" +drives[nI].toString());
			}

		}

		// catch IOException.
		catch (IOException e){
			System.out.println(e.toString());
		}
	}
} 
