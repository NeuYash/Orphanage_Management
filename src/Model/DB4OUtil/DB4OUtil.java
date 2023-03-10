package Model.DB4OUtil;

import Model.Adopter.AdopterDirectory;
import Model.Child.ChildDirectory;
import Model.ConfigureASystem;
import Model.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;

/**
 *
 * @author yashpawar
 */
public class DB4OUtil {

    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
    private static DB4OUtil dB4OUtil;
 
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save
               config.common().objectClass(ChildDirectory.class).cascadeOnUpdate(true);
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
      public synchronized void storeDirectory(ChildDirectory directory) {
        ObjectContainer conn = createConnection();
        conn.store(directory);
        conn.commit();
        conn.close();
    }
      
      //store user directory -MainJFrame calls this method
      public synchronized void storeUserDirectory(AdopterDirectory udirectory) {
        ObjectContainer conn = createConnection();
        conn.store(udirectory);
        conn.commit();
        conn.close();
    }
      
      public int childDirectorySize(){
        return retrieveDirectory().getChildList().size();
    }
    
    public int UserAccDirectorySize(){
        return retrieveUserDirectory().getAdoptersList().size();
    }
    
    public EcoSystem retrieveSystem(){
        
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Change to the object you want to save
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureASystem.configure();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
    
    public ChildDirectory retrieveDirectory(){
     ObjectContainer conn = createConnection();
        ObjectSet<ChildDirectory> systems = conn.query(ChildDirectory.class); // Change to the object you want to save
        ChildDirectory system;
        if (systems.size() == 0){
            system = ConfigureASystem.configureDirectory();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;   
    }
    // retrieves user directory.- MainJFrame uses this
    public AdopterDirectory retrieveUserDirectory(){
     ObjectContainer conn = createConnection();
        ObjectSet<AdopterDirectory> systems = conn.query(AdopterDirectory.class); // Change to the object you want to save
        AdopterDirectory system;
        if (systems.size() == 0){
            system = ConfigureASystem.configureUserDirectory();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;   
    }
}
