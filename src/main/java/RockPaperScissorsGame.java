import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String INFILENAME = "C:\\workspace\\TC10_1RockPaperScissors\\input\\submitInput.txt";
    private static String OUTFILENAME = "C:\\workspace\\TC10_1RockPaperScissors\\output\\outputChallenge1.txt";
    private static Scanner in;
    private static PrintWriter out;
    private static Object movement;

    private enum Movement {
        R('R'), S('S'), P('P'), DASH('-');
        private char asChar=' ';

        Movement(char asChar) {
            this.asChar = asChar;
        }
        public char asChar() {
            return asChar;
        }
   }

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(INFILENAME));
        out = new PrintWriter(OUTFILENAME);
        int i = 1;
        int cases = Integer.parseInt(in.nextLine());
        System.out.println("Number of cases: " + cases);
        while(in.hasNextLine() && i <= cases) {
                String line = in.nextLine();
                if(line.length()!=0)  {
                    Movement winvalue = compareValues(line.charAt(0), line.charAt(2));
                    out.println("Case #" + i + ": " + winvalue.asChar);
                }
                i++;
        }

        in.close();
        out.close();
    }

    private static Movement compareValues(char firstValue, char secondValue) {
        if (Movement.R.asChar==firstValue) {
            if (Movement.S.asChar ==secondValue)
                return Movement.R;
            if (Movement.P.asChar ==secondValue)
                return Movement.P;
        }
        if (Movement.S.asChar ==firstValue) {
            if (Movement.P.asChar ==secondValue)
                return Movement.S;
            if (Movement.R.asChar ==secondValue)
                return Movement.R;
        }

        if (Movement.P.asChar ==firstValue) {
            if (Movement.R.asChar ==secondValue)
                return Movement.P;
            if (Movement.S.asChar == secondValue)
                return Movement.S;
        }
        return Movement.DASH;
    }
}