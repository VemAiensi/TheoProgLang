import java.util.LinkedList;
import java.util.Scanner;

public class Tokenizer {
    public static void main(String[] args)
    {
        LinkedList<String> lexemes;
        Scanner in = new Scanner(System.in);

        System.out.println("---[ Welcome to Lexeme Tokenizer ]---\n" +
                "by Marasigan, Vem Aiensi : 3BSCS-1\n");

        do{
            System.out.print("Enter Source Language:  ");
            lexemes = toList(in.nextLine());

            System.out.print("Output is: ");
            for(int i = 0; i<lexemes.size(); i++)
                System.out.print(getToken(lexemes.get(i)) + " ");
            System.out.println("\n");
        }while(true);
    }

    static String getToken(String lexeme)
    {
        String token = "";
        if (lexeme.equals("="))
            token = "<assignment_operator>";
        else if (lexeme.equals(";"))
            token = "<delimiter>";
        else if (lexeme.equals("+") || lexeme.equals("-") ||
                 lexeme.equals("/") || lexeme.equals("*"))
            token = "<operator>";
        else if (lexeme.equals("int") || lexeme.equals("double") ||
                 lexeme.equals("String") || lexeme.equals("char"))
            token = "<data_type>";
        else if (isValue(lexeme))
            token = "<value>";
        else
            token = "<identifier>";

        return token;
    }

    static boolean isValue(String input)
    {
        boolean value = false;

        for(int i = 0; (input.charAt(i) >= 48 && input.charAt(i) <= 57) ||
                input.charAt(i) == '.' ;i++)
        {
            value = true;
            if(i == input.length()-1)
                break;
        }
        if((input.charAt(0)=='"' && input.charAt(input.length()-1)=='"') ||
           (input.charAt(0)=='\'' && input.charAt(input.length()-1)=='\''))
            value = true;

        return value;
    }

    static LinkedList<String> toList(String input)
    {
        LinkedList<String> lexemes = new LinkedList<>();

        for(int i=0, j=0; j<input.length(); )
        {
            String data = "";

            if(input.charAt(i)== ' ') {
                i++; j++;
            }
            else if(input.charAt(i) == '\'') {
                for(j += 3; i<j; i++)
                    data += input.charAt(i);
                lexemes.add(data);
            }
            else if(input.charAt(i) == '"') {
                while(input.charAt(j) != '"')
                    j++;

                for(;i<=j;i++)
                    data += input.charAt(i);
                j++;
                lexemes.add(data);
            }
            else if(input.charAt(i) == ';') {
                lexemes.add(";");
                break;
            }
            else {
                while (input.charAt(j) != ' ' && input.charAt(j) != ';')
                    j++;

                for (; i < j; i++)
                    data += input.charAt(i);
                lexemes.add(data);
            }
        }
        return lexemes;
    }
}