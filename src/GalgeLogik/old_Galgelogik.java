package GalgeLogik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class old_Galgelogik implements IGalgelogik, IGalgelogik {

private ArrayList<String> muligeOrd = new ArrayList<String>();
  private String ordet;
  private ArrayList<String> brugteBogstaver = new ArrayList<String>();
  private String synligtOrd;
  private int antalForkerteBogstaver;
  private boolean sidsteBogstavVarKorrekt;
  private boolean spilletErVundet;
  private boolean spilletErTabt;


  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#getBrugteBogstaver()
 */
public ArrayList<String> getBrugteBogstaver() {
    return brugteBogstaver;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#getSynligtOrd()
 */
public String getSynligtOrd() {
    return synligtOrd;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#getOrdet()
 */
public String getOrdet() {
    return ordet;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#getAntalForkerteBogstaver()
 */
public int getAntalForkerteBogstaver() {
    return antalForkerteBogstaver;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#erSidsteBogstavKorrekt()
 */
public boolean erSidsteBogstavKorrekt() {
    return sidsteBogstavVarKorrekt;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#erSpilletVundet()
 */
public boolean erSpilletVundet() {
    return spilletErVundet;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#erSpilletTabt()
 */
public boolean erSpilletTabt() {
    return spilletErTabt;
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#erSpilletSlut()
 */
public boolean erSpilletSlut() {
    return spilletErTabt || spilletErVundet;
  }


  public old_Galgelogik() {
    muligeOrd.add("bil");
    muligeOrd.add("computer");
    muligeOrd.add("programmering");
    muligeOrd.add("motorvej");
    muligeOrd.add("busrute");
    muligeOrd.add("gangsti");
    muligeOrd.add("skovsnegl");
    muligeOrd.add("solsort");
    nulstil();
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#nulstil()
 */
public void nulstil() {
    brugteBogstaver.clear();
    antalForkerteBogstaver = 0;
    spilletErVundet = false;
    spilletErTabt = false;
    ordet = muligeOrd.get(new Random().nextInt(muligeOrd.size()));
    opdaterSynligtOrd();
  }


  private void opdaterSynligtOrd() {
    synligtOrd = "";
    spilletErVundet = true;
    for (int n = 0; n < ordet.length(); n++) {
      String bogstav = ordet.substring(n, n + 1);
      if (brugteBogstaver.contains(bogstav)) {
        synligtOrd = synligtOrd + bogstav;
      } else {
        synligtOrd = synligtOrd + "*";
        spilletErVundet = false;
      }
    }
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#gætBogstav(java.lang.String)
 */
public void gætBogstav(String bogstav) {
    if (bogstav.length() != 1) return;
    System.out.println("Der gÃ¦ttes pÃ¥ bogstavet: " + bogstav);
    if (brugteBogstaver.contains(bogstav)) return;
    if (spilletErVundet || spilletErTabt) return;

    brugteBogstaver.add(bogstav);

    if (ordet.contains(bogstav)) {
      sidsteBogstavVarKorrekt = true;
      System.out.println("Bogstavet var korrekt: " + bogstav);
    } else {
      // Vi gÃ¦ttede pÃ¥ et bogstav der ikke var i ordet.
      sidsteBogstavVarKorrekt = false;
      System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
      antalForkerteBogstaver = antalForkerteBogstaver + 1;
      if (antalForkerteBogstaver > 6) {
        spilletErTabt = true;
      }
    }
    opdaterSynligtOrd();
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#logStatus()
 */
public void logStatus() {
    System.out.println("---------- ");
    System.out.println("- ordet (skult) = " + ordet);
    System.out.println("- synligtOrd = " + synligtOrd);
    System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
    System.out.println("- brugeBogstaver = " + brugteBogstaver);
    if (spilletErTabt) System.out.println("- SPILLET ER TABT");
    if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
    System.out.println("---------- ");
  }


  public static String hentUrl(String url) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
    StringBuilder sb = new StringBuilder();
    String linje = br.readLine();
    while (linje != null) {
      sb.append(linje + "\n");
      linje = br.readLine();
    }
    return sb.toString();
  }

  /* (non-Javadoc)
 * @see GalgeLogik.IGalgelogik#hentOrdFraDr()
 */
public void hentOrdFraDr() throws Exception {
    String data = hentUrl("http://dr.dk");
    System.out.println("data = " + data);

    data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zÃ¦Ã¸Ã¥]", " ");
    System.out.println("data = " + data);
    muligeOrd.clear();
    muligeOrd.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

    System.out.println("muligeOrd = " + muligeOrd);
    nulstil();
  }
}
