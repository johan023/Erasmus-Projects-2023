package lab2;

public class FootballPlayer extends Person implements Trainable {
    private double shootingSkill;
    private double dribblingSkill;

    public FootballPlayer(int height, int weight) {
        super(height, weight);
        this.shootingSkill = 50.0;
        this.dribblingSkill = 50.0;
    }

    public FootballPlayer(int height, int weight, double shootingSkill, double dribblingSkill) {
        super(height, weight);
        this.shootingSkill = validateSkill(shootingSkill);
        this.dribblingSkill = validateSkill(dribblingSkill);
    }

    private double validateSkill(double skill) {
        if (skill < 0) {
            return 0;
        } else if (skill > 100) {
            return 100;
        } else {
            return skill;
        }
    }

    public double getShootingSkill() {
        return shootingSkill;
    }

    public void setShootingSkill(double shootingSkill) {
        this.shootingSkill = validateSkill(shootingSkill);
    }

    public double getDribblingSkill() {
        return dribblingSkill;
    }

    public void setDribblingSkill(double dribblingSkill) {
        this.dribblingSkill = validateSkill(dribblingSkill);
    }

    @Override
    public void trainShooting() {
        shootingSkill += (100 - shootingSkill) * 0.1;
        if (shootingSkill > 100) {
            shootingSkill = 100;
        }
    }

    @Override
    public void trainDribbling() {
        dribblingSkill += (100 - dribblingSkill) * 0.1;
        if (dribblingSkill > 100) {
            dribblingSkill = 100;
        }
    }

    
}