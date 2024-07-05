package lab2;

public class Exercise2 {

	public static void main(String[] args) {
        FootballPlayer modric = new FootballPlayer(172, 65, 85.0, 92.0);
        System.out.printf("Modric shooting skill before training: %.2f \n", modric.getShootingSkill());
        modric.trainShooting();
        System.out.printf("Modric shooting skill after training: %.2f \n", modric.getShootingSkill());
        System.out.println("Modric height: " + modric.getHeight());

        FootballPlayer randomPlayer = new FootballPlayer(187, 78);
        System.out.printf("Random player shooting skill is %.2f and dribbling skill is %.2f. \n", 
                          randomPlayer.getShootingSkill(), randomPlayer.getDribblingSkill());
    }

}
