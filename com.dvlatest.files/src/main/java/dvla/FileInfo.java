package dvla;

public class FileInfo {
	
	private String _name;
	private String _mimeType;
	private String _size;
	private String _extension;
	
	public String getName() {
		return this._name;
	}
	
	public String getMimeType() {
		return this._mimeType;
	}
	
	public String getSize() {
		return this._size;
	}
	
	public String getExtension() {
		return this._extension;
	}
	
	public void setName(String name) {
		this._name = name;
	}
	
	public void setMimeType(String mimeType) {
		this._mimeType = mimeType;
	}
	
	public void setSize(long size) {
		this._size = humanReadableByteCount(size);
	}
	
	public void setExtension(String extension) {
		this._extension = extension;
	}

	public static String humanReadableByteCount(long bytes) {
	    int unit = 1000;
	    String pre = "kMGTPE";

	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
