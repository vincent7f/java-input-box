package shenheng;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class InputBox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8406796509091822666L;
	private JTextArea textArea;

	public InputBox() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		InputBox thisObj = this;
		
		JPanel panel=new JPanel();
		this.add(panel);
		
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		JPanel buttonPanel = new JPanel();
		panel.add(buttonPanel);
		
		JCheckBox checkBox = new JCheckBox("autocopy");
		buttonPanel.add(checkBox);
		checkBox.setSelected(true);
		
		JButton copyButton = new JButton("Copy to Clipboard");
		buttonPanel.add(copyButton);

		JButton clearButton = new JButton("Clear text");
		buttonPanel.add(clearButton);
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		copyButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				thisObj.copyToClipboard();
			}
		});
		
		clearButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// copy content to clipboard if autocopy is checked when user switch to other app.
		this.addWindowFocusListener( new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				if (checkBox.isSelected()) {
					thisObj.copyToClipboard();
				}
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		} );
	}
	
	protected void copyToClipboard() {
		StringSelection stringSelection = new StringSelection(this.textArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	public static void main(String[] args) {
		InputBox frame = new InputBox();
		frame.setSize(500, 300);		
		frame.setVisible(true);
	}

}
