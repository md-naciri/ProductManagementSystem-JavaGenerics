import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MetierProduitImpl metierProduitImpl = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");
            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1 ->
                    metierProduitImpl.getAll().forEach(System.out::println);

                case 2 -> {
                    System.out.println("Entrez l'id du produit : ");
                    long id = scanner.nextLong();
                    Produit produit = metierProduitImpl.findById(id);
                    if (produit != null) System.out.println(produit);
                    else System.out.println("Produit n'existe pas");
                }
                case 3 -> {
                    System.out.println("Entrez l'id du produit : ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.println("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();
                    System.out.println("Entrez le prix du produit : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Entrez la description du produit : ");
                    String description = scanner.nextLine();
                    System.out.println("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();
                    Produit produit = new Produit(id, nom, marque, prix, description, stock);
                    metierProduitImpl.add(produit);
                    System.out.println("Produit ajouté avec succès");
                }
                case 4 -> {
                    System.out.println("Entrez l'id du produit à supprimer : ");
                    long id = scanner.nextLong();
                    Produit produit = metierProduitImpl.findById(id);
                    if (produit != null) {
                        metierProduitImpl.delete(id);
                        System.out.println("Produit supprimé");
                    }
                    else System.out.println("Produit n'existe pas");
                }
                case 5 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Choix invalide. Réessayez.");
            }
        }

    }
}
