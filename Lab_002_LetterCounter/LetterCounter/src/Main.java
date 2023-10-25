import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("---[ Welcome to Letter Counter ]---\n" +
                "by Marasigan, Vem Aiensi : 3BSCS-1\n\n");

        String input = "";

        while(true) {
            System.out.print("Enter Sentence: ");
            input = in.nextLine();
            countLetter(input);
        }
    }

    static void countLetter(String input)
    {
        char c;
        int count = 0;

        System.out.print("Enter Letter: ");
        c = in.next().charAt(0);

        for(int i = 0; i<input.length(); i++)
        {
            if(c == input.charAt(i) || Character.toUpperCase(c) == input.charAt(i))
            {
                count++;
            }
        }
        outCome(count, c);

        System.out.print("[1] Count another letter   [2] Enter another sentence: \t");
        if(in.next().equals("1"))
        {
            countLetter(input);
        }
        else
        {
            in.nextLine();
        }
    }

    static void outCome(int count, char c)
    {
        String phrase ="";
        if(count>0) {
            if (count > 1) {
                phrase = count + " times.";
            } else{
                phrase = "only once";
            }
            System.out.println("The letter '" + c + "' occurred " + phrase + "\n");
        } else{
            System.out.println("The letter '" + c + "' is not found in the sentence\n");
        }
    }
}