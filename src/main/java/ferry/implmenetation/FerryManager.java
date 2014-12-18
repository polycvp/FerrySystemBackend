
package ferry.implmenetation;

import ferry.contract.FerryContract;
import ferry.dto.AbstractAccount;
import ferry.dto.AccountDetail;
import ferry.dto.AccountSummary;
import ferry.dto.ReservationDetail;
import ferry.dto.ReservationSummary;
import ferry.dto.TrafficDetail;
import ferry.dto.TrafficSummary;
import ferry.dto.TravelDetail;
import ferry.dto.TravelSummary;
import ferry.eto.InvalidAccountException;
import ferry.eto.InvalidRouteException;
import ferry.eto.NoFerriesFoundException;
import ferry.eto.NoScheduleException;
import ferry.eto.NoSuchAccountException;
import ferry.eto.NoSuchReservationException;
import java.util.Collection;
import javax.ejb.Stateless;

@Stateless
public class FerryManager implements FerryContract {

    public FerryManager() {
        
    }
    
    @Override
    public Collection<TrafficSummary> getTrafficInformation(TrafficDetail trafficDetail) throws InvalidRouteException, NoFerriesFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TravelSummary getTravelSummary(TravelDetail travelDetail) throws NoScheduleException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationSummary makeReservation(ReservationDetail resDetail) throws NoSuchReservationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteReservation(int reservationId) throws NoSuchReservationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationSummary editReservation(ReservationDetail resDetail) throws NoSuchReservationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUserResident(AbstractAccount accDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountSummary makeAccount(AccountDetail accDetail) throws InvalidAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDetail login(String email, String password) throws NoSuchAccountException {
        AccountDetail acc = new AccountDetail(1, "1234561234", "password", "User", "user@user.dk", "DK");
        if (acc.getEmail().equalsIgnoreCase(email) && acc.getPassword().equalsIgnoreCase(password))
        return acc;
        else throw new NoSuchAccountException(acc.getId(),"Login failed");
    }

    @Override
    public AccountSummary deleteAccount(AccountDetail accDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editAccount(AccountDetail accDetail) throws NoSuchAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDetail showAccount(AbstractAccount acc) throws NoSuchAccountException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
