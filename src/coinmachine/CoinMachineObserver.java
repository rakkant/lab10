package coinmachine;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class CoinMachineObserver extends JFrame implements Observer  {

	private JButton onebaht;
	private JButton fivebaht;
	private JButton tenbaht;
	private JLabel balance;
	private JLabel status ;
	private JLabel insertMoney;
	private JPanel panel1;
	private JProgressBar progressBar_1;
	private JLabel balanceNumber;
	private JPanel panel_2;
	private CoinMachine coinmachine = new CoinMachine (10);
	
	public void initComponent() {
		ActionListener coin = new selectedButton();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		this.setSize(320, 250);
		setResizable(false);

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		balance = new JLabel("Balance : ");
		panel.add(balance);

		balanceNumber = new JLabel("0");
		panel.add(balanceNumber);

		status = new JLabel("Status: ");
		panel.add(status);

		progressBar_1 = new JProgressBar(0,coinmachine.getCapacity());
		panel.add(progressBar_1);

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		panel_2.setBorder(BorderFactory.createTitledBorder("Insert Money"));

		
		onebaht = new JButton();
		onebaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/1baht.png")));
		onebaht.addActionListener(new selectedButton());
		panel_2.add(onebaht);

		fivebaht = new JButton();
		fivebaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/5baht.png")));
		fivebaht.addActionListener(new selectedButton());
		panel_2.add(fivebaht);

		tenbaht = new JButton();
		tenbaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/10baht.png")));
		tenbaht.addActionListener(new selectedButton());
		panel_2.add(tenbaht);


	}
	public void update(Observable obj1,Object obj2){
		if (obj1 instanceof CoinMachine){
			CoinMachine test1 = (CoinMachine) obj1;
			System.out.println("The balance is : " + test1.getBalance());
			progressBar_1.setValue(test1.getCount());
			balanceNumber.setText(Integer.toString(coinmachine.getBalance()));
		}
	}


	class selectedButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (onebaht.isFocusOwner()){
				coinmachine.insert(new Coin(1));
			}else if (fivebaht.isFocusOwner()){
				coinmachine.insert(new Coin(5));
			}else if (tenbaht.isFocusOwner()){
				coinmachine.insert(new Coin(10));
			}
	
		}
	}

	public  CoinMachineObserver(CoinMachine coinMachine){
		this.coinmachine = coinMachine;
		this.setTitle ("Coin Machine");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
	}

	
}
