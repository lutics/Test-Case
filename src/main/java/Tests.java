public class Tests {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String[] card = {"02/05 15000 2", "03/11 5541 1", "03/31 10000 3", "03/31 100 1", "05/15 10000 2", "10/10 12345 1", "11/22 5999 4", "12/01 901 10"};
//        int[] result = solution.solution(card);
//        System.out.println(Arrays.toString(result));

//        int k = 1000;
//        int[] rates = {1200, 1000, 1100, 1200, 900, 1000, 1500, 900, 750, 1100};
        int k = 1500;
        int[] rates = {1500, 1400, 1300, 1200};
        int result = solution.solution(k, rates);
        System.out.println(result);
    }

    static class Solution {

        public int solution(int k, int[] rates) {
            int answer = 0;

            int budget = k;
            int stored = 0;
            int rate = 0;

            for (int i = 0; i < rates.length; i++) {
                rate = rates[i];

                if (stored == 0) {
                    if (budget >= rate) {
                        if (i + 1 < rates.length && rates[i + 1] < rate) continue;

                        budget -= rate;
                        stored += 1;
                    }
                } else {
                    if (i + 1 < rates.length && rate >= rates[i + 1]) {
                        budget += rate;
                        stored -= 1;
                    }
                }
            }

            if (stored != 0) {
                budget += rate;
                stored -= 1;
            }

            answer = budget;

            return answer;
        }

//        public int[] solution(String[] card) {
//            int[] answer = new int[13];
//
//            for (String data : card) {
//                String[] splits = data.split(" ");
//
//                int date = Integer.parseInt(splits[0].substring(0, 2));
//                int money = Integer.parseInt(splits[1]);
//                int month = Integer.parseInt(splits[2]);
//
//                if (month == 1 || date == 12) {
//                    double point = Math.ceil(money * 0.01);
//
//                    answer[0] += point;
//                    answer[date] += money;
//                } else {
//                    double moneyPerMonth = Math.ceil((double) money / month);
//
//                    for (int i = 0; i < month; i++) {
//                        if (date + i >= 12) {
//                            answer[12] += moneyPerMonth;
//                        } else {
//                            answer[date + i] += moneyPerMonth;
//                        }
//                    }
//                }
//
//                System.out.printf("%s - %s%n", date, money);
//            }
//
//            return answer;
//        }
    }
}
