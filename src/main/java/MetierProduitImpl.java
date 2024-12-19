import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        return produits.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(long id) {
        produits.removeIf(x -> x.getId() == id);
    }
}
