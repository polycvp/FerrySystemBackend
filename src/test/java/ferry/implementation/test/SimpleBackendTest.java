package ferry.implementation.test;

import ferry.contract.test.FerryAccountTest;
import ferry.contract.test.FerryContractHolder;
import ferry.contract.test.FerryReservationTest;
import ferry.implmenetation.FerryManager;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({FerryAccountTest.class,FerryReservationTest.class})
public class SimpleBackendTest {

    private static EJBContainer container;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        container = EJBContainer.createEJBContainer();
        
        FerryContractHolder.contract = (FerryManager) container.getContext().lookup("java:global/classes/FerryManager");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
