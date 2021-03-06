
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class RouletteTest {

    @Mock
    RouletteService rService;

    @Test
    void testStopingSpinAfter20s() {

        Roulette r = new Roulette(rService);
        // Start spining the roulette
        r.spin(20000);
        // when we reach 20s stop spinning
        r.stopAtTime(20000);

        verify(rService).stopSpiningAtLocation(anyInt());
    }

    // Test the ball position when the roulette is stopped
    @Test
    public void testBallBallPositionWhenRouletteStoped() {

        Roulette r = new Roulette(rService);

        r.spin(20000);
        
        r.stopAtTime(20000);

        verify(rService, times(1)).stopSpiningAtLocation(anyInt());
    }




}
