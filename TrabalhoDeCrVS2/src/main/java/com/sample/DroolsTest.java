package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	
        	Scanner ler = new Scanner(new FileInputStream("C:\\Users\\35193\\OneDrive - ISEC\\Ambiente de Trabalho/teste2.txt"));
            String linha = ler.nextLine();
            while(ler.hasNextLine()) {
                linha = ler.nextLine();
                String [] temp = linha.split(";");
                Divisao d = new Divisao(temp[0]);
                kSession.insert(d);
                //camra // intrusos // animal // somde vidro // codigo
                if(temp[1].equals("simT")) {
                	camara asp1 = new camara( d, true );
                	kSession.insert( asp1 );
                }else if(temp[1].equals("simF")){
                	camara asp1 = new camara( d, false );
                	kSession.insert( asp1 );
                }
                
                if(temp[2].equals("simT")) {
                	intrusos f1 = new intrusos (d, false); 
                	kSession.insert( f1 );
                }
                /*else if(temp[2].equals("simF")){
                	intrusos f1 = new intrusos (d, false);
                	kSession.insert( f1 );
                }*/
                
                if(temp[3].equals("simT")) {
                	animal al1 = new animal (d, "Gato");
                	kSession.insert( al1 );
                }else if(temp[3].equals("simF")){
                	animal al1 = new animal (d, "Cão");
                	kSession.insert( al1 );
                }
                
                if(temp[3].equals("simT")) {
                	somVidroPartir svp = new somVidroPartir(false);
                	kSession.insert(svp);
                }
                
                if(temp[4].equals("simT")) {
            	   	codigo cdg = new codigo(d, true);
            	   	kSession.insert(cdg);
                }else if(temp[4].equals("simF")) {
            	   	codigo cdg = new codigo(d, false);
            	   	kSession.insert(cdg);
                }
                
            }
            ler.close();

            //kSession.fireAllRules();
        	
        	
        	
            // go !
       	/*Divisao d1 = new Divisao ("cozinha");
      	Divisao d2 = new Divisao ("escritório");
        Divisao d3 = new Divisao ("sala");
        Divisao d4 = new Divisao ("quintal");
       	 
       	kSession.insert( d1 );
       	kSession.insert( d2 );
       	kSession.insert( d3 );
       	kSession.insert( d4 );
       	
       	
       	///////////////////////////////////////
       	
       	camara asp1 = new camara( d1, true ); //cozinha tem aspersor
       	camara asp2 = new camara( d4, true ); //escritório tem aspersor
       	camara asp3 = new camara( d3, true );
       	
	   	 kSession.insert( asp1 ); 
	   	 kSession.insert( asp2 );
	   	 kSession.insert( asp3 );
       	
	   	 
	   	 ////////////////////////////////////

	   	intrusos f1 = new intrusos (d1, false); //Fogo na cozinha
	   	intrusos f2 = new intrusos (d2, false); //Fogo no escritório
	   	intrusos f3 = new intrusos (d4, false); //Fogo na sala
       	
	   	kSession.insert( f1 );
	   	kSession.insert( f2 );
	   	kSession.insert( f3 ); 
	   	
	   	////////////////////////////////
       	
       	animal al1 = new animal (d1, "gato"); //Fogo na cozinha
       	animal al2 = new animal (d2, "cão"); //Fogo no escritório
       	animal al3 = new animal (d3, "gato"); //Fogo na sala
	   	 
	   	 kSession.insert( al1 );
	   	 kSession.insert( al2 );
	   	 kSession.insert( al3 ); 
	   	 
	   	 
	   	 ///////////////////////////
	   	 
	   	somVidroPartir svp = new somVidroPartir(true);
	   	somVidroPartir svp2 = new somVidroPartir(true);
	   	 
	   	kSession.insert(svp);
	   	kSession.insert(svp2);

	   	
	   	codigo cdg = new codigo(d2, true);
	   	 
	   	kSession.insert(cdg);
	   	
	   	 */
	   	 
	   	 kSession.fireAllRules();
       	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
