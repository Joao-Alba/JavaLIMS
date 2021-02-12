package componentesInternos;

import javax.swing.JTextField;

public class JTextFieldMod extends JTextField{
	
	private int coordX;
	private int coordY;
	
	public JTextFieldMod(){
		
	}
	
	public JTextFieldMod(String text){
		this.setText(text);
	}
	
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	

}
