import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
  String name;
  String serialNumber;
  double value;

  public void Initializer(String name_arg, String SN_arg, double price){
    name = name_arg;
    serialNumber = SN_arg;
    value = price;
  }
  public void Print(){
    System.out.println(name + "," + serialNumber + "," +  value);
  }
  public String getSN(){
    return serialNumber;
  }
}

class Main {
	public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  ArrayList<Inventory> myInventory = new ArrayList<>();
  int selection;
    
  do{
    System.out.println("\nPress 1 to add an item");
    System.out.println("Press 2 to delete an item");
    System.out.println("Press 3 to update an item");
    System.out.println("Press 4 to show all the items");
    System.out.println("Press 5 to exit the program");
    selection = in.nextInt();
    in.nextLine();
    String name, serialNumber;
    int price;
    Inventory myItem = new Inventory();
    
    switch(selection){
      case 1:
        System.out.println("Enter the name: ");
        name = in.nextLine();
        System.out.println("Enter the serial number: ");
        serialNumber = in.nextLine();
        System.out.println("Enter the value in dollars (whole number): ");
        price = in.nextInt();

        myItem.Initializer(name, serialNumber, price);
        myInventory.add(myItem);
        break;
        
      case 2:
        System.out.println("Enter the serial number of the item to delete: ");
        serialNumber = in.nextLine();
        for (Inventory element : myInventory){
          if(serialNumber.equals(element.getSN())){
            myInventory.remove(myInventory.indexOf(element));
            break;
          }
        }
        break;
        
      case 3:
        System.out.println("Enter the serial number of the item to change: ");
        serialNumber = in.nextLine();
        for (Inventory element : myInventory){
          if(serialNumber.equals(element.getSN())){
            serialNumber = element.getSN();
            System.out.println("Enter the new name: ");
            name = in.nextLine();
            
            System.out.println("Enter the new value in dollars (whole number): ");
            price = in.nextInt();

            myItem.Initializer(name, serialNumber, price);
            myInventory.set(myInventory.indexOf(element), myItem);
            break;
          }
        }  
        break;
        
      case 4:
        for (Inventory element : myInventory) {
          element.Print();
        }
        break;

      case 5:
        break;
  
      default:
        System.out.println("INVALID INPUT");
        break;
        
        
        
    }
  }while(selection != 5);


	}
}