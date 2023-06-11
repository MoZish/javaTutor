package fact.it.startdesignpattern.model;

public abstract class Profession  {
    private Artwork artwork;

    public Profession() {
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    abstract void update();

}
