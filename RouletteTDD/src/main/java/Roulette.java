import java.util.Random;

public class Roulette {


    private final RouletteService rService;

    private boolean isItSpinning = false;

    private long spinDuration;

    private long currentMs = 0;

    private final Random rand = new Random();

    public Roulette(final RouletteService rService) {
        this.rService = rService;
    }


    void spin(final long spinForMs) {
        this.isItSpinning = true;
        this.spinDuration = spinForMs;
    }

    void stopAtTime(final long timeMs) {
        currentMs = timeMs;
        if (isItSpinning && currentMs >= spinDuration)
        {
            isItSpinning = false;
            final int location = rand.nextInt(37);
            this.rService.stopSpiningAtLocation(location);
        }
    }

}
