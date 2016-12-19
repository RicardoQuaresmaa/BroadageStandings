package Leagues;
// La Liga resmi sitesi canlı maç durumuna göre puan durumunu güncel tutmaktadır.
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.IOException;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.json.*;



public class ControlStandings 
{
   public static void LaLiga()
    {
        Document document_fed;
        Document document_ntv;
    try {
        
     //   ArrayList<String> puans_tff = new ArrayList<>();
    //    ArrayList<String> puans_ntv = new ArrayList<>();
    
  //  String[] puans_tff=new String[18];
    String[] puans_fed=new String[20];
    String[] puans_ntv=new String[21];
    String[] puans_ntv1=new String[20];
    
    	//Get Document object after parsing the html from given url.
        document_fed = Jsoup.connect("http://www.laliga.es/laliga-santander").get();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=8&tournamentId=7&languageId=1").get();       
	
     Element table_fed=document_fed.select("table").get(0);
    // System.out.println(table_fed);
     
     Elements div_ntv=document_ntv.select("div.points");
    // System.out.println(div_ntv);
     
        Elements rows_fed = table_fed.select("tr");
         Elements td_fed = rows_fed.select("td.contenedor-numero.puntos");
       //  System.out.println(td_fed);
         
   //     Elements divs_ntv=div_ntv.select("div");
   
   for (int i = 0; i < td_fed.size(); i++) 
     {
    Element td = td_fed.get(i);
  //  System.out.println(td.text());
    puans_fed[i]=td.text();
     }
        
      
             int sayi=0;
        for (int i = 0; i < div_ntv.size(); i++) 
        {
           
        //    System.out.println(div_ntv.get(i).text()); 
            puans_ntv[sayi]=div_ntv.get(i).text();          
         sayi++;
           
        }
        
        
       
     
        
                    
     

// System.out.println(puans_fed+" "+puans_ntv);

        for (int i = 1; i < puans_ntv.length; i++) 
        {
            String nesne1=puans_ntv[i];
         //   System.out.println(nesne1);
            puans_ntv1[i-1]=nesne1;            
        }
        


     int kontrol=0;
        for (int i = 0; i < 20; i++) 
        {
             System.out.println(puans_ntv1[i]+" "+puans_fed[i]); 
          //   int NTV=Integer.parseInt(puans_ntv1[i]);
           //  int TFF=Integer.parseInt(puans_fed[i]);
             String NTV=puans_ntv1[i].toString();
             String TFF=puans_fed[i].toString();
               
            /*
            if ((NTV-TFF)!=0) 
            {
                kontrol++;
            }
*/
            
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }  
            
        }

        


        
        if (kontrol==0) 
        {
        System.out.println("La Liga puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println("La Liga puan durumu resmi site ile uyumlu değildir."); 
        }
        
      
       
      
      
  
}
        
     catch (IOException e) {
	e.printStackTrace();
    }		
  }
         
   public static void Portugal()
   {
    try {
        Document document_fed;
        Document document_ntv;
     //   ArrayList<String> puans_tff = new ArrayList<>();
    //    ArrayList<String> puans_ntv = new ArrayList<>();
    
  //  String[] puans_tff=new String[18];
    String[] puans_fed=new String[18];
    String[] puans_ntv=new String[18];
  
    
    	//Get Document object after parsing the html from given url.
        document_fed = Jsoup.connect("http://www.ligaportugal.pt/pt/liga/classificacao/20162017/liganos").get();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=11&tournamentId=22&languageId=1").get();       
	
     Element table_fed=document_fed.select("table").get(0);
   //  System.out.println(table_fed);
    
     Elements rows_fed = table_fed.select("tr");
   //  System.out.println(rows_fed.size());
  
   for (int i = 2; i < rows_fed.size(); i++) 
     {
    Element tr_fed = rows_fed.get(i);
   Element td_fed=tr_fed.select("td").get(18);
   puans_fed[i-2]=td_fed.text();
  // System.out.println(td_fed.text());    
     }
                        
     Element div_ntv=document_ntv.select("div#mainLeagueTablePageContent").first();                                       
        Elements divs_ntv=div_ntv.select("div");                                 

          int sayi=0;       
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
            if ("points".equals(divs_ntv.get(i).className()) && (!"P".equals(divs_ntv.get(i).text()))) 
            {
         //   System.out.println(divs_ntv.get(i).text()); 
            puans_ntv[sayi]=divs_ntv.get(i).text();          
         sayi++;
            } 
        }
        
    
 
     int kontrol=0;
        for (int i = 0; i < 18; i++) 
        {
             System.out.println(puans_ntv[i]+" "+puans_fed[i]); 
          //   int NTV=Integer.parseInt(puans_ntv1[i]);
           //  int TFF=Integer.parseInt(puans_fed[i]);
             String NTV=puans_ntv[i].toString();
             String TFF=puans_fed[i].toString();
                                      
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }              
        }
                   
        if (kontrol==0) 
        {
        System.out.println("Portekiz Süper Lig puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println("Portekiz Süper Lig puan durumu resmi site ile uyumlu değildir."); 
        }
        
}
        
     catch (IOException e) {
	e.printStackTrace();
    }	
   }  
               
   public static void PremierLeague(){
     try {
         Document document_fed;
        Document document_ntv;
     //   ArrayList<String> puans_tff = new ArrayList<>();
    //    ArrayList<String> puans_ntv = new ArrayList<>();
    
  //  String[] puans_tff=new String[18];
    String[] puans_fed=new String[20];
    String[] puans_ntv=new String[21];
    String[] puans_ntv1=new String[20];
    
    	//Get Document object after parsing the html from given url.
        document_fed = Jsoup.connect("https://www.premierleague.com/tables").get();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=2&tournamentId=2&languageId=1").get();       
	
     Element table_fed=document_fed.select("table").get(0);
    // System.out.println(table_fed);
     
     Element div_ntv=document_ntv.select("div#mainLeagueTablePageContent").first();
     
        Elements rows_fed = table_fed.select("tr");
         Elements td_fed = rows_fed.select("td.points");
        // System.out.println(rows_fed.size());
         
        Elements divs_ntv=div_ntv.select("div");
        
             int sayi=0;
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
            if ("points".equals(divs_ntv.get(i).className())) 
            {
           // System.out.println(divs_ntv.get(i).text()); 
            puans_ntv[sayi]=divs_ntv.get(i).text();          
         sayi++;
            } 
        }
        
       
        
        
                    
     for (int i = 0; i < td_fed.size(); i++) 
     {
    Element td = td_fed.get(i);
  //  System.out.println(td);
    puans_fed[i]=td.text();
     }

// System.out.println(puans_fed+" "+puans_ntv);

        for (int i = 1; i < puans_ntv.length; i++) 
        {
            String nesne1=puans_ntv[i];
          //  System.out.println(nesne1);
            puans_ntv1[i-1]=nesne1;            
        }
        


     int kontrol=0;
        for (int i = 0; i < 20; i++) 
        {
             System.out.println(puans_ntv1[i]+" "+puans_fed[i]); 
          //   int NTV=Integer.parseInt(puans_ntv1[i]);
           //  int TFF=Integer.parseInt(puans_fed[i]);
             String NTV=puans_ntv1[i].toString();
             String TFF=puans_fed[i].toString();
               
            /*
            if ((NTV-TFF)!=0) 
            {
                kontrol++;
            }
*/
            
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }  
            
        }

        


        
        if (kontrol==0) 
        {
        System.out.println("İngiltere Premier Lig puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println("İngiltere Premier Lig puan durumu resmi site ile uyumlu değildir."); 
        }
        
      
       
      
      
  
}
        
     catch (IOException e) {
	e.printStackTrace();
    }
   }
   
   public static void TurkeySuperLeague()
   {
   
         try {
        
         Document document_tff;
        Document document_ntv;
     //   ArrayList<String> puans_tff = new ArrayList<>();
    //    ArrayList<String> puans_ntv = new ArrayList<>();
    
  //  String[] puans_tff=new String[18];
    String[] puans_tff=new String[18];
    String[] puans_ntv=new String[19];
    String[] puans_ntv1=new String[18];
    
    	//Get Document object after parsing the html from given url.
        document_tff = Jsoup.connect("http://www.tff.org/default.aspx?pageID=198").get();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=12&tournamentId=1&languageId=1").get();       
	//Get title from document_tff object.
	// String title = document_tff.title();   
      //  String html = document_tff.toString();
     //   Element body=document_tff.body();
     Element table_tff=document_tff.select("table").get(32);
     Element div_ntv=document_ntv.select("div#leagueTableInnerContent").first();
        Elements rows_tff = table_tff.select("tr");
        Elements divs_ntv=div_ntv.select("div");
        
             int sayi=0;
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
            if ("points".equals(divs_ntv.get(i).className())) 
            {
             //   System.out.println(divs_ntv.get(i).text()); 
            puans_ntv[sayi]=divs_ntv.get(i).text();          
         sayi++;
            } 
        }
                    
     for (int i = 1; i < rows_tff.size(); i++) 
     {
         //first row is the col names so skip it.
    Element row = rows_tff.get(i);
  //  int puan = Integer.parseInt(row.select("td").get(8).toString());
  Element td =row.select("td").get(8);
  Element span=td.select("span").get(0); 
  // System.out.println("bny"+i);
  puans_tff[i-1]=span.text();
     }
//  System.out.println(puans_ntv+" "+puans_tff); 


        for (int i = 1; i < puans_ntv.length; i++) 
        {
            String nesne1=puans_ntv[i];
          //  System.out.println(nesne1);
            puans_ntv1[i-1]=nesne1;            
        }
        
     int kontrol=0;
        for (int i = 0; i < 18; i++) 
        {
             System.out.println(puans_ntv1[i]+" "+puans_tff[i]); 
           //  int NTV=Integer.parseInt(puans_ntv1[i]);
           //  int TFF=Integer.parseInt(puans_tff[i]);
             String NTV=puans_ntv1[i].toString();
             String TFF=puans_tff[i].toString();
               
             /*
            if ((NTV-TFF)!=0) 
            {
                kontrol++;
            }
*/
             
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }  
             
        }

        if (kontrol==0) 
        {
        System.out.println("Spor Toto Süper Lig puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println(" Spor Toto Süper Lig puan durumu resmi site ile uyumlu deðildir."); 
        }
        
      
       
      
      
  
}
        
     catch (IOException e) {
	e.printStackTrace();
    }
   
   }
   
   public static void ItalySerieA()
   {
   
         try {
        
         Document document_tff;
        Document document_ntv;
     //   ArrayList<String> puans_tff = new ArrayList<>();
    //    ArrayList<String> puans_ntv = new ArrayList<>();
    
  //  String[] puans_tff=new String[18];
    String[] puans_tff=new String[20];
    String[] puans_ntv=new String[21];
    String[] puans_ntv1=new String[20];
    
    	//Get Document object after parsing the html from given url.
        document_tff = Jsoup.connect("http://www.legaseriea.it/it/serie-a-tim/classifica").get();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=4&tournamentId=6&languageId=1").get();       
	
     Element table_tff=document_tff.select("table").get(0);
     
    
     Element div_ntv=document_ntv.select("div#leagueTableInnerContent").first();
  
        Elements rows_tff = table_tff.select("tr");
       //   System.out.println(rows_tff.size());
        Elements divs_ntv=div_ntv.select("div");
        
             int sayi=0;
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
            if ("points".equals(divs_ntv.get(i).className())) 
            {
              //  System.out.println(divs_ntv.get(i).text()); 
            puans_ntv[sayi]=divs_ntv.get(i).text();          
         sayi++;
            } 
        }
                 
     for (int i = 2; i < rows_tff.size(); i++) 
     {
         //first row is the col names so skip it.
    Element row = rows_tff.get(i);
  //  int puan = Integer.parseInt(row.select("td").get(8).toString());
  Element td =row.select("td").get(1);
  
 //  System.out.println(td.text());
  puans_tff[i-2]=td.text();
     }
//  System.out.println(puans_ntv+" "+puans_tff); 
 /*  
 */
        for (int i = 1; i < puans_ntv.length; i++) 
        {
            String nesne1=puans_ntv[i];
          //  System.out.println(nesne1);
            puans_ntv1[i-1]=nesne1;            
        }
        
     int kontrol=0;
        for (int i = 0; i < 20; i++) 
        {
             System.out.println(puans_ntv1[i]+" "+puans_tff[i]); 
           //  int NTV=Integer.parseInt(puans_ntv1[i]);
           //  int TFF=Integer.parseInt(puans_tff[i]);
             String NTV=puans_ntv1[i].toString();
             String TFF=puans_tff[i].toString();
               
           
             
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }  
             
        }

        if (kontrol==0) 
        {
        System.out.println("İtalya Serie-A puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println("İtalya Serie-B puan durumu resmi site ile uyumlu değildir."); 
        }
        
      
       
      
      
  
}
        
     catch (IOException e) {
	e.printStackTrace();
    }
   
   }
    
   public static void Bundesliga()
   {
   
         try {
        
         Document document_tff;
        Document document_ntv;
 Document document_tff1;
    

    String[] puans_tff=new String[18];
    String[] puans_ntv=new String[19];
    String[] puans_ntv1=new String[18];
    
    document_tff1 = Jsoup.connect("http://www.bundesliga.de/de/liga/tabelle/").get();
        
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/Index.aspx?sportId=1&countryId=3&tournamentId=5&languageId=1").get();       
String haftatext=document_tff1.select("div#mobile-switch").first().text();
 String hafta=haftatext.split("\\.")[0];
        document_tff = Jsoup.connect("http://www.bundesliga.de/data/feed/51/2016/post_standing/post_standing_"+hafta+".xml").get();
     Element standing=document_tff.select("standing").get(0);
     Elements sta=standing.select("outcome-totals");
    
             for (int i = 0; i < sta.size(); i+=3) 
             {                 
                // System.out.println(sta.get(i).text()); 
                 Element dff=sta.get(i);
             //    System.out.println(i+" "+dff.attr("standing-points"));
                 int sayi=(i/3);
                 String text=dff.attr("standing-points");
             //     System.out.println(text);
                 puans_tff[sayi]=text;
             }
  
     Element div_ntv=document_ntv.select("div#leagueTableInnerContent").first();
     
   //  System.out.println(div_ntv);
  
        Elements divs_ntv=div_ntv.select("div");
        
        
          
             int sayi=0;
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
            if ("points".equals(divs_ntv.get(i).className())) 
            {
              
             //   System.out.println(divs_ntv.get(i).text()); 
           puans_ntv[sayi]=divs_ntv.get(i).text();          
         sayi++;
            } 
        }
        
       
   


        for (int i = 1; i < puans_ntv.length; i++) 
        {
            String nesne1=puans_ntv[i];
         //   System.out.println(nesne1);
            puans_ntv1[i-1]=nesne1;            
        }
        
     int kontrol=0;
        for (int i = 0; i <18; i++) 
        {
             System.out.println(puans_ntv1[i]+" "+puans_tff[i]); 
          
             String NTV=puans_ntv1[i].toString();
             String TFF=puans_tff[i].toString();
               
           
             
             if (!NTV.equals(TFF)) 
            {
                kontrol++;
            }  
             
        }

        if (kontrol==0) 
        {
        System.out.println("Bundesliga puan durumu resmi site ile uyumludur.");            
        }
        
        else
        {
        System.out.println("Bundesliga puan durumu resmi site ile uyumlu değildir."); 
        }
        
      
       
      
      
  
}
        
     catch (IOException e) {
	e.printStackTrace();
    }
   
   }
   
   public static void NBA()
   {
    try {
        String document_fed;
        Document document_ntv;

    String[] puans_fed_win=new String[30];
    String[] puans_fed_lost=new String[30];
    String[] puans_fed_ham=new String[30];

        document_fed = Jsoup.connect("http://data.nba.net/10s/prod/v1/today.json/data/10s/prod/v1/current/standings_conference.json").ignoreContentType(true).execute().body();
        document_ntv = Jsoup.connect("http://ntvspor.broadagesports.com/LeagueTable/MultipleLeagueTableDataView.aspx?sportId=23&countryId=15&tournamentId=9&gridType=LeagueTable&detailType=General&groupingId=2&homeTeamId=&awayTeamId=&languageId=1&isPopup=undefinedundefined").get();       

        int indexOf = document_fed.indexOf("\"win\"");
        
   String guess1 ="\"win\"";
   String guess2 = "loss";
        int b=1;
for (
        int index = document_fed.indexOf(guess1);
     index >= 0;
     index = document_fed.indexOf(guess1, index + 1)
        
        )
    {
        if (b%2==1) 
        {
            puans_fed_ham[((b-1)/2)]=document_fed.substring(index,index+27);
          //  System.out.println(((b-1)/2+1)+" "+document_fed.substring(index,index+27));
        }   
    b++;
}




 for (int i = 0; i < puans_fed_ham.length; i++) 
        {
            
           String[] aa=puans_fed_ham[i].trim().split("\"");
    
         //   System.out.println(puans_fed_ham[i].trim().split("\""));
            
            for (int j = 0; j < aa.length; j++) 
            {
            //  System.out.println(aa[j]);                
              puans_fed_win[i]=aa[3];
              puans_fed_lost[i]=aa[7];                          
            }
        }
      
/*
 
        for (int i = 0; i < puans_fed_win.length; i++) 
        {
          //   System.out.println("win "+puans_fed_win[i]);           
        }
  
        
        for (int i = 0; i < puans_fed_lost.length; i++) 
        {
         //    System.out.println("lost "+puans_fed_lost[i]);            
        }

*/

// System.out.println(puans_fed_lost.length);
// System.out.println(puans_fed_win.length);

     String[] puans_ntv_win=new String[30];
     String[] puans_ntv_lost=new String[30];
 
        //   System.out.println(document_ntv);
           
           Elements divs_ntv=document_ntv.select("div");

            int sayi=0;
            int sayi1=0;
        for (int i = 0; i < divs_ntv.size(); i++) 
        {
        if ("wins".equals(divs_ntv.get(i).className()) && (!"G".equals(divs_ntv.get(i).text())))
        {
      //   System.out.println("wins"+divs_ntv.get(i).text());
        puans_ntv_win[sayi]=divs_ntv.get(i).text();
        sayi++;              
        }
        
        if ("loses".equals(divs_ntv.get(i).className()) && (!"M".equals(divs_ntv.get(i).text())))
        {
      //   System.out.println("loses"+divs_ntv.get(i).text());
        puans_ntv_lost[sayi1]=divs_ntv.get(i).text();
        sayi1++;              
        }                     
        }

        /*
        for (int i = 0; i < puans_ntv_lost.length; i++) 
        {
         //   System.out.println("lost-bny"+puans_ntv_lost[i]);            
        }
        
        
        
          for (int i = 0; i < puans_ntv_win.length; i++) 
        {
        //    System.out.println("win-bny"+puans_ntv_win[i]);            
        }
        */  
          
     
      
int kontrol=0;
          for (int i = 0; i < puans_fed_win.length; i++) 
        {
            if (!puans_fed_win[i].equals(puans_ntv_win[i])) 
            {
                kontrol++;
                System.out.println((i+1)+" win "+puans_fed_win[i]+" "+puans_ntv_win[i]);
            }  
            
            if (!puans_fed_lost[i].equals(puans_ntv_lost[i])) 
            {
                kontrol++;
                  System.out.println((i+1)+" lost "+puans_fed_lost[i]+" "+puans_ntv_lost[i]);
            }
        }
          
          int fed_toplam=0;  int ntv_toplam=0;
          
          for (int i = 0; i < puans_fed_win.length; i++) 
        {
            fed_toplam+=Integer.parseInt(puans_fed_win[i]);
            
            fed_toplam+=Integer.parseInt(puans_fed_lost[i]);
            
        }
          
          
            for (int i = 0; i < puans_ntv_win.length; i++) 
        {
            ntv_toplam+=Integer.parseInt(puans_ntv_win[i]);
            
            ntv_toplam+=Integer.parseInt(puans_ntv_lost[i]);
            
        }
          
            
           if (ntv_toplam!=fed_toplam) 
        {
        System.out.println("NBA puan durumundaki toplam oynanmış maç sayısı resmi site ile uyumlu değildir.");    
        }
          
        
        
        if (kontrol==0)
        {
        System.out.println("NBA puan durumu resmi site ile uyumludur.");
        }
        else
        {
        System.out.println("NBA puan durumu resmi site ile "+kontrol/2+". dereceden uyumlu değildir."); 
        }
         
}
        
     catch (IOException e) {
	e.printStackTrace();
    }	
   }  
          
   
}

