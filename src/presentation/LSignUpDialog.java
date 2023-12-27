package presentation;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import valueObject.VPersonalInfo;


public class LSignUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel topPanel;
	private JLabel idLabel;
	private JTextField idText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JLabel nameLabel;
	private JTextField nameText;
	
	private JPanel bottomPanel;
	private JButton signUpButton;
	private JButton cancelButton;
	
	public LSignUpDialog(LLoginDialog.ActionHandler actionHandler) {
		// attributes
		this.setLayout(new GridLayout(2,1));
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//topPanel
		this.topPanel = new JPanel();
		this.topPanel.setLayout(new GridLayout(3,2));
		
		this.idLabel = new JLabel("ID");
		this.topPanel.add(idLabel);
		this.idText = new JTextField(10);
		this.topPanel.add(idText);

		this.passwordLabel = new JLabel("password");
		this.topPanel.add(passwordLabel);
		this.passwordText = new JTextField(10);
		this.topPanel.add(passwordText);
		
		this.nameLabel = new JLabel("name");
		this.topPanel.add(nameLabel);
		this.nameText = new JTextField(10);
		this.topPanel.add(nameText);
		
		this.add(topPanel);
		
		//bottomPanel
		this.bottomPanel = new JPanel();
		this.bottomPanel.setLayout(new GridLayout(1,2));
		
		this.signUpButton = new JButton("Register");
		this.signUpButton.addActionListener(actionHandler);
		this.signUpButton.setActionCommand(this.signUpButton.getText());
		this.bottomPanel.add(signUpButton);
		
		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		this.bottomPanel.add(cancelButton);
		
		this.add(bottomPanel);
	}
	
	public void dispose() {
		 this.setVisible(false);
		 this.idText.setText("");
		 this.passwordText.setText("");
		 this.nameText.setText("");
	}
	
	public void appear() {
		 this.setVisible(true);
	}

	public VPersonalInfo getInputData() {
//		System.out.println(idText.getText());
		if(!idText.getText().isEmpty() && !passwordText.getText().isEmpty() && !nameText.getText().isEmpty()) {
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			vPersonalInfo.setId(idText.getText());
			vPersonalInfo.setPassword(passwordText.getText());
			vPersonalInfo.setName(nameText.getText());
			this.dispose();
			
			return vPersonalInfo;
		}else {
			JOptionPane.showMessageDialog(this, "모든 정보를 적어주세요.");
		}
		
		return null;
	}
	
}
