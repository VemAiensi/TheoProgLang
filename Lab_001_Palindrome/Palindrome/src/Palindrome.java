import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int repeat = 0;

        System.out.println("---[ Welcome to Palindrome Checker ]---\n" +
                "by Marasigan, Vem Aiensi : 3BSCS-1");

        do {
            System.out.print("\nEnter word/phrase: ");

            if (palindrome(in.nextLine()))
                System.out.print(" is Palindrome.");
            else
                System.out.print(" is not Palindrome.");

            System.out.print("\nWan't to try again [1/0]? ");
            repeat = in.nextInt();
            in.nextLine();

        }while (repeat == 1);

        System.out.println("Thank you!");
    }

    static boolean palindrome(String phrase)
    {
        boolean match = false;

        String reversed = "";

        for (int i = filter(phrase).length()-1; i > -1; i--)
        {
            reversed += filter(phrase).charAt(i);
        }

        System.out.print(phrase);
        if (filter(phrase).equals(reversed))
            match = true;

        return match;
    }

    static String filter(String phrase)
    {
        String capitalized = "";

        for (int i = 0; i < phrase.length(); i++)
        {
            if ((phrase.charAt(i) > 47 && phrase.charAt(i) < 57) || //numbers
                (phrase.charAt(i) > 64 && phrase.charAt(i) < 91) || //lowercase letters
                (phrase.charAt(i) > 96 && phrase.charAt(i) < 123))  //uppercase letters
                capitalized += Character.toUpperCase(phrase.charAt(i));
        }

        return capitalized;
    }
}