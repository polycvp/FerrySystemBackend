
package ferry.implmenetation;

import ferry.contract.test.FerryContractHolder;
import ferry.dto.AccountDetail;
import ferry.eto.InvalidAccountException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        try {
            FerryContractHolder.contract = new FerryManager();
            AccountDetail ad = new AccountDetail(22, "1234561234", "password", "Test1", "test@test.dk", "DK");
            FerryContractHolder.contract.makeAccount(ad);
        } catch (InvalidAccountException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
