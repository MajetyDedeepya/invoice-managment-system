package invoicebookingmanagment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class main {
	static String name;
	static String address;
	static String phoneNumber;
	static int customerId;
	static ArrayList<customer>customerList=new ArrayList<>();
	static int id=0;
	static int invoiceid=0;
	static HashMap<Integer,String> invoicelist=new HashMap<>();
	
	public static void addCustomer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a customer name");
		name=sc.next();
		System.out.println("enter address");
		address=sc.next();
		System.out.println("enter phonenumber");
		phoneNumber=sc.next();
		customerId=id;
		customerList.add(new customer(customerId,name,address,phoneNumber));
		System.out.println("your customer id is "+customerId);
		id=id+1;
	}
	public static void addinvoice() {
		Scanner sc=new Scanner(System.in);
		//String invoiceItem="";
		invoicelist.put(invoiceid,"");
		
		System.out.println("enter customerid");
		String customerid=sc.next();
		String invoiceItem = customerid;
		for(Entry<Integer, String> e : invoicelist.entrySet()) {
			if(e.getKey()==invoiceid) {
				 invoiceItem =invoiceItem+" "+e.getValue();
			}
		}
		addItem(invoiceid,invoiceItem);
		
		System.out.println("your invoice id is "+invoiceid);
		invoiceid+=1;
		
		
		
		
	}
	public static void addItem(int invoiceid,String invoiceItem) {
		boolean i=true;
		Scanner sc=new Scanner(System.in);
		
				
				while(i) {
						System.out.println("select the item"+"\n"+ "1.HeadPhone Rs.400"+"\n"+"2.Speaker Rs.1000"+"\n"+
						"3.SD Card Rs.500"+"\n"+"4.Battery Rs.6000");
						int ch1=sc.nextInt();
						if(ch1==1)
						invoiceItem=invoiceItem+" "+"HeadPhoneRs.400";
						else if(ch1==2)
							invoiceItem=invoiceItem+" "+"SpeakerRs.1000";
						else if(ch1==3)
							invoiceItem=invoiceItem+" "+"SDCardRs.500";
						else
							invoiceItem=invoiceItem+" "+"BatteryRs.6000";
						System.out.println("are you want to add one more item yes 1 no 0");
						int v=sc.nextInt();
						if(v==1)
							i=true;
						else
							i=false;
			
				}
				System.out.println(invoiceItem);
				invoicelist.replace(invoiceid,invoiceItem);
				//System.out.println(invoicelist.get(invoiceid));
		}
	public static void displayInvoice(Entry<Integer, String> e) {
		String items[]=e.getValue().split(" ");
		int totalPrice=0;
		int count=0;
		System.out.println("----------------------------------------------------"+"\n"+"items");
		//System.out.println(items.length);
		for(int i=2;i<items.length;i++) {
			
			String[] price=items[i].split("Rs.");
			totalPrice+=Integer.parseInt(price[1]);
			count=count+1;
			
		}
		System.out.println("total items: "+count+"\t"+"totalPrice: "+totalPrice);			
	
	
	
		// TODO Auto-generated method stub
		
	}
		
	
	
	public static void main(String args[]) {
	boolean j=true;
	
	while(j) {
	System.out.println("1.Add Customer");
	System.out.println("2.Add Invoice");
	System.out.println("3.Add Item to Invoice");
	System.out.println("4.List all Customers");
	System.out.println("5.List all invoices");
	System.out.println("6.List all invoices of a customer");
	System.out.println("7.Display an invoice");
	System.out.println("8.exit");
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		addCustomer();
		break;
	case 2:
		System.out.println("1.Existing customer");
		System.out.println("2.New customer");
		int ch=sc.nextInt();
		if(ch==1)
		addinvoice();
		
	
		else {
		addCustomer();
		addinvoice();
		}
		break;
	case 3:
		System.out.println("enter an invoice number");
		int invoice=sc.nextInt();
		for(Entry<Integer, String> e : invoicelist.entrySet()) {
			if(e.getKey()==invoice) {
				addItem(invoice,e.getValue());
			}
		}
		
		break;
	case 4:
		System.out.println("customerId"+"\t"+"customerName"+"\t"+"MobileNo"+"\t"+"address");
		for(int i=0;i<customerList.size();i++) {
		System.out.println(customerList.get(i).getCustomerId()+"\t\t"+customerList.get(i).getName()+"\t\t"+customerList.get(i).getPhoneNumber()
				+"\t\t"+customerList.get(i).getAddress());
		}
		break;
	case 5:
		for(Entry<Integer, String> e : invoicelist.entrySet()) {
			System.out.println("invoice no: "+e.getKey());
			displayInvoice(e);
		}
		System.out.println("----------------------------------------------------");	
		break;
	case 6:
		System.out.println("enter customer id");
		int custId=sc.nextInt();
		for(Entry<Integer, String> e : invoicelist.entrySet()) {
			String items[]=e.getValue().split(" ");
			
			if(Integer.parseInt(items[0])==custId) {
				displayInvoice(e);
				
			}
		}
		
		break;
	case 7:
		System.out.println("enter invoice id");
		int invoId=sc.nextInt();
		for(Entry<Integer, String> e : invoicelist.entrySet()) {
			if(e.getKey()==invoId) {
				displayInvoice(e);
				
			}
		}
		break;
	case 8:
		j=false;
		break;
	}
	}
	}
	
	
}
