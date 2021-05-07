
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.mockito.Mockito.*;

public class RouletteTest {

    @Mock
    RouletteService rService;

    @Test
    void Stopped20SAfterSpin() {

        Roulette r = new Roulette(rService);
        // Start spining the roulette
        r.spin(20000);
        // when we reach 20s stop spinning
        r.stopAtTime(20000);

        verify(rService).stopSpiningAtLocation(anyInt());
    }


}
