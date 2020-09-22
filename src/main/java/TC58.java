import java.util.*;

public class TC58 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(7);
        a.add(5);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(7);
        b.add(2);
        b.add(5);

        for (int i :mergerArrays(a,b)){
            System.out.println(i);
        }
    }

    public int calculate (String input) {
        // write code here


        LinkedList<Character> characters = new LinkedList<>();
        LinkedList<String> num = new LinkedList<>();
        LinkedList<Character> numLetter = new LinkedList<>();
        char[] chars = input.toCharArray();
        for (int i =0;i<chars.length;i++){
            if (chars[i]!=' '){
                if (chars[i]!='+'&&chars[i]!='-'&&chars[i]!='*'&&chars[i]!='/'){
                }else {

                }
            }
        }

        return 0;
    }

    public int[] countBits (int num) {
        // write code here
        int[] res = new int[num+1];
        for (int i = 0;i<=num;i++){
            res[i] = getOne(i);
        }

        return res;
    }

    public int getOne(int x){
        int count = 0;
        while (x!=0){
            count++;
            x = x&(x-1);
        }

        return count;
    }

    public static ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i :arrayA){
            if (arrayB.contains(i)){
                res.add(i);
            }
        }

        Collections.sort(res);
        return res;
    }
}
