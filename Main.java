import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    private static ArrayList<Integer> StringListToVect(LinkedList <String> StringVector) {
        ArrayList<Integer> vec = new ArrayList<>();
        for (int i = 0; i < StringVector.size(); i++) {
            try{vec.add(Integer.parseInt(StringVector.get(i)));}
            catch(NumberFormatException e){
                StringVector.remove(i);
               return StringListToVect(StringVector);
            }
        }
        return vec;
    }
    private static LinkedList <String>StrToList(String str){
        String[] IntegerStrings = str.split(" ");
        LinkedList <String> ListStr = new LinkedList<>(Arrays.asList(IntegerStrings));
        return ListStr;
    }
    public static class WektoryRoznejDlugosciException extends Exception {
        public WektoryRoznejDlugosciException(int a, int b) {
            super("WektoryRoznejDlugosciException. Dlugosc pierwszego wektora to:" + a+ ", a drugiego to:" + b); }

    }
    private static ArrayList<Integer> sum(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> v3 = new ArrayList();
        for(int i=0; i< v1.size();i++) {
            v3.add(v1.get(i)+v2.get(i));
        }
        return v3;
    }

    public static void main(String[] args) {
        ArrayList<Integer> v1,v2,v3;
        Scanner sc = new Scanner(System.in);
        boolean END = false;
        while (!END){
            try {
                System.out.println("Vector 1:");
                v1 = StringListToVect(StrToList( (sc.nextLine() )));
                System.out.println("Vector 2:");
                v2 = StringListToVect(StrToList((sc.nextLine())));
                if (v1.size() != v2.size()) {
                    throw (new WektoryRoznejDlugosciException(v1.size(), v2.size()));
                }
                v3 = sum(v1,v2);
                System.out.println(v3);
                END = true;
            }
            catch (WektoryRoznejDlugosciException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
