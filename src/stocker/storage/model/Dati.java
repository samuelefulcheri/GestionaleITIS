package stocker.storage.model;

public class Dati {
    private final int codiceProdotto;
    private final String nomeProdotto;
    private final float peso;
    private final float altezzaProdotto;
    private final float lunghezzaProdotto;
    private final float larghezzaProdotto;
    private final String casaProduttrice;
    private final String indirizzoCasaProduttrice;
    private final int identificativoCorriere;
    private final String compagniaTrasporti;

    public Dati(int codiceProdotto, String nomeProdotto, float peso, float altezzaProdotto,
                float lunghezzaProdotto, float larghezzaProdotto, String casaProduttrice, String indirizzoCasaProduttrice,
                int identificativoCorriere, String compagniaTrasporti) {
        this.codiceProdotto = codiceProdotto;
        this.nomeProdotto = nomeProdotto;
        this.peso = peso;
        this.altezzaProdotto = altezzaProdotto;
        this.lunghezzaProdotto = lunghezzaProdotto;
        this.larghezzaProdotto = larghezzaProdotto;
        this.casaProduttrice = casaProduttrice;
        this.indirizzoCasaProduttrice = indirizzoCasaProduttrice;
        this.identificativoCorriere = identificativoCorriere;
        this.compagniaTrasporti = compagniaTrasporti;
    }

    @Override
    public String toString() {
        return "Dati{" +
                "codiceProdotto=" + codiceProdotto +
                ", nomeProdotto='" + nomeProdotto + '\'' +
                ", peso=" + peso +
                ", altezzaProdotto=" + altezzaProdotto +
                ", lunghezzaProdotto=" + lunghezzaProdotto +
                ", larghezzaProdotto=" + larghezzaProdotto +
                ", casaProduttrice='" + casaProduttrice + '\'' +
                ", indirizzoCasaProduttrice='" + indirizzoCasaProduttrice + '\'' +
                ", identificativoCorriere=" + identificativoCorriere +
                ", compagniaTrasporti='" + compagniaTrasporti + '\'' +
                '}';
    }
}