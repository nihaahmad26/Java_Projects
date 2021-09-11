public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getringTone();
        }
    
    @Override
    public String unlock() {
        return "phone has been unlocked";
    }

    @Override
    public void displayInfo() {
        System.out.println("Version Number: " + this.getVersionNumber());            
        System.out.println("Battery Percentage: " + this.getbatteryPercentage());            
        System.out.println("Carrier: " + this.getcarrier());            
        System.out.println("Ring Tone: " + this.getringTone());            
    }
}

