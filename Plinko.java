public class Plinko{
   public static void main(String[]args){
    int width = 9;
    int position = 5;
    int [] slots = {100,200,300,400,500,400,300,200,100};

    for (int i = 0; i < 10; i++) {
        double leftright = Math.random();
        Math.round((leftright)); 
        if (leftright < 0.5) {
            position++;
        }   else {
            position--;
        }
        if (position < 0) {
            position = 0;
        }
        if (position >= slots.length) {
            position = (slots.length - 1);
        }
        for (int j = 0; j < width; j++) {
            if (j == position) {
                System.out.print("  o  ");
            }
            else {
                System.out.print("  .  ");
            }
        }
        System.out.println();
    }
    System.out.println("drop ");
    System.out.println("Position:" + "" + position);
    int center = width / 2; 
    int index = position - center + (slots.length / 2);
     System.out.print("results:");
        if (index >= 0 && index < slots.length) {
    System.out.println("You landed on:" + "" + slots[index] + "" + "points!");
        } else {
    System.out.println("You went out of the board??");
        }
    }
}

