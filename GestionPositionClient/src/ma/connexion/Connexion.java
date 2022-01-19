package ma.connexion;

import java.util.Date; 
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ma.dao.SmartphoneRemote;
import ma.dao.UserRemote;
import ma.entities.User;

public class Connexion {

	private static SmartphoneRemote rSphone;
	private static UserRemote rUser;

	private static void connect() {
		Hashtable<Object, Object> jndiProperties = new Hashtable<Object, Object>();

		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		try {
			final Context context = new InitialContext(jndiProperties);

			rUser = (UserRemote) context.lookup("ejb:/GestionPosition/User!ma.dao.UserRemote");
			rSphone = (SmartphoneRemote) context.lookup("ejb:/GestionPosition/Smartphone!ma.dao.SmartphoneRemote");
		} catch (Exception e) {
			System.out.println("probelme");
			e.printStackTrace();
		}

	}


	public static SmartphoneRemote getrSphone() {
		connect();
		return rSphone;
	}

	public static UserRemote getrUser() {
		connect();
		return rUser;
	}	

	public static void main(String[] args) throws Exception {
			
		

	}
}
