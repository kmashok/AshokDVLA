package dvla;

import java.util.HashMap;

public class MimeToExtension {
	public static HashMap<String, String> map = new HashMap<String, String>() {{
		put("text/csv", ".csv");
		put("application/vnd.ms-excel", ".xls");
		put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");
	}};
}
