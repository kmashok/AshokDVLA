package dvla;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

//Business Logic implementation class
public class FileDAO {
	
	private final static Logger _LOGGER = Logger.getLogger(FileDAO.class.getName());	
	private List<FileInfo> _files;
	private String _mimeType = null;
	private FileHandler _fileTxt;
	
	public FileDAO() {
		this._mimeType = "text/csv";
	}
	
	public List<FileInfo> getFilesByType(String mimeType) throws SecurityException, IOException {
		this._files = new LinkedList<FileInfo>();

		if (mimeType == null) {
			return null;
		}
		this._fileTxt = new FileHandler("Logging.txt");
		this._LOGGER.addHandler(this._fileTxt);
		this._LOGGER.setLevel(Level.INFO);
		
		this._mimeType = mimeType;

		Resource resource = new ClassPathResource("application.properties");
		Properties prop = PropertiesLoaderUtils.loadProperties(resource);
		this._LOGGER.info(this._mimeType);
		
		File dir = new File(prop.getProperty("uk.gov.dvla.folder"));
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(MimeToExtension.map.get(FileDAO.this._mimeType));
		    }
		});
		this._LOGGER.info(String.valueOf(files.length));
		
		if (files != null) {
			for (File file : files) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setName(file.getAbsolutePath());
				fileInfo.setMimeType(this._mimeType);
				fileInfo.setSize(file.length());
				fileInfo.setExtension(MimeToExtension.map.get(this._mimeType));
				this._files.add(fileInfo);
			}
		}		
		
		return this._files;
	}

}
