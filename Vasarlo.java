import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vasarlo implements Kozos{
    public final String nev;
    protected String igazolvanySzam;
    private int penz;


    public int getPenz() {
        return penz;
    }

    public Vasarlo(String nev, String igazolvanySzam) {
        this.nev = nev;
        this.igazolvanySzam = igazolvanySzam;
        this.penz = 0;
    }


    public void penztKolt(int mennyit){
        if(mennyit > this.penz){
             throw new SajatError("Nincs eleg penz!");
        }
        else{
            this.penz -= mennyit;
        }

    }


    public void vagyontKiszamit(String filename){

        try{

            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] adatok = line.split(";");
                String tipus = adatok[1];
                int mennyi = Integer.parseInt(adatok[2]);

                if(tipus.equals("BEVITEL")){
                    this.penz += mennyi;
                }

                if(tipus.equals("KIADAS")){
                    this.penz -= mennyi;
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
