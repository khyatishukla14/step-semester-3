class BookInventory{
    String title;
    String author;
    int copiesavailable;
    BookInventory(String title, String author, int copiesavailable){
        this.title = title;
        this.author = author;
        this.copiesavailable = copiesavailable;
    }
    void printEntry(){
        System.out.println(title + " by " + author + " - " + copiesavailable + " copies available");
    }
}
public class q1{
    public static void main(String args[]){
        BookInventory[] obj = new BookInventory[4];
        obj[0] = new BookInventory("Clean Code", "Robert C Martin", 3);
        obj[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        obj[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        obj[3] = new BookInventory("Design Patterns", "GoF", 2);
        for(int i = 0; i<obj.length; i++){
            obj[i].printEntry();
        }
    }
}