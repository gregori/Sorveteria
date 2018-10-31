import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI para a classe DessertItem 
 * @author Rodrigo Gregori
 * baseado no trabalho de Frederick Livingston, Mike Romeo
 * limitação:
 * Nome: Deve ser uma String
 * Preço: Só pode conter inteiros  (ex $1 -> 100)
 * Peso: Deve ser um double
 * Preço/kg, Preço/dz, Número: Só pode conter inteiros
 */
public class CheckoutGUI extends JFrame implements ActionListener 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Checkout checkout= new Checkout();
    private final static int INFO_SIZE = 30;
    private JTextField _info = new JTextField("Número de Ítens: 0",100);

    private String bnomes[]={ "Sorvete", "Doce", "Cookies", "Sundae"};
//    private String lnomes[]={"NOme", "Preço", "Peso", "Preço/kg", "Preço/dz", "Número"};
    private String lnomes[] = 
	{
		"Nome", "Preço", "Peso", "Preço/g", "Preço/dz", "Número", "Cobertura",
		"Preço da Cobertura"
	};
    private String bnomes2[]={"Entrar", "Total"};
    private String mnomes[]={"Limpar", "Sair"};

    private JButton buttons[];
    private JLabel labels[];
    private JButton buttons2[];   
    private JTextField tfields[];
    private JMenuItem menuitems[];

    private JMenuBar bar = new JMenuBar();
    private JMenu file = new JMenu("Arquivo");
    private int selecteditem=0;

    /**
     * Declares the Labels
     */
    private void setlabels()
	{
        labels = new JLabel[lnomes.length];
        for (int i =0; i < lnomes.length; i++) 
		{
            labels[i] = new JLabel(lnomes[i]);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setEnabled(false);
        }
    }

    /**
     * Declares the Buttons
     */
    private void setbuttons()
	{
        buttons = new JButton[bnomes.length];
        for (int i=0; i< bnomes.length; i++) 
		{
            buttons[i] = new JButton( bnomes[i]);
            buttons[i].addActionListener(this);

        }
    }

    /**
     * Declares the TextField
     */
    private void settextfield()
	{
        tfields = new JTextField[lnomes.length];
        for (int i=0; i < lnomes.length; i++) 
		{
            tfields[i] = new JTextField(INFO_SIZE);
            tfields[i].setEnabled(false);
        }
    }

    /**
     * Declares the Enter and Total Buttons
     */
    private void setbutton2(){
        buttons2 = new JButton[bnomes2.length];
        for (int i =0; i < bnomes2.length; i++) 
		{
            buttons2[i] = new JButton(bnomes2[i]);
            buttons2[i].addActionListener(this);
        }
    }

    private void setmenubar()
	{
        menuitems = new JMenuItem[mnomes.length];
        for (int i=0; i <mnomes.length; i++) 
		{
            menuitems[i] = new JMenuItem(mnomes[i]);
            menuitems[i].addActionListener(this);
        }

    }

    public CheckoutGUI(Checkout checkout)
	{
        super("CheckoutGUI");
        checkout = this.checkout;
        setSize(600,300);
        setLocation(200,200);
        setlabels();
        setbuttons();
        settextfield();
        setbutton2();
        setmenubar();
        ContainerSetup();
        setVisible(true);
    }



    public void actionPerformed( ActionEvent e)
	{
        Object source = e.getSource();

        if (source == menuitems[0])  //Limpar
		{
            checkout.esvazia();
            _info.setText("Número de Ítens: 0");
            resetinfo();
            inablebuttonsAll();
            disableinfoAll();
        }
        else if (source == menuitems[1])  //Sair
		{
            System.exit(1);
        }
        else if (source == buttons[0])  // Sorvete
		{
            inableinfo(0); //nome
            inableinfo(1); //preço
            //inableinfo(5); //número
            selecteditem=0;
        }
        else if (source == buttons[1])  //Doce
		{
            inableinfo(0); //nome
            inableinfo(3); //preço/g
            inableinfo(2); //peso
            //inableinfo(5); //número
            selecteditem=1;
        }
        else if (source == buttons[2])  //Cookie
		{
            inableinfo(0); //nome
            //inableinfo(1); //preço
            inableinfo(4); //preço/dz
            inableinfo(5); //número
            selecteditem=2;
        }
        else if (source == buttons[3])  //Sundae
		{
            inableinfo(0); //nome
            inableinfo(1); //preço
            //inableinfo(4); //preço/dz
//            inableinfo(5); //numero
			inableinfo(6); // cobertura
			inableinfo(7); // custo da cobertura
            selecteditem=3;
        }
        else if (source == buttons2[0])  //Entrar
		{
            inablebuttonsAll();
            disableinfoAll();

            try 
			{
				switch (selecteditem) 
				{
					case 0: //Sorvete
						checkout.insereItem( new Sorvete(
							tfields[0].getText(), 
							Integer.parseInt(tfields[1].getText())
						));
						break;
					case 1:  //Doce
					    checkout.insereItem( new Doce(
							tfields[0].getText(),
							Double.parseDouble(tfields[2].getText()), 
							Integer.parseInt(tfields[3].getText())
						));
						break;
					case 2: //Cookies
						checkout.insereItem( new Cookie(
							tfields[0].getText(), 
							Integer.parseInt(tfields[5].getText()),
							Integer.parseInt(tfields[4].getText())
						));
						break;
					case 3: //Sundae
						checkout.insereItem( new Sundae(
							tfields[0].getText(),
//							Integer.parseInt(tfields[5].getText()),
							Integer.parseInt(tfields[1].getText()),
							tfields[6].getText(),
							Integer.parseInt(tfields[7].getText())
						));
						break;
                } // end switch

                _info.setText("Número de ítens: "+checkout.numeroDeItens());
            } // end try

            catch (Exception ref) 
			{
                _info.setText("Entrada inválida, Número de Ítens: "
					+ checkout.numeroDeItens()
				);
            }

            finally 
			{
                resetinfo();
            }
        }
        else if (source == buttons2[1])  //Total
		{
            ReceiptGUI r = new ReceiptGUI(checkout.toString());
            checkout.esvazia();
            _info.setText("Número de Ítens: 0");
            resetinfo();
            inablebuttonsAll();
            disableinfoAll();
        }

        for (int i=0; i <buttons.length; i++)  //types
		{
            if (source == buttons[i]) 
			{
                disablebuttons(i);
            }
        }
    }

    private void resetinfo()
	{
        for (int i=0; i< lnomes.length; i++) 
		{
            tfields[i].setText("");
        }
    }

    private void disablebuttons(int b)
	{
        for (int i=0; i< buttons.length; i++) 
		{
            if (b != i) buttons[i].setEnabled(false);
        }
    }

    private void inablebuttonsAll()
	{
        for (int i=0; i< buttons.length; i++) 
		{
            buttons[i].setEnabled(true);
        }
    }

    private void inableinfo(int b)
	{
        for (int i=0; i< lnomes.length; i++) 
		{
            if (b ==i) 
			{
                labels[i].setEnabled(true);
                tfields[i].setEnabled(true);
            }
        } // end for
    }

    private void disableinfoAll()
	{
        for (int i=0; i <lnomes.length; i++) 
		{
            labels[i].setEnabled(false);
            tfields[i].setEnabled(false);
        }
    }

    class ReceiptGUI 
	{

        private JTextArea text = new JTextArea();
        private JFrame receipt = new JFrame("Cupom Fiscal");
        
		public ReceiptGUI(String info)
		{
            Container p = receipt.getContentPane();
            receipt.setSize(235,600);
            p.add(new JScrollPane(text),BorderLayout.CENTER);
            text.setText(info);
            text.setEditable(false);
            text.setFont(new Font("Monospaced",Font.PLAIN,12));
            receipt.setVisible(true);
        }
    }

    private void ContainerSetup()
	{
        Container c = getContentPane();

        for (int i=0; i< mnomes.length; i++) file.add(menuitems[i]);
        bar.add(file);
        setJMenuBar(bar);

        //North Layout
        _info.setEditable(false);
        _info.setBackground(Color.white);
        c.add(_info,BorderLayout.NORTH);

        //South Layout
        JPanel spanel = new JPanel();
        for (int i=0; i < bnomes2.length; i++) spanel.add(buttons2[i]);
        c.add(spanel,BorderLayout.SOUTH);

        //Center Layout
        JPanel cpanel = new JPanel();
        cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
        cpanel.setLayout(new GridLayout(lnomes.length,2));
        for (int i=0; i < lnomes.length; i++) 
		{
            cpanel.add(labels[i]);
            cpanel.add(tfields[i]);
        }
        c.add(cpanel,BorderLayout.CENTER);

        //West Layout
        JPanel wpanel = new JPanel();
        wpanel.setLayout(new GridLayout(4,0));
        for (int i=0; i< bnomes.length; i++) wpanel.add(buttons[i]);
        c.add(wpanel,BorderLayout.WEST);
    }

    public static void main (String args[] )
	{
        CheckoutGUI app = new CheckoutGUI(new Checkout());

        app.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) { System.exit(0); } 
		});

    }
} // end CheckoutGUI









