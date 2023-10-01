import java.awt.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;


public class MenuBar {
	
	JLabel dateLabel;
	JFrame frame;
	JPanel panel;

	public static void main(String[] args) {
		MenuBar menuBar = new MenuBar();
	}
	
	MenuBar() {
		frame = new JFrame();
		frame.setTitle("Menu Bar");
		frame.setVisible(true); 
		
		Border padding = BorderFactory.createEmptyBorder(100,100,100,100);
		
		panel = new JPanel(new GridLayout(1, 1));
		frame.add(panel);
		panel.setBorder(padding);
		
		dateLabel = new JLabel("");
		panel.add(dateLabel);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem dateMenuItem = new JMenuItem("Set Date");
		dateMenuItem.addActionListener(e -> this.setDate());
		fileMenu.add(dateMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save Date");
		saveMenuItem.addActionListener(e -> this.saveDateLabelText());
		fileMenu.add(saveMenuItem);
		
		JMenuItem changeBackgroundColor = new JMenuItem("Cange color");
		changeBackgroundColor.addActionListener(e -> this.setRandomBackgroundColor());
		fileMenu.add(changeBackgroundColor);
		
		fileMenu.addSeparator();
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(e ->  System.exit(0));
		fileMenu.add(exitMenuItem);
		
		frame.setJMenuBar(menuBar);
		frame.pack(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setRandomBackgroundColor();
		
	
	}
	
	private void setDate() {
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date);  
		dateLabel.setText(strDate);
		frame.pack();
	}
	
	private void saveDateLabelText() {
		String textToSave = dateLabel.getText();
		try(PrintWriter out = new PrintWriter("log.txt")){
		out.println(textToSave);
		out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private void setRandomBackgroundColor() {
		boolean isLightGreen = Math.random() > 0.5;
		int randomValue = (int)(Math.random() * 255);

	    Color randomColorGreen = 
	    	isLightGreen ? new Color(randomValue, 255, randomValue) : new Color(0, randomValue, 0);
		panel.setBackground(randomColorGreen);
		
	}
}
