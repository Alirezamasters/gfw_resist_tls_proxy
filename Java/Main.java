

public class Main {

    public static void main(String[] args){
        System.out.println("your java version :"+System.getProperty("java.version")+"   recommended=java 17.0+");


        // set listen_port=0 to automatically choose some random port for listening                
        TLS_Fragmentor TLS_serv = new TLS_Fragmentor("127.0.0.1" ,2500 ,
                                                    "discord.com" ,443 ,
                                                    true , 87 , 0.005);
        TLS_serv.start();
        // System.out.println("port opened : "+ serv.get_listen_port() );



        // DoH service to be used inside code for DNS
        DoH_over_Fragment DoH_service = new DoH_over_Fragment("cloudflare", 
                                                            "sciencedirect.com", 443,
                                                            true, 87, 0.005);     
        
        
        // HTTPS proxy listening on 127.0.0.1:4500
        HTTPS_Fragmentor HTTPS_serv = new HTTPS_Fragmentor("127.0.0.1",4500,
                                                            null, -1,
                                                            DoH_service,true,
                                                            87,0.005);
        HTTPS_serv.start();

        DoH_service.query("youtube.com");
        DoH_service.query("youtu.be");
        DoH_service.query("google.com");
        DoH_service.query("fb.com");
        DoH_service.query("twitter.com");
        DoH_service.query("instagram.com");
                        
	                        
	}
    
}



