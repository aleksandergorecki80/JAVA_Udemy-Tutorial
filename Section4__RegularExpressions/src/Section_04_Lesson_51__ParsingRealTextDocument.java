import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section_04_Lesson_51__ParsingRealTextDocument {
    public static void main(String[] args) {

        String transcrypt = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        String regex = """
        Student\\sNumber:\\s(?<studentIdNumber>\\d{10}) # Get stydent's Id number
        .* # Anything - " . " , zero or more - " * "
        Grade:\\s+(?<studentGrade>\\d{1,2}) # Get stydent's Id number
        .* # Anything - " . " , zero or more - " * "
        Birthdate:\\s+(?<birthdate>(\\d{1,2}/){2}\\d{4}) # Get stydent's birthdate
        .* # Anything - " . " , zero or more - " * "
        Gender:\\s+(?<gender>\\w+)\\b # Get stydent's gender - one or more character
        .* # Anything - " . " , zero or more - " * "
        State\\sID:\\s+(?<stateID>\\d+)\\b # Get stydent's State ID
        .*? # Anything - " . " , zero or more - " * "
       Cumulative.*?(?<cumulative>[\\d+.]+)\\b # Get stydent's Weighted , "?" makes * not greedy
       .* # Anything - " . " , zero or more - " * "
       # Weighted\\)\\s+(?<weighted>[\\d+.]+)\\b # Get stydent's Weighted
       # .* # Anything - " . " , zero or more - " * "
       # Unweighted\\)\\s+(?<unweighted>[\\d+.]+)\\b # Get stydent's Unweighted
       # .* # Anything - " . " , zero or more - " * "
        
        
        """;
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(transcrypt);

        if(matcher.matches()){
            System.out.println(matcher.group("studentIdNumber"));
            System.out.println(matcher.group("studentGrade"));
            System.out.println(matcher.group("birthdate"));
            System.out.println(matcher.group("gender"));
            System.out.println(matcher.group("stateID"));
            System.out.println(matcher.group("cumulative"));
//            System.out.println(matcher.group("weighted"));
//            System.out.println(matcher.group("unweighted"));
        }
    }
}
