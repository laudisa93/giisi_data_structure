
public class resultados implements IResultados {
    private String eqLoc;
    private String eqVis;
    private int golLoc;
    private int golVis;

    public resultados(String eqLoc, String eqVis, int golLoc, int golVis) {
        this.eqLoc = eqLoc;
        this.eqVis = eqVis;
        this.golLoc = golLoc;
        this.golVis = golVis;
    }

    public String getEqLoc() {
        return eqLoc;
    }

    public String getEqVis() {
        return eqVis;
    }

    public int getGolLoc() {
        return golLoc;
    }

    public int getGolVis() {
        return golVis;
    }

    public void setEqLoc(String eqLoc) {
        this.eqLoc = eqLoc;
    }

    public void setEqVis(String eqVis) {
        this.eqVis = eqVis;
    }

    public void setGolLoc(int golLoc) {
        this.golLoc = golLoc;
    }

    public void setGolVis(int golVis) {
        this.golVis = golVis;
    }

    @Override
    public String toString() {
        return "Resultados{" + "eqLoc=" + eqLoc + "eqVis=" + eqVis + "golLoc=" + golLoc + "golVis=" + golVis + '}';
    }

}
