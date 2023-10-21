public class Lexeme {
    private String lexeme;
    private String token;
    private String dataType = "String";

    public Lexeme(String lexeme)
    {
        setLexeme(lexeme);

        if (lexeme.equals("="))
            setToken("<assignment_operator>");
        else if (lexeme.equals(";"))
            setToken("<delimiter>");
        else if (lexeme.equals("+") || lexeme.equals("-") ||
                lexeme.equals("/") || lexeme.equals("*"))
            setToken("<operator>");
        else if (lexeme.equals("int") || lexeme.equals("double") ||
                lexeme.equals("String") || lexeme.equals("char"))
            setToken("<data_type>");
        else if (isValue(lexeme))
            setToken("<value>");
        else
            setToken("<identifier>");

        if(getToken().equals("<data_type>"))
            switch ((lexeme))
            {
                case "char": setDataType("Character"); break;
                case "String": setDataType("String"); break;
                case "double": setDataType("Double"); break;
                case "int": setDataType("Integer"); break;
            }

        if(getToken().equals("<value>"))
            switch (dtAnalyzer(lexeme))
            {
                case "char": setDataType("Character"); break;
                case "double": setDataType("Double"); break;
                case "int": setDataType("Integer"); break;
                default: break;
            }
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

    static String dtAnalyzer(String data){
        String type = "";
        boolean hasDecimal = false;
        for(int i = 0; i<data.length(); i++)
            if(data.charAt(i) == '.') {
                hasDecimal = true;
                break;
            }

        if(data.charAt(0) == '\'')
            type = "char";
        else if(hasDecimal)
            type = "double";
        else type = "int";

        return type;
    }



    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
