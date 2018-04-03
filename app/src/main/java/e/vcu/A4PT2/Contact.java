package e.vcu.A4PT2;

/**
 * Created by Judah Sebastian on 4/2/2018.
 */

public class Contact {
    String syn, ant, word;

    public void setSynonym(String syn){this.syn = syn;
    }

    public String getSynonym(){
        return this.syn;
    }

    public void setAntonym(String ant){
        this.ant = ant;
    }

    public String getAntonym(){
        return this.ant;
    }
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }

}
