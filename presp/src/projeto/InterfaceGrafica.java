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
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private String[] colunas = { "Distribuicao de Frequencia", "Frequencia", "Frequencia Agrupada", "Ponto Medio" };

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

		JLabel labelQuartil = new JLabel("Quartis");
		labelQuartil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelQuartil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelQuartil.setBounds(36, 288, 46, 14);
		panel.add(labelQuartil);

		JLabel labelDecil = new JLabel("Decis");
		labelDecil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDecil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDecil.setBounds(36, 313, 46, 14);
		panel.add(labelDecil);

		JLabel labelPercentil = new JLabel("Percentis");
		labelPercentil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPercentil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPercentil.setBounds(20, 338, 62, 14);
		panel.add(labelPercentil);

		JTextArea textoQuartis = new JTextArea();
		textoQuartis.setBounds(92, 288, 56, 14);
		panel.add(textoQuartis);

		JTextArea textoDecis = new JTextArea();
		textoDecis.setBounds(92, 313, 56, 14);
		panel.add(textoDecis);

		JTextArea textoPercentis = new JTextArea();
		textoPercentis.setBounds(92, 338, 56, 14);
		panel.add(textoPercentis);

		JButton separatriz = new JButton("Calcular"); // Quartis
		separatriz.setFont(new Font("Tahoma", Font.PLAIN, 10));
		separatriz.setBounds(168, 306, 90, 31);
		panel.add(separatriz);
		
		JTextArea textoSeparatriz = new JTextArea();
		textoSeparatriz.setBounds(277, 284, 105, 73);
		textoSeparatriz.setEditable(false);
		textoSeparatriz.setVisible(false);
		panel.add(textoSeparatriz);
		
		separatriz.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (e.getSource() == separatriz) {
					String texto = "";
					String quartil = textoQuartis.getText();
					String decil = textoDecis.getText();
					String percentil = textoPercentis.getText();
					
					String quartilTexto, decilTexto, percentilTexto;
					quartilTexto = "Quartil: nao selecionado";
					decilTexto = "Decil: nao selecionado";
					percentilTexto = "Percentil: nao selecionado";
					
					if (quartil.length() != 0 ) {
						quartilTexto = "Quartil: " + (String) da.calcularSeparatriz(4, Integer.parseInt(quartil));
					}
					if (decil.length() != 0) {
						decilTexto = "Decil: " + (String) da.calcularSeparatriz(10, Integer.parseInt(decil));
					}
					if (percentil.length() != 0) {
						percentilTexto = "Percentil: " + (String) da.calcularSeparatriz(100, Integer.parseInt(quartil));
					}
					
					texto = quartilTexto +"\n" + decilTexto + "\n" + percentilTexto;
					
					textoSeparatriz.setText(texto);
					textoSeparatriz.setVisible(true);
				}

			}
		});

	}
}
