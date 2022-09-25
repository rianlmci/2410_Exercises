package Warmup;

class LabChocolate {
    public static void main(String[] args) {

    }

    /**
     * Implements coding bat challenge.
     * @author Rianna
     * @param small number of small bars, each bar weighs one kilo
     * @param big number of big bars, each bar weighs five kilos
     * @param goal weight of desired package in kilos
     * @return number of small bars needed to make package that weighs the desired amount
     */
    public static int makeChocolate(int small, int big, int goal) {
        int chocSum = -1;

        if ((goal % big == 0) && (goal-(5*big) == 0)){
            return 0;
        }

        else if (((5*big) + small) >= goal){
            chocSum = 0;

            if ((5*big)>=goal){
                while((5*big)>goal)
                    big -= 1;
            }

            int goalCountdown = (goal-(5*big));

            if(goalCountdown > small){
                return -1;
            }

            else {
                while (goalCountdown != 0) {
                    goalCountdown -= 1;
                    chocSum += 1;
                }
            }
        }
        return chocSum;
    }
}