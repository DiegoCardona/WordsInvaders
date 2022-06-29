package WordsInvaders;

import javafx.scene.canvas.GraphicsContext;

public class Word extends LiveObject{

    public String textEnglish;
    public String textFrench;
    public String textSpanish;

    public Word(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Word) obj).textEnglish.equals(this.textEnglish);
    }

    /**
     * Temporally we will assume only english and spanish as valid language,
     * this needs to be updated to include additional languages
     * @param word
     */
    public void updateTexts(Word word) {
        this.textEnglish = word.textEnglish;
        this.textSpanish = word.textSpanish;
        this.textFrench = word.textFrench;
    }
}
