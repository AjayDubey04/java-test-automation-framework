package array;

 public enum Color {
   
	RED("FF0000"), GREEN("00FF00"), BLUE("0000FF");
    
    private String hexCode;
    
    private Color(String hexCode) {
        this.hexCode = hexCode;
    }
    
    public String getHexCode() {
        return hexCode;
    }
    
    public static void main(String[] args) {
    	Color myColor = Color.RED;
    	System.out.println(myColor.getHexCode()); // Outputs "FF0000"
	}
    
}

