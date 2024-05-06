import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files


public class Vasarlo implements KozosResz{
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
        if (this.penz < mennyit) {
            throw new SajatExcept("Nincs eleg penz!");
        }
        else {
            this.penz -= mennyit;
        }


    }

    public void vagyontKiszamit(String filename) {

        try {
            File file = new File(filename);
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                if (read.nextLine().split(";")[1].equals("BEVETEL")) {
                    this.penz += Integer.parseInt(read.nextLine().split(";")[2]);

                } else {
                    this.penz -= Integer.parseInt(read.nextLine().split(";")[2]);
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}


