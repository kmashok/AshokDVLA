package com.dvla.filehandling;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
//import java.io.IOException;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

//import com.gargoylesoftware.htmlunit.WebConsole.Formatter;
import java.util.Formatter;


@Service
public class ServiceLibrary {
	public static boolean folSuccess = false;
	public static boolean fileSuccess = false;
    private final static Logger log = LoggerFactory.getLogger(ServiceLibrary.class);
     
    //Test
    public static void testMethod(){
        log.info("YES, Working !!!");
    }
    
    public static void createDir(String dir){
		
		File directory = new File(dir);
        if (directory.exists()) {
            System.out.println("Directory already exists = " + dir);

        } else {
            System.out.println("Directory not exists, creating now");

            folSuccess = directory.mkdir();
            if (folSuccess) {
                System.out.printf("Successfully created new directory : %s%n", dir);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dir);
            }
		
        }
    }
    
    public static void createFile(String aFile) throws IOException{
		File f = new File(aFile);
        if (f.exists()) {
            System.out.println("File already exists = " + aFile);

        } else {
            System.out.println("No such file exists, creating now");
            fileSuccess = f.createNewFile();
            if (fileSuccess) {
                System.out.printf("Successfully created new file: %s%n", f);
            } else {
                System.out.printf("Failed to create new file: %s%n", f);
            }
        }
	}
    
    public static void addDataToFile(String aFile){
		final Formatter x;
		try{
			x = new Formatter(aFile);
			x.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n", "RX15 TWE","MERCEDES-BENZ","March 2015","2015","1796 cc","118 g/km","DIESEL","No","Tax not due","SILVER","M1","2-AXLE-RIGID BODY","1985kg");
			x.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", "KV65 LSO","MERCEDES-BENZ","February 2016","2016","1595 cc","119 g/km","PETROL","No","Tax not due","BLACK","M1","2-AXLE-RIGID BODY","1935kg");
			x.close();
		}
		catch (Exception e){
			System.out.println("Error adding data to file");
		}
	}
    
    public static String[] storeToArray(String line){
		int i;
		String propertyName = "";
		String rec[] = line.split(",");
		int recLength = rec.length;
		//System.out.println("Array Length = " + recLength);
		System.out.println("*******************************************");
		System.out.println("              	CAR DETAILS				   ");
		System.out.println("*******************************************");
		for(i=0; i<recLength; i++)
		{
			switch(i)
			{
				case 0: propertyName = "Car Reg Number";
				break;
				case 1: propertyName = "Vehicle Make";
				break;
				case 2: propertyName = "Date of Reg";
				break;
				case 3: propertyName = "Year of Manufacture";
				break;
				case 4: propertyName = "Cylinder Capacity";
				break;
				case 5: propertyName = "CO2 Emissions";
				break;
				case 6: propertyName = "Fuel Type";
				break;
				case 7: propertyName = "Export Marker";
				break;
				case 8: propertyName = "Vehicle Status";
				break;
				case 9: propertyName = "Colour";
				break;
				case 10: propertyName = "Vehicle Type Approval";
				break;
				case 11: propertyName = "Wheel Plan";
				break;
				case 12: propertyName = "Revenue Weight";
				break;
				default: propertyName = "Invalid value in storeToArray function";
				break;
			}
			
			System.out.println(propertyName + " = " + rec[i]);
		}
		System.out.println("-------------------------------------------");

		return rec;

	}
    
    public static void displayCarInfo(String aFile, int lineNumber){
		BufferedReader br=null;
		File f=null;
		try{
			f = new File(aFile);
			br = new BufferedReader(new java.io.FileReader(aFile));

			if(f.exists()){
				
			    String line;
			    String a[];

			    while ((line = br.readLine()) != null) {
			       //System.out.println(line);
			       a = storeToArray(line);
			    }
			    
			}else{
				System.out.println("File doesnot exist and unable to Read");
			}
		//br.close();
		}
		catch(Exception e){
			System.out.println("Error reading data from file");
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Exception thrown closing buffered reader object");
			}
		}
	}

    public static String returnArrayOfCars(String aFile,int lNum){
		BufferedReader br=null;
		File f=null;
		String returnVal="";
		try{
			f = new File(aFile);
			br = new BufferedReader(new java.io.FileReader(aFile));
			String line = null;
			int lineNumber = 0;

			if(f.exists()){
			    
			    while ((line = br.readLine()) != null){
			    	lineNumber ++;
			    	
			    	//System.out.println("Line " + lineNumber + " : " + line);

			    	if(lineNumber==lNum){
			    		returnVal = line;
			    	}
			    	
			    }			    
			}else{
				System.out.println("File do not exist");
			}
		}catch(Exception e){
			System.out.println("Exception in returnArrayOfCars method.");
			System.out.println("Configure Folder/ Files do not exist.");
			System.out.println("Please make sure to run TC_PreRequisite that generates folder structure...");
		}
		finally{
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("Exception thrown closing buffered reader object");
		}
	}
		return returnVal;

	}

    //CreateFolderStructure
    public static void createFolderStructure(String path) throws IOException{
    	createDir(path);
		createDir(path + "\\Test1");
		createFile(path + "\\Test1\\test1.txt");
		createDir(path + "\\Test2");
		createFile(path + "\\Test2\\test2.html");
		createDir(path + "\\Test3");
		createDir(path + "\\Test3\\Test31");
		createFile(path + "\\Test3\\Test31\\test3.html");
		createFile(path + "\\SomeExcellFile.xls");
		createFile(path + "\\CarVehicleRegistrationDetails.txt");
		
		addDataToFile(path + "\\CarVehicleRegistrationDetails.txt");
    }



    //Get MIME Type
    public static String getMIMEType(File file){
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        return mimeType;
    }

    //Get File Extension
    public static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    



    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public static void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            log.info(file.getName());
            log.info(file.length()+"");
            log.info(getFileExtension(file));
            log.info(getMIMEType(file));
        }
    }


    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        //byte[] data;
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                log.info("FILE PATH: " + file.getAbsolutePath());
                log.info("FILE NAME: " + file.getName());
                log.info("FILE SIZE: " + file.length());
                log.info("FILE EXTENSION: " + getFileExtension(file));
                log.info("FILE MIME TYPE: " + getMIMEType(file));
            }
            else if (file.isDirectory()){
                log.info("FOLDER PATH: " + file.getAbsolutePath());
                log.info("FOLDER NAME: " + file.getName());
            }
        }
    }



    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                log.info("FILE NAME: " + file.getName());
                log.info("FILE SIZE: " + file.length());
                log.info("FILE EXTENSION: " + getFileExtension(file));
                log.info("FILE MIME TYPE: " + getMIMEType(file));
            }

        }
    }


    /**
     * List all files from a directory and its sub directories
     * @param directoryName to be listed
     */
    public static void listFilesAndFilesSubDirectories(String directoryName){
        try{
            File directory = new File(directoryName);

            //get all the files from a directory
            File[] fList = directory.listFiles();
            for (File file : fList){
                if (file.isFile()){
                    log.info("FILE PATH: " + file.getAbsolutePath());
                    log.info("FILE NAME: " + file.getName());
                    log.info("FILE SIZE: " + file.length());
                    log.info("FILE EXTENSION: " + getFileExtension(file));
                    log.info("FILE MIME TYPE: " + getMIMEType(file));
                    log.info("**************************************************");
                } else if (file.isDirectory()){
                    log.info("FOLDER PATH: " + file.getAbsolutePath());
                    listFilesAndFilesSubDirectories(file.getAbsolutePath());
                }
            }
        }catch(Exception ex){
            log.info(ex.getMessage());
        }finally{
//            log.info("FILE/FOLDER DO NOT EXIST: "+directoryName);
//            log.info("Please Run TC_PreRequisite to generate directories..");
        }

    }

}


