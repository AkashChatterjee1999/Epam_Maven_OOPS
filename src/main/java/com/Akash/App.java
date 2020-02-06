package com.Akash;
import java.util.ArrayList;
import java.util.*;
/*
                                              ###########################################
                                              #   New year gift project for Epam PEP    #
                                              #    Submitted By: Akash Chatterjee       #
                                              #                                         #
                                              #                                         #
                                              #   "Let's code for a better tommorow"    #
                                              #                                         #
                                              ###########################################

*/
class Sweets{
    private float price;
    private String type;
    private float wt;
    private int qty;
    private String name;
    Sweets(float price,String type,float wt,int qty,String name){
        this.price = price;
        this.wt = wt;
        this.type = type;
        this.qty = qty;
        this.name = name;
    }
}
abstract class chocolate{
    private String name;
    private float wt;
    private int feedback;
    private float price;
    private int qty;
    chocolate(String name,float wt,int feedback,float price,int qty){
        this.price = price;
        this.wt = wt;
        this.qty = qty;
        this.name = name;
        this.feedback = feedback;
    }
    String getName(){
        return this.name;
    }
    float get_wt(){
        return this.wt;
    }
    float get_price(){
        return this.price;
    }
    float get_feedback(){
        return this.feedback;
    }
    void display_choco(){
        System.out.println("The name of the chocolate = "+this.name);
        System.out.println("Price = "+this.price+" Feedbaack = "+this.feedback+" Wt = "+this.wt+"\n");
    }
    abstract float get_choco_content();
    abstract String get_flavour();
}
class candy extends chocolate{
    private String flavour;
    candy(String name,float wt,int feedback,float price,int qty,String fl){
        super(name,wt,feedback,price,qty);
        this.flavour = fl;
    }
    @Override
    float get_choco_content() {
        return 0.0f;
    }
    @Override
    String get_flavour() {
        return this.flavour;
    }
}
class bar_choco extends chocolate{
    private float choco_content;
    bar_choco(String name,float wt,int feedback,float price,int qty,float choco){
        super(name,wt,feedback,price,qty);
        this.choco_content = choco;
    }
    @Override
    float get_choco_content() {
        return this.choco_content;
    }
    @Override
    String get_flavour() {
        return "Choco";
    }
}
class wafer_chocolate extends chocolate{
    private String flavour;
    wafer_chocolate(String name,float wt,int feedback,float price,int qty,String fl){
        super(name,wt,feedback,price,qty);
        this.flavour = fl;
    }
    @Override
    float get_choco_content() {
        return 0.0f;
    }
    @Override
    String get_flavour() {
        return this.flavour;
    }
}
class Gift{
    ArrayList<Sweets> s1;
    ArrayList<chocolate> c1;
    static float wt;
    float wt1;
    float total_choco_wt;
    float total_sweets_wt;
    int total_choco;
    int total_sweets;
    String gift_to;
    Gift(ArrayList<Sweets> s1,ArrayList<chocolate> c1,String gift_to,float s_w,float c_w,int tc,int ts){
        this.s1 = s1;
        this.c1 = c1;
        this.gift_to = gift_to;
        wt += s_w+c_w;
        this.wt1 = s_w+c_w;
        this.total_choco_wt = c_w;
        this.total_sweets_wt = s_w;
        this.total_choco = tc;
        this.total_sweets_wt = ts;
    }
    void display(){
        System.out.println("The gift recipient = "+this.gift_to);
        System.out.println("The total qty of chocolates = "+this.total_choco);
        System.out.println("The total qty of sweets = "+this.total_sweets);
        System.out.println("The total wt of the gift = "+this.wt1+" units\n");
    }
}
class sort_by_wt implements Comparator<chocolate>{
    public int compare(chocolate a,chocolate b){
        return (int)a.get_wt()-(int)b.get_wt();
    }
}
class sort_by_price implements Comparator<chocolate>{
    public int compare(chocolate a,chocolate b){
        return (int)a.get_price()-(int)b.get_price();
    }
}
class sort_by_feedback implements Comparator<chocolate>{
    public int compare(chocolate a,chocolate b){
        return (int)a.get_feedback()-(int)b.get_feedback();
    }
}
public class App {
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        ArrayList<Gift> g = new ArrayList<>();
        do{
            System.out.println("    -----Welcome to new year gift project ----");
            System.out.println("Press 1 to collect a children gift");
            System.out.println("Press 2 to sort a childrens gift by options");
            System.out.println("Press 3 to find the candies in a gift by options");
            System.out.println("Press 4 to show the total wts of all gift");
            System.out.println("Enter your choice = ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the no. of times you wanna enter = ");
                    int n = sc.nextInt(), ch = 0;
                    for (int i = 0; i < n; i++) {
                        Gift ind;
                        float s_w = 0, c_w = 0;
                        int tc = 0,ts = 0;
                        ArrayList<Sweets> s = new ArrayList<Sweets>();
                        ArrayList<chocolate> c = new ArrayList<>();
                        sc.nextLine();
                        System.out.println("Enter the name of the recipient = ");
                        String recieve = new String(sc.nextLine());
                        System.out.println("Press 1 to enter the sweets");
                        ch = sc.nextInt();
                        while (ch == 1) {
                            System.out.println("Enter the price of the sweet = ");
                            float price = sc.nextFloat();
                            System.out.println("Enter the type of sweet = ");
                            String type = sc.nextLine();
                            System.out.println("Weight of sweet = ");
                            float wt = sc.nextFloat();
                            System.out.println("Enter the no. of sweets = ");
                            int qty = sc.nextInt();
                            ts += qty;
                            System.out.println("Enter the name of sweet = ");
                            String name = sc.nextLine();
                            s_w += wt*qty;
                            s.add(new Sweets(price, type, wt, qty, name));
                            System.out.println("Press 1 to enter the sweets");
                            ch = sc.nextInt();
                        }
                        ch = 0;
                        System.out.println("Press 1 to enter the Chocolates");
                        ch = sc.nextInt();
                        while (ch == 1) {
                            System.out.println("Enter the price of the chocolate = ");
                            float price = sc.nextFloat();
                            System.out.println("Weight of choclates = ");
                            float wt = sc.nextFloat();
                            System.out.println("Enter the no. of chocolate = ");
                            int qty = sc.nextInt();
                            tc += qty;
                            c_w += wt*qty;
                            System.out.println("Enter the feedback of the chocolate = ");
                            int feed = sc.nextInt();
                            int valid = 0;
                            while (valid == 0) {
                                System.out.println("Select the name of the chocolates");
                                System.out.println("Press 1 to select Candy");
                                System.out.println("Press 2 to select bar_choco");
                                System.out.println("Press 3 to select wafer_chocolate");
                                System.out.println("Enter your choice = ");
                                int ch1 = sc.nextInt();
                                String name = "";
                                switch (ch1) {
                                    case 1:
                                        name = "candy";
                                        System.out.println("Enter the flavour of candy = ");
                                        sc.nextLine();
                                        String fl = sc.nextLine();
                                        c.add(new candy(name, wt, feed, price, qty, fl));
                                        valid = 1;
                                        break;
                                    case 2:
                                        name = "bar_choco";
                                        valid = 1;
                                        System.out.println("Enter the choco_content of bar_choco = ");
                                        float choco_content = sc.nextFloat();
                                        c.add(new bar_choco(name, wt, feed, price, qty, choco_content));
                                        break;
                                    case 3:
                                        name = "wafer_chocolate";
                                        valid = 1;
                                        System.out.println("Enter the flavour of wafer_chocolate");
                                        sc.nextLine();
                                        String fl1 = sc.nextLine();
                                        c.add(new wafer_chocolate(name, wt, feed, price, qty, fl1));
                                        break;
                                    default:
                                        System.out.println("Sorry wrong choice ,try again");
                                }
                            }//Selecting a valid name
                            System.out.println("Press 1 to enter more chocolates");
                            ch = sc.nextInt();
                        }//selecting chocos
                        ind = new Gift(s, c, recieve, s_w, c_w,tc,ts);
                        g.add(ind);
                    }//adding selecting gifts
                    break;
                case 2:
                {
                    System.out.println("Enter the name of the recipient of gift = ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int ind1 = -1;
                    for(int i=0;i<g.size();i++){
                        if(g.get(i).gift_to.equalsIgnoreCase(name)){
                            ind1 = i;
                            break;
                        }
                    }
                    if(ind1!=-1){
                            System.out.println("----Chocolates in a gift sorting----");
                            System.out.println("Press 1 to sort on the basis of wt of chocolates");
                            System.out.println("Press 2 to sort on the basis of price of chocolates in gifts");
                            System.out.println("Press 3 to sort on the basis of feedback(satisfaction) of chocolates in gifts");
                            System.out.println("Enter your choice = ");
                            ch = sc.nextInt();
                            switch (ch) {
                                case 1:{
                                    Collections.sort(g.get(ind1).c1,new sort_by_wt());
                                    for(int i=0;i<g.get(ind1).c1.size();i++)
                                        g.get(ind1).c1.get(i).display_choco();
                                }
                                break;
                                case 2:{
                                    Collections.sort(g.get(ind1).c1,new sort_by_price());
                                    for(int i=0;i<g.get(ind1).c1.size();i++)
                                        g.get(ind1).c1.get(i).display_choco();
                                }
                                break;
                                case 3:{
                                    Collections.sort(g.get(ind1).c1,new sort_by_feedback());
                                    for(int i=0;i<g.get(ind1).c1.size();i++)
                                        g.get(ind1).c1.get(i).display_choco();
                                }
                                break;
                                default:
                                    System.out.println("Sorry wrong choice");
                            }
                    }
                    else
                        System.out.println("The specified name is not found in the gift arraylist");
                }
                break;
                case 3:{
                    System.out.println("Enter the name of the recipient of gift = ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int ind1 = -1;
                    for(int i=0;i<g.size();i++){
                        if(g.get(i).gift_to.equalsIgnoreCase(name)){
                            ind1 = i;
                            break;
                        }
                    }
                    if(ind1!=-1){
                        int flag = 0;
                        System.out.println("----Find Candy in a gift----");
                        System.out.println("Press 1 to find candy on the basis of price");
                        System.out.println("Press 2 to find candy on the basis of flavour(name) = ");
                        System.out.println("Press 3 to find candy on the basis of feedback(satisfaction)");
                        System.out.println("Enter your choice = ");
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1: flag = 0;
                                    System.out.println("Enter the price of the candy = ");
                                    float price = sc.nextFloat();
                                    for(int i=0;i<g.get(ind1).c1.size();i++)
                                        if(g.get(ind1).c1.get(i).getName().equalsIgnoreCase("candy") && g.get(ind1).c1.get(i).get_price()==price){
                                            flag = 1;
                                            g.get(ind1).c1.get(i).display_choco();
                                            System.out.println("flavour = "+g.get(ind1).c1.get(i).get_flavour());
                                        }
                                    if(flag==0)
                                        System.out.println("Sorry nothing found");
                                break;
                            case 2: flag = 0;
                                    System.out.println("Enter the flavour of the candy = ");
                                    String fl = sc.nextLine();
                                    for(int i=0;i<g.get(ind1).c1.size();i++)
                                        if(g.get(ind1).c1.get(i).getName().equalsIgnoreCase("candy") && g.get(ind1).c1.get(i).get_flavour().equalsIgnoreCase(fl)){
                                            flag = 1;
                                            g.get(ind1).c1.get(i).display_choco();
                                            System.out.println("flavour = "+g.get(ind1).c1.get(i).get_flavour());
                                        }
                                    if(flag==0)
                                        System.out.println("Sorry nothing found");
                                break;
                            case 3: flag = 0;
                                System.out.println("Enter the feedback of the candy = ");
                                int feed = sc.nextInt();
                                for(int i=0;i<g.get(ind1).c1.size();i++)
                                    if(g.get(ind1).c1.get(i).getName().equalsIgnoreCase("candy") && g.get(ind1).c1.get(i).get_feedback()==feed){
                                        flag = 1;
                                        g.get(ind1).c1.get(i).display_choco();
                                        System.out.println("flavour = "+g.get(ind1).c1.get(i).get_flavour());
                                    }
                                if(flag==0)
                                    System.out.println("Sorry nothing found");
                                break;
                            default:System.out.println("incorrect choice");
                        }
                    }
                    else
                        System.out.println("Sorry the enterred name doesnot exist in our gift database");
                    }
                    break;
                case 4:
                    if(g.size()>0)
                        System.out.println("The total wt = "+Gift.wt);
                    else
                        System.out.println("Sorry no elements/gifts are present");
                    break;
                default: System.out.println("Sorry wrong choice");
            }
            System.out.println("Press 1 to continue");
            choice = sc.nextInt();
        }while(choice==1);
    }
}