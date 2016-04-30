package coinmachine;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;

/**
 * 
 * @author Rakkan Tiasakul 5810546013
 *
 */
public class AcceptCoinObserver extends JFrame implements Observer {
	/**
	 * This is constructor.
	 */
	private JPanel contentPane;
	private JTextField textField;
	private CoinMachine coinmachine = new CoinMachine (10);
	private JLabel status ;

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 300, 200, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("#Coin: ");
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		contentPane.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);


		status = new JLabel("Accepting Coins");
		contentPane.add(status);
	}

	/**
	 * This is update method for observer. 
	 */
	public void update(Observable obj1,Object obj2){
		if (obj1 instanceof CoinMachine){
			CoinMachine test1 = (CoinMachine) obj1;
			textField.setText(Integer.toString(coinmachine.getCount()));
			if (coinmachine.getCount() == 10){
				status.setText("Machine is FULL.");
			}
		}
	}
	/**
	 * 
	 * @param coinMachine , for run UI.
	 */
	public  AcceptCoinObserver(CoinMachine coinMachine){
		this.coinmachine = coinMachine;
		this.setTitle ("Counter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
	}

}
