import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(TempConverter.class)
public class TempConverterBean implements TempConverter {
    @Lock(LockType.READ)
    public double fahr2Cel(double fahrTemp) {
        return (5./9.) * (fahrTemp - 32);
    }

    @Lock(LockType.READ)
    public double cel2Fahr(double celTemp) {
        return (9./5.) * celTemp + 32;
    }
}
