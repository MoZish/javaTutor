package fact.it.startdesignpattern;

import fact.it.startdesignpattern.model.Advocate;
import fact.it.startdesignpattern.model.Artwork;
import fact.it.startdesignpattern.model.Bidder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StartdesignpatternApplicationTests {

    @Test
    public void a_testObserverPattern_attach_1() {
        Artwork artwork = new Artwork();
        artwork.setName("Guernica");
        artwork.getObservers().clear();
        //create a few bidders
        Bidder joe = new Bidder();
        joe.setSurname("Biden");
        joe.setFirstname("Joe");
        Bidder donald = new Bidder();
        donald.setFirstname("Donald");
        donald.setSurname("Trump");
        Bidder bill = new Bidder();
        bill.setFirstname("Bill");
        bill.setSurname("Clinton");
        Bidder barack = new Bidder();
        barack.setFirstname("Barack");
        barack.setSurname("Obama");

        //we attach the bidders as observer to the artwork
        artwork.attachObserver(joe);
        artwork.attachObserver(donald);
        artwork.attachObserver(bill);
        artwork.attachObserver(barack);
        artwork.getObservers().forEach(o ->o.setArtwork(artwork));
        PrintStream defaultSO = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String result;
        System.setOut(new PrintStream(baos));
        try {
            //a new bid is placed...
            artwork.setHighestBid(540);
            BufferedReader br = new BufferedReader(new StringReader(baos.toString()));
            result = br.readLine();
            assertEquals("I am Joe Biden and might make a higher bid than 540.0 euro for the artwork Guernica", result);
            result = br.readLine();
            assertEquals("I am Donald Trump and might make a higher bid than 540.0 euro for the artwork Guernica", result);
            result = br.readLine();
            assertEquals("I am Bill Clinton and might make a higher bid than 540.0 euro for the artwork Guernica", result);
            result = br.readLine();
            assertEquals("I am Barack Obama and might make a higher bid than 540.0 euro for the artwork Guernica", result);
            br.close();
        } catch (Exception e) {
            System.setOut(defaultSO);
            System.out.println("Error while redirection System.out");
        }
        System.setOut(defaultSO);

    }

    @Test
    public void b_testObserverPattern_detach_2() {
        Artwork artwork = new Artwork();
        artwork.setName("Monalisa");
        artwork.getObservers().clear();
        //create a few bidders
        Bidder joe = new Bidder();
        joe.setSurname("Biden");
        joe.setFirstname("Joe");
        Bidder donald = new Bidder();
        donald.setFirstname("Donald");
        donald.setSurname("Trump");
        Bidder bill = new Bidder();
        bill.setFirstname("Bill");
        bill.setSurname("Clinton");
        Bidder barack = new Bidder();
        barack.setFirstname("Barack");
        barack.setSurname("Obama");
        //we attach the bidders as observer to the artwork
        artwork.attachObserver(joe);
        artwork.attachObserver(donald);
        artwork.attachObserver(bill);
        artwork.attachObserver(barack);
        artwork.getObservers().forEach(o -> o.setArtwork(artwork));
        //we detach donald and obama
        artwork.detachObserver(donald);
        artwork.detachObserver(barack);

        PrintStream defaultSO = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String result;
        System.setOut(new PrintStream(baos));
        try {
            //a new bid is placed...
            artwork.setHighestBid(600);
            BufferedReader br = new BufferedReader(new StringReader(baos.toString()));
            result = br.readLine();
            assertEquals("I am Joe Biden and might make a higher bid than 600.0 euro for the artwork Monalisa", result);
            result = br.readLine();
            assertEquals("I am Bill Clinton and might make a higher bid than 600.0 euro for the artwork Monalisa", result);
            result = br.readLine();
            br.close();
        } catch (Exception e) {
            System.setOut(defaultSO);
            System.out.println("Error while redirection System.out");
        }
        System.setOut(defaultSO);

    }
    @Test
    public void c_testDecoratorPattern_update_1(){
        Artwork artwork = new Artwork();
        artwork.setName("The Kiss");
        artwork.getObservers().clear();
        // add a new bidder

        Bidder joe = new Bidder();
        joe.setSurname("Biden");
        joe.setFirstname("Joe");
        joe.setArtwork(artwork);
        //give extra profession => advocate
        Advocate advocate = new Advocate();
        advocate.setBidder(joe);
        artwork.attachObserver(advocate);

        PrintStream defaultSO = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String result;
        System.setOut(new PrintStream(baos));
        try {
            artwork.setHighestBid(7000);
            BufferedReader br = new BufferedReader(new StringReader(baos.toString()));
            result = br.readLine();
            assertEquals("I am the advocate Joe Biden and check the new bid for The Kiss", result);
            br.close();
        } catch (Exception e) {
            System.setOut(defaultSO);
            System.out.println("Error while redirection System.out");
        }
        System.setOut(defaultSO);

    }

    @Test
    public void d_testDecoratorPattern_informclient_2(){
        Artwork artwork = new Artwork();
        artwork.setName("The Kiss");

        // add a new bidder
        Bidder joe = new Bidder();
        joe.setSurname("Biden");
        joe.setFirstname("Joe");
        joe.setArtwork(artwork);
        //give extra profession => advocate
        Advocate advocate = new Advocate();
        advocate.setBidder(joe);

        PrintStream defaultSO = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String result;
        System.setOut(new PrintStream(baos));
        try {
            advocate.informClient();
            BufferedReader br = new BufferedReader(new StringReader(baos.toString()));
            result = br.readLine();
            assertEquals("I am the advocate Joe Biden and I inform my client that there is a new bid for The Kiss", result);
            br.close();
        } catch (Exception e) {
            System.setOut(defaultSO);
            System.out.println("Error while redirection System.out");
        }
        System.setOut(defaultSO);

    }
}
