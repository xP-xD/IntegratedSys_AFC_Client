package presentation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.SLogIn;
import service.SPersonalInfo;
import valueObject.VLogIn;
import valueObject.VPersonalInfo;


public class LLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private ActionHandler actionHandler;
	
	private SLogIn sLogIn;
	private SPersonalInfo sPersonalInfo;
	
	private LMainFrame lMainFrame;
	private LSignUpDialog signUpDialog;
	
	private JPanel topPanel;
	private JLabel idLabel;
	private JTextField idText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	
	private JPanel bottomPanel;
	private JButton signUpButton;
	private JButton okButton;
	private JButton cancelButton;
	

	public LLoginDialog() {
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

		//actionHandler
		this.actionHandler = new ActionHandler();
		
		//control
		this.sLogIn = new SLogIn();
		this.sPersonalInfo = new SPersonalInfo();
		
		//component
		this.lMainFrame = new LMainFrame();
		this.signUpDialog = new LSignUpDialog(actionHandler);
		
		//topPanel
		this.topPanel = new JPanel();
		this.topPanel.setLayout(new GridLayout(2,2));
		
		this.idLabel = new JLabel("ID");
		this.topPanel.add(idLabel);
		this.idText = new JTextField(10);
		this.topPanel.add(idText);

		this.passwordLabel = new JLabel("password");
		this.topPanel.add(passwordLabel);
		this.passwordText = new JTextField(10);
		this.topPanel.add(passwordText);
		
		this.add(topPanel);
		
		//bottomPanel
		this.bottomPanel = new JPanel();
		this.bottomPanel.setLayout(new GridLayout(1,3));
		
		this.signUpButton = new JButton("Sign Up");
		this.signUpButton.addActionListener(actionHandler);
		this.signUpButton.setActionCommand(this.signUpButton.getText());
		this.bottomPanel.add(signUpButton);
		
		this.okButton = new JButton("Ok");
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand(this.okButton.getText());
		this.bottomPanel.add(okButton);
		
		this.cancelButton = new JButton("Cancel");
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand(this.cancelButton.getText());
		this.bottomPanel.add(cancelButton);
		
		this.add(bottomPanel);

	}
	
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	public void dispose() {
		 this.setVisible(false);
		 this.idText.setText("");
		 this.passwordText.setText("");
	}
	
	public void appear() {
		 this.setVisible(true);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Ok")) {
				VLogIn vLogIn = new VLogIn();
				vLogIn.setId(idText.getText());
				vLogIn.setPassword(passwordText.getText());
				
				VPersonalInfo vPersonalInfo = sLogIn.validate(vLogIn);
				if(vPersonalInfo!=null) {
					dispose();
					lMainFrame.initialize(vPersonalInfo);
					lMainFrame.setVisible(true);
				}
			}else if(e.getActionCommand().equals("Cancel")) {
				System.exit(0);
			}else if(e.getActionCommand().equals("Sign Up")) {
				dispose();
				signUpDialog.setVisible(true);
			}else if(e.getActionCommand().equals("Register")) {
				
				VPersonalInfo vPersonalInfo = signUpDialog.getInputData();
				if(vPersonalInfo!=null) {
					
					appear();
					showMessage(sPersonalInfo.write(vPersonalInfo));
				}
				
			}
			
			
		}

	}
	
}
