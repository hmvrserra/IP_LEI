class TestClass {
	
	@SuppressWarnings("unused")
	static void test(){
		String nullString = null;
		String emptyString = "";
		String s1 = "Olá Mundo";
		String s4 = String.valueOf(42);
		String s5 = String.valueOf('z');
		String s6 = String.valueOf(3.14);
		String s7 = String.valueOf(true);
		
		int length = s1.length(); 
		char c = s1.charAt (2);
	

		char [] word = s1.toCharArray();
		String s3 = new String (word);
		
		ColorImage img = new ColorImage(200, 150);
		img.drawText(30, 50, "And the answer is ..", 20, new Color(255,255,255)); 
		img.drawCenteredText(100, 100, s4, 20, new Color(255,255,255));
		
		return;
	}
	
	
}