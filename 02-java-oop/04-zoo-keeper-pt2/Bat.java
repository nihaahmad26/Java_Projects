public class Bat {

    int energyLevel = 300;

    public int getEnergyLevel(){
        return energyLevel;
    }

    public int fly(int flights) {
        energyLevel -= 50*flights;
        System.out.println("bat taking off noise" + " " +  energyLevel);
        return energyLevel;
    }

    public int eatHumans(int humans) {
        energyLevel += 25*humans;
        System.out.println("bat munching on hoomans" + " " + energyLevel);
        return energyLevel;
    }
    public int attackTown(int towns) {
        energyLevel -= 100*towns;
        System.out.println("VILLAGE ON FIRE" + " " + energyLevel);
        return energyLevel;
    }
}