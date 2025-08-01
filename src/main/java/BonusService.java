public class BonusService {
    public Bonus createBonus(Combination comb) {
        if (comb.getSize() >= 4) {
            return new Bonus();
        }
        return null;
    }
}
