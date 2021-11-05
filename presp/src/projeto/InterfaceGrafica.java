package projeto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.TextArea;
import java.util.Objects;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JDesktopPane;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Label;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class InterfaceGrafica {
	private DadosAgrupados da = new DadosAgrupados();
	private Object[][] dados = da.converterLista(da.getTabela());
    private String[] colunas = {"Distribuicao de Frequencia", "Frequencia", "Frequencia Agrupada", "Ponto Medio"};
    
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("PresP");
		frame.setBounds(100, 100, 925, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("logo.png")));
        frame.setIconImage(img.getImage());
		
		JLabel lblNewLabel = new JLabel("Trabalho de Estat\u00EDstica");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 39, 620, 134);
		panel.add(scrollPane);
		
		table = new JTable(dados, colunas);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quartis");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(36, 288, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Decis");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(36, 313, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Percentis");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setBounds(20, 338, 62, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(92, 288, 31, 14);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(92, 313, 31, 14);
		panel.add(textArea_1);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(92, 338, 31, 14);
		panel.add(textArea_1_1);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(133, 286, 74, 19);
		panel.add(btnNewButton);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEnviar.setBounds(133, 311, 74, 19);
		panel.add(btnEnviar);
		
		JButton btnNewButton_1_1 = new JButton("Enviar");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(133, 336, 74, 19);
		panel.add(btnNewButton_1_1);
	}
}
