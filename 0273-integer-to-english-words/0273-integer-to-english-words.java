class Solution {

    private String[] shortScale = {"", "Thousand", "Million", "Billion"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};
    private String[] oneToTeen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String result;
    private int n;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        this.result = "";

        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000).trim() + " " + shortScale[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }

        return result.trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return oneToTeen[num];
        }
        else if (num < 100) {
            return tens[num / 10] + " " + oneToTeen[num % 10];
        }
        else {
            return oneToTeen[num / 100] + " " + tens[10] + " " + helper(num % 100);
        }
    }
}