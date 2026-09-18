class Item{
    String itemName;
    int stock;
    Item(String itemName, int stock){
        this.itemName = itemName;
        this.stock = stock;
    }
    void restock(int stock){
        this.stock = this.stock + stock;
    }
}
public class q2{
    public static void main(String args[]){
        Item[] obj = new Item[4];
        obj[0] = new Item("Samosa", 15);
        obj[1] = new Item("Tea Powder", 40);
        obj[2] = new Item("Bread", 8);
        obj[3] = new Item("Biscuit Packs", 25);
        for(int i = 0; i<obj.length; i++){
            obj[i].restock(20);
            System.out.println(obj[i].itemName + " | Final Stock: " + obj[i].stock);
        }
    }
}
