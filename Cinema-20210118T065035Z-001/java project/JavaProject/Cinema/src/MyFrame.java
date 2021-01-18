import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	int id = -1;
	//��������� �� ��� ����� � 5 ���� 
	JTabbedPane tabbedPane=new JTabbedPane();
	JPanel tab1=new JPanel();
	JPanel tab2=new JPanel();
	JPanel tab3=new JPanel();
	JPanel tab4=new JPanel();

	
	//sql commands
	PreparedStatement state=null;
    Connection conn=null;
    
    //������� �� ������������� �� ������� �� ������ �����
    //JTable([n],[r][n]) ....... [n]����� �� ��������� .... [r][n]������������ �� �����
    JTable table=new JTable();
    JTable table2=new JTable();
    JTable table3=new JTable();
    JTable table4=new JTable();

    
    //���������� �� ��������� ������ ������ ������ �������
    JScrollPane scroller=new JScrollPane(table);
    JScrollPane scroller2=new JScrollPane(table2);
    JScrollPane scroller3=new JScrollPane(table3);
    JScrollPane scroller4=new JScrollPane(table4);

    
	//��������� �������� �� ������������ �� ����������� ��������
    //�� ������� 1
	JPanel upPanel=new JPanel();
	JPanel midPanel=new JPanel();
	JPanel downPanel=new JPanel();
	//�� ������� 2
	JPanel upPanel2=new JPanel();
	JPanel midPanel2=new JPanel();
	JPanel downPanel2=new JPanel();
	//�� ������� 3
	JPanel upPanel3=new JPanel();
	JPanel midPanel3=new JPanel();
	JPanel downPanel3=new JPanel();	
	//�� ������� 4
	JPanel upPanel4=new JPanel();
	JPanel midPanel4=new JPanel();
	JPanel downPanel4=new JPanel();
	
		
	//.............................................................................................................................
	//��������� ������� �� ������� 1
	JLabel fnameLabel=new JLabel("���:");
	JLabel lnameLabel=new JLabel("�������:");
	JLabel addressLabel=new JLabel("�����:");
	//..............................................................................................................................
	//��������� �������� ������ �� ������� 1
	JTextField fnameTField=new JTextField();
	JTextField lnameTField=new JTextField();
	JTextField addressTField=new JTextField();
	//...............................................................................................................................
	//�������� ������ �� add edit  �� ������� 1
	JButton addBtn=new JButton("��������");
	JButton updBtn=new JButton("�����������");
	JButton delBtn=new JButton("���������");
	
	
	//.............................................................................................................................
    //��������� ������� �� ������� 2
	JLabel titleLabel=new JLabel("�������� �� �����:");
	JLabel createdLabel=new JLabel("���� �� ���������:");
	//..............................................................................................................................
    //��������� �������� ������ �� ������� 2
	JTextField titleTField=new JTextField();	
	JTextField createdTField = new JTextField();
	//..............................................................................................................................
	//�������� ������ �� add edit  �� ������� 2
	JButton addBtn2=new JButton("��������");
	JButton updBtn2=new JButton("�����������");
	JButton delBtn2=new JButton("���������");
		
	
	//.............................................................................................................................
    //��������� ������� �� ������� 3
	JLabel dateOfRentLabel=new JLabel("���� �� ����������� � ���� ������:");
	JLabel priceLabel=new JLabel("����� �� �����:");
	//..............................................................................................................................
    //��������� �������� ������ �� ������� 3
	JTextField dateOfRentTField=new JTextField();	
	JTextField priceTField = new JTextField();
	//..............................................................................................................................
	//�������� ������ �� add edit delete �� ������� 3
	JButton addBtn3=new JButton("��������");
	JButton updBtn3=new JButton("�����������");
	JButton delBtn3=new JButton("���������");
		
  public MyFrame() {
	  
	// �������� ������������ ������ � ������� �����
    this.add(tabbedPane);
    tabbedPane.add(tab1,"Clients");
	tabbedPane.add(tab2,"Media");
	tabbedPane.add(tab3,"Clients_Media");
	tabbedPane.add(tab4,"SearchQuery");

	
	//������ �� ��������� �� ���������� �� �� ������
	this.setVisible(true);
	//������ �������� �� ��������� ��� ��������� �������� � �������
	this.setSize(600, 500);
	//������ �� ���������� �� �������� ���� ������� �� ������������ �
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//������ � ������� ��������������� �� ����������
	//�������1+�����1
	tab1.setLayout(new GridLayout(3,1));	
	tab1.add(upPanel);
	tab1.add(midPanel);
	tab1.add(downPanel);
	
	upPanel.setLayout(new GridLayout(3,2));  
	upPanel.add(fnameLabel); //������ +
	upPanel.add(fnameTField);//�������� ���� �� ������ �� 1 ��� 
	upPanel.add(lnameLabel); 
	upPanel.add(lnameTField);//2�� ��� 
	upPanel.add(addressLabel);
    upPanel.add(addressTField);//3�� ���  
    
    addBtn.addActionListener(new AddAction1());
    midPanel.add(addBtn);
    updBtn.addActionListener(new EditAction1());
	midPanel.add(updBtn);
	delBtn.addActionListener(new DeleteAction1());
	midPanel.add(delBtn);
	table.addMouseListener(new TableMouseClick1());
  
	//�������2+�����2
	tab2.setLayout(new GridLayout(3,1));	
	tab2.add(upPanel2);
	tab2.add(midPanel2);
	tab2.add(downPanel2);
	
    upPanel2.setLayout(new GridLayout(3,2)); 
    upPanel2.add(titleLabel);
    upPanel2.add(titleTField);//1�� ���
    upPanel2.add(createdLabel);
    upPanel2.add(createdTField);//2�� ���

	addBtn2.addActionListener(new AddAction2());
	midPanel2.add(addBtn2);
	updBtn2.addActionListener(new EditAction2());
	midPanel2.add(updBtn2);
	delBtn2.addActionListener(new DeleteAction2());
	midPanel2.add(delBtn2);
	table2.addMouseListener(new TableMouseClick2());
	
	//�������3+�����3
		tab3.setLayout(new GridLayout(3,1));	
		tab3.add(upPanel3);
		tab3.add(midPanel3);
		tab3.add(downPanel3);
		
	    upPanel3.setLayout(new GridLayout(3,2)); 
	    upPanel3.add(dateOfRentLabel);
	    upPanel3.add(dateOfRentTField);//1�� ���
	    upPanel3.add(priceLabel);
	    upPanel3.add(priceTField);//2�� ���

		addBtn3.addActionListener(new AddAction3());
		midPanel3.add(addBtn3);
		updBtn3.addActionListener(new EditAction3());
		midPanel3.add(updBtn3);
		delBtn3.addActionListener(new DeleteAction3());
		midPanel3.add(delBtn3);
		table3.addMouseListener(new TableMouseClick3());
		
	//�������4+�����4
	tab4.setLayout(new GridLayout(3,1));	
	tab4.add(upPanel4);
	tab4.add(midPanel4);
	tab4.add(downPanel4);
	

	//�������� �� ��������� ��� ����������
	table.setModel(DBConnector.selectAll("clients"));
	table2.setModel(DBConnector.selectAll("media"));
	table3.setModel(DBConnector.selectAll("clients_media"));
	
	scroller.setPreferredSize(new Dimension(600,200)); 
	downPanel.add(scroller);       	       
	scroller2.setPreferredSize(new Dimension(600,200)); 
	downPanel2.add(scroller2);
	scroller3.setPreferredSize(new Dimension(600,200)); 
	downPanel3.add(scroller3);
	scroller4.setPreferredSize(new Dimension(600,200)); 
	downPanel4.add(scroller4);

}
  
  
  
  //............................................................................................
  //add edit delete �� ������� 1
  
 //����� �� ��������
  class AddAction1 implements ActionListener{
	  
	@Override
	public void actionPerformed(ActionEvent e) {
	   //������ �� �������� ������ ������ ������
	   String fname=fnameTField.getText();
	   String lname=lnameTField.getText();
	   String adrname=addressTField.getText();

	
	    //�������� �� ����� � ������� clients � ������ �����
	   String sql="insert into CLIENTS values(null,?,?,?);";
	   conn=DBConnector.getConnection();
			try {
			     state=conn.prepareStatement(sql);
				 state.setString(1,fname);
				 state.setString(2,lname);
				 state.setString(3,adrname);	
				 state.execute();
				 
				 table.setModel(DBConnector.selectAll("clients"));
				 clearForm();
			} catch (SQLException e1) {
			  e1.printStackTrace();
			}
	
	      }
	 //���������� �� �������
	  public void clearForm()
	  {
		fnameTField.setText("");
		lnameTField.setText("");
		addressTField.setText("");
	  }	
	  

   }

  //����� �� �����������
  class EditAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		   //������ �� ����������� ������ ������ ������
	       
		   String fname=fnameTField.getText();
		   String lname=lnameTField.getText();
		   String adrname=addressTField.getText();
		 
		  // String sql = "UPDATE CLIENTS SET FNAME ='" + fname + "',LNAME='" + lname + "',ADDRESS='" + adrname + "' WHERE CLIENT_ID='" + id + "'";		   
		
		 try { 
			 DBConnector.updateRow("clients", id);
		     String sql="update CLIENTS set  fname='"+fname+"',lname='"+lname+"',address='"+adrname+"' where CLIENT_ID='"+null+"'" ;
		    PreparedStatement  pst=conn.prepareStatement(sql);
		  
		   pst.execute();
		   pst.close();
		   
		 } catch (SQLException e1) {
		   e1.printStackTrace();
		 }  
		       }
		
		 } 

  //����� ��� ����� ��� ��������� �� ����� �� ������� �� ��������� ����������� �� �����
  class TableMouseClick1 extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//.........................................................................
			//����������� �� �������1
			int row = table.getSelectedRow();
			
			Object value = table.getValueAt(row, 0);
			id = Integer.parseInt(value.toString());
			
			if(e.getClickCount() > 1) {
				fnameTField.setText(table.getValueAt(row, 1).toString());
				lnameTField.setText(table.getValueAt(row, 2).toString());
				addressTField.setText(table.getValueAt(row, 3).toString());
			}
			if(SwingUtilities.isRightMouseButton(e)) {
				MyPopUpMenu menu = new MyPopUpMenu(id);
				menu.show(table, e.getX(), e.getY());
			}
			
		}
		
	}
  class DeleteAction1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DBConnector.deleteRow("clients", id);
			table.setModel(DBConnector.selectAll("clients"));
			id = -1;			
		}
		
	}
  
   //.............................................................................................................
  //add edit delete �� ������� 2
  //����� �� �������� �� ����������
  class AddAction2 implements ActionListener{
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			 //������ �� �������� ������ ������ ������
			String title=titleTField.getText();
			String created=createdTField.getText();
			//�������� �� ����� � ������� media � ������ �����
			String sql2="insert into MEDIA values(null,?,?);";
			   conn=DBConnector.getConnection();
					try {
					     state=conn.prepareStatement(sql2);
						 state.setString(1,title);
						 state.setString(2,created);
						 state.execute();
						 
						 table2.setModel(DBConnector.selectAll("media"));
						 clearForm2();
					} catch (SQLException e1) {
					  e1.printStackTrace();
					}
		}
		 public void clearForm2()
		  {
			titleTField.setText("");
			createdTField.setText("");		
		  }	
	}

  //����� �� ����������� �� ����������
  class EditAction2 implements ActionListener{	  
		@Override
		public void actionPerformed(ActionEvent e) {
		   //������ �� ����������� ������ ������ ������
			String title=titleTField.getText();
			String created=createdTField.getText();
			//����������� �� ����� � ������� media � ������ �����
			String sql2="update  MEDIA set values(null,?,?);";
			   conn=DBConnector.getConnection();
					try {
					     state=conn.prepareStatement(sql2);
						 state.setString(1,title);
						 state.setString(2,created);
						 state.execute();
						 
						 DBConnector.updateRow2("media", id);
						 table2.setModel(DBConnector.selectAll("clients"));
						
					} catch (SQLException e1) {
					  e1.printStackTrace();
					}
		}
  }
 
//����� ��� ����� ��� ��������� �� ����� �� ������� �� ��������� ����������� �� �����
  class TableMouseClick2 extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//����������� �� ������� 2
			int row2 = table2.getSelectedRow();
			Object value2 = table2.getValueAt(row2, 0);
			id = Integer.parseInt(value2.toString());
			
			if(e.getClickCount() > 1) {
				dateOfRentTField.setText(table2.getValueAt(row2, 1).toString());
				priceTField.setText(table2.getValueAt(row2, 2).toString());
				
			}
			
			if(SwingUtilities.isRightMouseButton(e)) {
				MyPopUpMenu menu = new MyPopUpMenu(id);
				menu.show(table2, e.getX(), e.getY());
			}
		}
		
	}
  //����� �� ��������� �� ����������
  class DeleteAction2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DBConnector.deleteRow2("media", id);
			table2.setModel(DBConnector.selectAll("media"));
			id = -1;			
		}
		
	}
 //.............................................................................................................
     //add edit delete �� ������� 3
 
      //����� �� �������� �� ����������
    class AddAction3 implements ActionListener{
	  
		@Override
		public void actionPerformed(ActionEvent e) {
		   //������ �� �������� ������ ������ ������
			 String dateOfRent=dateOfRentTField.getText();
	         String price=priceTField.getText();
	       //�������� �� ����� � ������� clients_media � ������ �����
				String sql3="insert into CLIENTS_MEDIA values(null,?,?);";
				   conn=DBConnector.getConnection();
						try {
						     state=conn.prepareStatement(sql3);
							 state.setString(1,dateOfRent);
							 state.setString(2,price);
							 state.execute();
							 
							 table3.setModel(DBConnector.selectAll("clients_media"));
							 clearForm3();
						} catch (SQLException e1) {
						  e1.printStackTrace();
						}
						
		}
		//����� �� ���������� �� ������� ���� ��������
		 public void clearForm3()
		  {
			dateOfRentTField.setText("");
			priceTField.setText("");		
		  }	
  }
   
    //����� �� ����������� �� ����������
  class EditAction3 implements ActionListener{	  
		@Override
		public void actionPerformed(ActionEvent e) {
		   //������ �� ����������� ������ ������ ������
			 String dateOfRent=dateOfRentTField.getText();
	         String price=priceTField.getText();
			//����������� �� ����� � ������� clients_media � ������ �����
			String sql3="update CLIENTS_MEDIA set values(null,?,?);";
			   conn=DBConnector.getConnection();
					try {
					     state=conn.prepareStatement(sql3);
						 state.setString(1,dateOfRent);
						 state.setString(2,price);
						 state.execute();
						 
						 DBConnector.updateRow3("clients_media", id);
						 table3.setModel(DBConnector.selectAll("clients"));
						
					} catch (SQLException e1) {
					  e1.printStackTrace();
					}
		}
  }
 
  //����� ��� ����� ��� ��������� �� ����� �� ������� �� ��������� ��������� ��� ����������� �� �����
  class TableMouseClick3 extends MouseAdapter{
		//����������� �� �������3
		@Override
		public void mouseClicked(MouseEvent e) {
			int row3 = table3.getSelectedRow();
			Object value3 = table3.getValueAt(row3, 0);
			id = Integer.parseInt(value3.toString());
			
			if(e.getClickCount() > 1) {
				dateOfRentTField.setText(table3.getValueAt(row3, 1).toString());
				priceTField.setText(table3.getValueAt(row3, 2).toString());				
			}
			if(SwingUtilities.isRightMouseButton(e)) {
				MyPopUpMenu menu = new MyPopUpMenu(id);
				menu.show(table3, e.getX(), e.getY());
			}
			
		}
	}
  
  
    //����� �� ��������� �� ����� �� ��������� ����� ������ � ������� ��� �������
   class DeleteAction3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			DBConnector.deleteRow3("clients_media", id);
			table3.setModel(DBConnector.selectAll("clients_media"));
			id = -1;			
		}
	}
	
}

