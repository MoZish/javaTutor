package fact.it.exercisetextanalyzer.model;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String pigLatin() {
        String hulp,hulp2,pig= "";
        int beginIndex = 0;
        int index = text.indexOf('  ');
        while (index != -1){
            hulp = text.substring(beginIndex, index);
            hulp2 = hulp.substring(1) + hulp.charAt(0) + "ay ";
            pig += hulp;
            index = text.indexOf(" ", beginIndex + 1);
        }
        hulp = text.substring(beginIndex);
        hulp2 = hulp.substring(1) + hulp.charAt(0) + "ay";
        pig += hulp2;
        return pig;
    }

    public int countLetters(){
        int number = 0;
        char character;
        for (int i=0; i<=text.length(); i++){
           character = text.charAt(i);
           if (Character.isLetter(character)) {
               number++;
           }

        }
        return number;
    }

    public int countDigits(){
        int number = 0;
        char character;
        for (int i=1; i<text.length(); i++){
            character = text.charAt(i);
            if (Character.isDigit(character)) {
                number++;
            }

        }
        return number;
    }

}
