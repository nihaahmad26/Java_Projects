public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getringTone();
    }
    @Override
    public String unlock() {
        return "Siri welcomes you";
    }
    @Override
    public void displayInfo() {
        System.out.println("Version Number: " + this.getVersionNumber());            
        System.out.println("Battery Percentage: " + this.getbatteryPercentage());            
        System.out.println("Carrier: " + this.getcarrier());            
        System.out.println("Ring Tone: " + this.getringTone());            
    }
}

