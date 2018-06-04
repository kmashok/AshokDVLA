package dvla;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  

//Spring Controller class
@RestController
public class FileController {
	
	@Autowired
	private FileService _fileService;
	
	
	@RequestMapping("/FileService/GetFiles") 
	public List<FileInfo> getFilesByType(@RequestParam(value="mimeType", defaultValue="text/csv") String mimeType) throws IOException {
		return _fileService.getFilesByType(mimeType);
	}
}