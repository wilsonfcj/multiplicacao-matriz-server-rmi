package multiplicacao.matriz.server.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;



public class MultplicacaoMatrizServerRMI {
	
	public static void main(String[] args) {
		System.out.print("\nIniciando servidor CalculadoraRemota...");

		try {
			// Instancia o gerenciador  de seguranÃ§a
			System.out.print("\nRegistrando o serviço de segurança...");
			System.setSecurityManager(new SecurityManager());
			
			CalculadoraMatriz lCalculadoraMatriz = new CalculadoraMatriz();
			
			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			LocateRegistry.createRegistry(6000);
			
			System.out.print("\n\tRegistrando o objeto no RMI Registry");
			
			Naming.rebind("rmi://127.0.0.1:6000/CalculadoraMatriz", lCalculadoraMatriz);
			
			System.out.print("\n\tAguardando requisição...");
			
		} catch (RemoteException | MalformedURLException e) {
			System.err.print("\n\tErro: " + e.getMessage());
			System.exit(1);
		}
	}
}
