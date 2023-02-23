package stocker.storage.model;

public class Dati {
    private int codiceProdotto;
    private String nomeProdotto;
    private float peso;
    private float altezzaProdotto;
    private float lunghezzaProdotto;
    private float larghezzaProdotto;
    private String casaProduttrice;
    private String indirizzoCasaProduttrice;
    private int identificativoCorriere;
    private String compagniaTrasporti;

    public Dati() {}

    public Dati(int codiceProdotto, String nomeProdotto, float peso, float altezzaProdotto,
                float lunghezzaProdotto, float larghezzaProdotto, String casaProduttrice, String indirizzoCasaProduttrice,
                int identificativoCorriere, String compagniaTrasporti)
    {
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



}
