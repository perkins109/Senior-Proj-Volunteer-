package location;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.IOException;


import javax.swing.JOptionPane;

public class WhereDoIPutMyHtmlFiles 
{

	public static void main(String[] args) throws IOException 
	{
		Frame frame = new Frame();
		JOptionPane.showMessageDialog(frame, "Your file location is : " +  System.getProperty("java.io.tmpdir"));
		

		
		Desktop.getDesktop().open(new File(System.getProperty("java.io.tmpdir")));
	}

}
