public class BatTest {
        public static void main(String[] args) {
            Bat b = new Bat();
            b.getEnergyLevel();
            b.fly(2);
            b.eatHumans(2);
            b.attackTown(3);

            System.out.println("final energy level =" + b.getEnergyLevel());

            }
        } 
