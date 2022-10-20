package CalculatorKata;

class RimOrArab {
    enum Rim {
        I, II, III, IV, V, VI, VII, VIII, IX, X
    };
    static char valid(String s) {
        char x = 'N';
        try {
            Rim.valueOf(s);
            x = 'R';
        } catch (IllegalArgumentException e) {
            x = 'N';
        }
        if (x == 'N') {
            try {
                Integer.valueOf(s);
                x = 'A';
            } catch (IllegalArgumentException e) {
                x = 'N';
            }
        }
        return x;
    }
    static String arabOperation (String o1, String o2, String oper) throws Exception {
            int a1, a2, result = 0;
            a1 = Integer.valueOf(o1);
            a2 = Integer.valueOf(o2);
            if (a1<1 || a1>10 || a2<1 || a2>10) {
                throw new Exception("Число должно быть от 1 до 10");
            }
        result = Operation(oper, a1, a2);
           return Integer.toString(result);
        }
    static String rimOperation (String o1, String o2, String oper) throws Exception {
        int r1 = Rim.valueOf(o1).ordinal() + 1;
        int r2 = Rim.valueOf(o2).ordinal() + 1;
        int result = 0;
        result = Operation(oper, r1, r2);
        if (result>1){
            return Roman2Arabic.toRoman(result);
        }
        else {
            throw new Exception("В римской системе нет отрицательных чисел и 0");
        }
    }
    static int Operation (String s, int o1, int o2) {
        int result = 0;
        switch (s.charAt(0)) {
            case '+':
                result = o1 + o2;
                break;
            case '-':
                result = o1 - o2;
                break;
            case '/':
                result = o1 / o2;
                break;
            case '*':
                result = o1 * o2;
                break;
        }
        return result;
    }
}

