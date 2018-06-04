package dvla;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

//Spring Service layer class
@Service
public class FileService {
	FileDAO fileDAO = new FileDAO();
	
	public List<FileInfo> getFilesByType(String mimeType) throws IOException {
		return fileDAO.getFilesByType(mimeType);
	}
}
