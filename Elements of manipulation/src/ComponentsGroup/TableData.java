package ComponentsGroup;

public class TableData {
	private String firstCol;
    private String lastCol;
    
    public TableData () {
    	this.firstCol = "";
    	this.lastCol = "";
    }
    
    public String getFirstCol() {
    	return firstCol;
    }
    
    public void setFirstCol() {
    	this.firstCol = firstCol;
    }
    
    public String getLastCol() {
    	return lastCol;
    }
    
    public void setLastCol() {
    	this.lastCol = lastCol;
    }
    
    public TableData (String firstCol) {
    	this.firstCol = firstCol;
    }
}
