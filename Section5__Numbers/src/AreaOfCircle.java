public class AreaOfCircle {
    public static void main(String[] args) {
        System.out.println(calcAreaOfCircle(5));
    }

    /**
     * Calculating an area of the circle
     * @param radius
     * @return
     */
    public static double calcAreaOfCircle(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
}
