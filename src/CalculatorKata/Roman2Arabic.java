package CalculatorKata;

class Roman2Arabic {
    static int[] intervals={0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static String[] numerals={"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    static int findFloor(final int number, final int firstIndex, final int lastIndex) {
        if(firstIndex==lastIndex)
            return firstIndex;
        if(intervals[firstIndex]==number)
            return firstIndex;
        if(intervals[lastIndex]==number)
            return lastIndex;
        final int median=(lastIndex+firstIndex)/2;
        if(median==firstIndex)
            return firstIndex;
        if(number == intervals[median])
            return median;
        if(number > intervals[median])
            return findFloor(number, median, lastIndex);
        else
            return findFloor(number, firstIndex, median);

    }
    static String toRoman(final int number) {
        int floorIndex=findFloor(number, 0, intervals.length-1);
        if(number==intervals[floorIndex])
            return numerals[floorIndex];
        return numerals[floorIndex]+toRoman(number-intervals[floorIndex]);
    }
}