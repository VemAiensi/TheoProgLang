import java.util.LinkedList;
import java.util.Scanner;

public class SemanticAnalyzer {
    public static void main(String[] args)
    {
        LinkedList<Lexeme> sentence = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("---[ Welcome to Semantic Analyzer ]---\n" +
                "by Marasigan, Vem Aiensi : 3BSCS-1\n");

        do{
            try{
                System.out.print("Enter Source Language:  ");
                sentence = toList(in.nextLine());

                if(syntaxCheck(sentence))
                {
                    //System.out.println(sentence.get(0).getDataType()
                    //+" "+ sentence.get(sentence.size()-2).getDataType());
                    if(sentence.get(0).getDataType().equals(sentence.get(sentence.size()-2).getDataType()))
                        System.out.println("Semantically Correct!\n");
                    else System.out.println("Semantically Incorrect :(\n");
                }
                else System.out.println("Syntax is not correct");

            }catch (Exception e) {
                System.out.println("Please include a delimiter [semicolon]");
            }
        }while(true);
    }

    static LinkedList<Lexeme> toList(String input)
    {
        LinkedList<Lexeme> sentence = new LinkedList<>();

        for(int i=0, j=0; j<input.length(); )
        {
            String data = "";

            if(input.charAt(i)== ' ') {
                i++; j++;
            }
            else if(input.charAt(i) == '\'') {
                for(j += 3; i<j; i++)
                    data += input.charAt(i);
                sentence.add(new Lexeme(data));
            }
            else if(input.charAt(i) == '"') {
                while(input.charAt(j) != '"')
                    j++;

                for(;i<=j;i++)
                    data += input.charAt(i);
                j++;
                sentence.add(new Lexeme(data));
            }
            else if(input.charAt(i) == ';') {
                sentence.add(new Lexeme(";"));
                i++;
                j++;
            }
            else {
                while (input.charAt(j) != ' ' && input.charAt(j) != ';')
                    j++;

                for (; i < j; i++)
                    data += input.charAt(i);
                sentence.add(new Lexeme(data));
            }
        }
        return sentence;
    }

    static boolean syntaxCheck(LinkedList<Lexeme> sentence)
    {
        boolean pass = true;
        // this checker is still weak as it only checks 4 tokens
        if ((!sentence.get(0).getToken().equals("<data_type>")) ||
           (!sentence.get(1).getToken().equals("<identifier>")) ||
           (!sentence.get(2).getToken().equals("<assignment_operator>")) ||
           (!sentence.get(3).getToken().equals("<value>")))
            pass = false;

        return pass;
    }
}