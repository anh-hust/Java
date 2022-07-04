package Week_2;

public class TV {
    int channel;
    int volumeLevel;
    boolean on;

    public TV() {
        this.channel = 1;
        this.volumeLevel = 1;
        this.on = true;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void setChannel(int newChannel) {
        if (newChannel >= 1 && newChannel <= 120 && this.on) {
            this.channel = newChannel;
        } else {
            System.out.println("Just channel 1 - 120 is available");
        }
    }

    public void setVolumne(int newVolumeLevel) {
        if (newVolumeLevel >= 1 && newVolumeLevel <= 7 && this.on) {
            this.volumeLevel = newVolumeLevel;
        } else {
            System.out.println("Voume min: 0, Max: 7");
        }
    }

    public void channelUp() {
        channel++;
    }

    public void channelDown() {
        channel--;
    }

    public void volumeUp() {
        volumeLevel++;
    }

    public void volumeDown() {
        volumeLevel--;
    }
}
