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
import ferry.entity.Person;
import ferry.eto.InvalidAccountException;
import ferry.eto.InvalidRouteException;
import ferry.eto.NoFerriesFoundException;
import ferry.eto.NoScheduleException;
import ferry.eto.NoSuchAccountException;
import ferry.eto.NoSuchReservationException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FerryManager implements FerryContract {

    private Assembler asm = new Assembler();
    private Dissassembler dsm = new Dissassembler();

    @PersistenceContext(unitName = "ferry_ls-FerryMavenBackend_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

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
        Person p = em.find(Person.class, accDTO.getId());
        return p.getIsresident().equals('T');
    }

    @Override
    public boolean makeAccount(AccountDetail accDetail) throws InvalidAccountException {
        int result = em.createNamedQuery("Person.findByEmail").setParameter("email", accDetail.getEmail()).getFirstResult();
        if (result == 0) {
            em.persist(dsm.createPerson(accDetail));
            return true;
        }
        else {
            throw new InvalidAccountException("Email address already exists");
        }
    }

    @Override
    public AccountDetail login(String email, String password) throws NoSuchAccountException {
        try {
            Person p = (Person) em.createNamedQuery("Person.findByEmail").setParameter("email", email).getSingleResult();
            if (p.getPassword().equalsIgnoreCase(password)) {
                return asm.createAccountDetail(p);
            } else {
                throw new NoSuchAccountException("Login failed");
            }
        } catch (Exception e) {
            throw new NoSuchAccountException("Login failed");
        }
    }

    @Override
    public AccountSummary deleteAccount(AccountDetail accDetail) throws NoSuchAccountException {
           try {
        Person p = em.find(Person.class, accDetail.getId());
        em.remove(p);
        return asm.createAccountSummary(p);
        } catch (Exception e) {
            throw new NoSuchAccountException("Login failed");
        }
    }

    @Override
    public boolean editAccount(AccountDetail accDetail) throws NoSuchAccountException {
         try {
        Person p = em.find(Person.class, accDetail.getId());
        p.setAddress(accDetail.getAddress());
        p.setCpr(accDetail.getCprNo());
        p.setEmail(accDetail.getEmail());
        p.setPersonName(accDetail.getName());
        
        em.merge(p);
        return true;
        } catch (Exception e) {
            throw new NoSuchAccountException("Login failed");
        }
    }

    @Override
    public AccountDetail showAccount(AbstractAccount acc) throws NoSuchAccountException {
         try {
        Person p = em.find(Person.class, acc.getId());
        return asm.createAccountDetail(p);
        } catch (Exception e) {
            throw new NoSuchAccountException("Login failed");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
