import java.io.File;
//https://www.codejava.net/java-se/file-io/calculating-total-files-sub-directories-and-size-of-a-directory
public class CalculateFilesInDirectory {
	public static long[] calculateDirectoryInfo(String dirPath) {
	 long[] result = new long[] {0, 0, 0};
	    int totalFiles = 0;
	    int totalDirs = 0;
	    long totalSize = 0;
	 
	    File dir = new File(dirPath);
	 
	    if (!dir.exists()) {
	        throw new IllegalArgumentException("The given path does not exist.");
	    }
	 
	    if (dir.isFile()) {
	        throw new IllegalArgumentException("The given path is a file. A directory is expected.");
	    }
	 
	    File[] subFiles = dir.listFiles();
	 
	    if (subFiles != null && subFiles.length > 0) {
	        for (File aFile : subFiles) {
	            if (aFile.isFile()) {
	                totalFiles++;
	                totalSize += aFile.length();
	            } else {
	                totalDirs++;
	                long[] info = calculateDirectoryInfo(aFile.getAbsolutePath());
	                totalDirs += info[0];
	                totalFiles += info[1];
	                totalSize += info[2];
	            }
	        }
	 
	        result[0] = totalDirs;
	        result[1] = totalFiles;
	        result[2] = totalSize;
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
		
		String dirPath = "C:/Users/sankalpg/Coding_Practice/robertSedwick/src/robertSedwick";
		long[] dirInfo = calculateDirectoryInfo(dirPath);
		 
		System.out.println("Total sub directories: " + dirInfo[0]);
		System.out.println("Total files: " + dirInfo[1]);
		System.out.println("Total size: " + dirInfo[2]);

	}

}
