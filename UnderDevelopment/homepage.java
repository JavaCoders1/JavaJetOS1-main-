package UnderDevelopment;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class homepage extends JFrame implements ActionListener
{
    JButton sup,dealsarrow;
    JPanel npanel,dealpanel;
    JPanel intermediatePanel;
    JPanel panel;
    final Color darkgreen = new Color(0,102,0);
    homepage()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("HomePage");
        setSize(500,500);

        panel = new JPanel()
        {
                protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.setColor(Color.GRAY);
                g.fillRect(0,0,500,50);

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(Color.BLACK);

                // Specify the length and coordinates of the line
                float thickness = (float) 3.0;
                int lineLength = 350;
                int startX = 0;
                int startY = 335;
                int endX = startX + lineLength;
                int endY = startY;

                g2d.setStroke(new BasicStroke(thickness));

                // Draw the line
                g2d.drawLine(startX, startY, endX, endY);

                try {
                    BufferedImage bgimage = ImageIO.read(new File("/Users/ojaswin/Desktop/Mac/-5678/coffeebg1.jpg"));

                    int x = 0;
                    int y = 50;
                    int bgwidth = 500;
                    int bgheight = 440;

                    g.drawImage(bgimage, x, y,bgwidth, bgheight, null);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                
                g2d.setColor(darkgreen);
                g2d.fillRoundRect(-10,105,150,70,30,30);
            
            }

            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
                
        };
        panel.setLayout(null);
        
        panel.setOpaque(false);

        JLabel deals = new JLabel("Deals!");
        deals.setFont(new Font("Arial", Font.BOLD,19));
        deals.setForeground(Color.WHITE);
        deals.setBounds(10,113,280,50);
        panel.add(deals);

        dealsarrow = new JButton(">");
        dealsarrow.setBounds(75,128,50,25);
        dealsarrow.setOpaque(true);
        dealsarrow.setFont(new Font("Arial", Font.BOLD,22));
        dealsarrow.setBackground(darkgreen);
        dealsarrow.setForeground(Color.WHITE);
        dealsarrow.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        UIManager.put("Button.select",darkgreen);
        UIManager.put("Button.Focus",darkgreen.darker());
        dealsarrow.setFocusPainted(false);
        dealsarrow.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                dealsarrow.setBorder(BorderFactory.createLineBorder(Color.PINK,1));
                Timer timer = new Timer(200, new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        dealsarrow.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
                    }
                });
                timer.setRepeats(false);
                timer.start();

                deals();
                dealpanel.setVisible(true);
                if(dealpanel == null || !dealpanel.isVisible())
                {
                    dealsarrow.setVisible(true);
                }
            }
        });
        

        dealsarrow.setUI(new BasicButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(darkgreen.darker());
                g2d.fillRect(0, 0, b.getWidth(), b.getHeight());
                g2d.setColor(b.getForeground());
                super.paintButtonPressed(g, b);
            }
        });
        panel.add(dealsarrow);


        
        JLabel label = new JLabel("Welcome!");
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(210,20,120,15);

        sup = new JButton("Menu");
        sup.addActionListener(this);
        sup.setBounds(400,13,90,25);

        JLabel aboutus = new JLabel("About Us");
        Font font = new Font("Arial", Font.BOLD, 22);
        aboutus.setFont(font);
        aboutus.setBounds(10,300,120,20);
        panel.add(aboutus);

        ImageIcon oldimage = new ImageIcon("/Users/ojaswin/Desktop/Mac/-5678/coffee2.jpg");
        Image olimage = oldimage.getImage();
        int dwidth = 200;
        int dheight = 200;
        Image image = olimage.getScaledInstance(dwidth,dheight, Image.SCALE_FAST);
        ImageIcon imageicon = new ImageIcon(image);
        JLabel imagelabel = new JLabel(imageicon);
        
        
        imagelabel.setBounds(15,70,dwidth,dheight);
        
        setVisible(true);


        JTextPane textPane = new JTextPane();
        textPane.setBounds(5,332,455,150);
        textPane.setFont(new Font("Arial", Font.PLAIN, 12));
        textPane.setForeground(Color.BLACK);
        Color backgroundColor = panel.getBackground();
        textPane.setBackground(backgroundColor);
        textPane.setText("Our story begins in 1971 along the cobblestone streets of Seattle’s historic Pike Place Market. It was here where Starbucks opened its first store, offering fresh-roasted coffee beans, tea and spices from around the world for our customers to take home. Our name was inspired by the classic tale, “Moby-Dick,” evoking the seafaring tradition of the early coffee traders.");
        textPane.setFont(new Font("Arial",Font.BOLD,13));
        String content = textPane.getText();
        StyledDocument doc = textPane.getStyledDocument();
        Style style = doc.addStyle("bold", null);
        StyleConstants.setBold(style, true);
        MutableAttributeSet paragraphAttributes = new SimpleAttributeSet();
        paragraphAttributes.addAttributes(doc.getParagraphElement(0).getAttributes());
        float lineSpacing = 0.5f; // Desired line spacing factor
        StyleConstants.setLineSpacing(paragraphAttributes, lineSpacing);
        doc.setParagraphAttributes(0, doc.getLength(), paragraphAttributes, false);
        textPane.setEditable(false);
        textPane.setOpaque(false);

        panel.add(textPane);

        panel.add(sup);
        
        panel.add(label);

        add(panel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == sup)
        {
            if(npanel == null || !npanel.isVisible())
            {
                menu();
                npanel.setVisible(true);
                intermediatePanel.setVisible(true);
            }
        }
        else if(ae.getSource()==intermediatePanel.getComponent(2))
        {
            npanel.setVisible(false);
            intermediatePanel.setVisible(false);

        }
        else if(ae.getSource()==dealsarrow)
        {
            dealsarrow.setVisible(false);
        }            
    }
    private void menu()
    {
        intermediatePanel = new JPanel();
        panel.add(intermediatePanel);
        intermediatePanel.setBounds(380, 50, 120, 423);
        intermediatePanel.setBackground(Color.DARK_GRAY);
        
        // Set BevelBorder to the intermediatePanel
        intermediatePanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.black));

        npanel = new JPanel();
        panel.add(npanel);
        npanel.setLayout(null);
        npanel.setBackground(Color.darkGray);

        JButton beverages = new JButton("Beverages");
        beverages.addActionListener(this);
        beverages.setBounds(10,70,100,25);
        intermediatePanel.add(beverages);

        JButton food = new JButton("Food");
        food.addActionListener(this);
        food. setBounds(10, 110,100,25);
        intermediatePanel.add(food);

        JButton close = new JButton("Close Menu");
        close.addActionListener(this);
        close.setBounds(10, 200, 100, 25);
        intermediatePanel.add(close);

    
       
        intermediatePanel.add(npanel);
        panel.add(intermediatePanel);
        panel.add(npanel);

        intermediatePanel.setVisible(true);
        npanel.setVisible(true);

    }
    private void deals()
    {
        dealsarrow.setVisible(false);

        for (Component component : panel.getComponents()) {
            if (component != dealpanel) {
                component.setVisible(false);
            }
        }

        dealpanel = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.setColor(Color.GRAY);
                g.fillRect(0,0,500,60);

                try {
                    BufferedImage dbgimage = ImageIO.read(new File("/Users/ojaswin/Desktop/Mac/-5678/coffeebg1.jpg"));
                    int dx = 0;
                    int dy = 60;
                    int dwidth = 500;
                    int dheight = 430;

                    g.drawImage(dbgimage,dx,dy,dwidth,dheight,null);

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(darkgreen);

                g2d.fillRoundRect(20,100,150,50,30,30);

            }

        };
        panel.add(dealpanel);
        dealpanel.setBounds(0,0,500,500);
        dealpanel.setVisible(true);

        JLabel title = new JLabel("Check Out Latest Deals!");
        title.setBounds(200,30,200,50);
        title.setFont(new Font("Arial",Font.BOLD,22));
        title.setBackground(Color.GRAY);
        title.setForeground(Color.BLACK);
        dealpanel.add(title);


        
    }

public static void main(String[] args)
    {
    
        new homepage();
    
    }
    
}