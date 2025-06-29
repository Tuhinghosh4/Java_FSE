import java.util.Arrays;
import java.util.Comparator;

public class Product{
    int productId;
    String productName;
    String category;
    public Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "ID=" + productId +
                ", Name='" + productName + '\'' +
                ", Category='" + category + '\'' +
                '}';
    }
    // public static void main(String[] args) {
    //     Product p1 =new Product(3, "Shoes", "Footwear");
    //     System.out.println(p1);
    // }
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shoes", "Footwear"),
                new Product(3, "Tablet", "Electronics"),
                new Product(4, "Watch", "Accessories"),
                new Product(5, "Shampoo", "Personal Care")
        };

        // --- Linear Search (unsorted) ---
        Product found1 = linearSearch(products, "Tablet");
        System.out.println("Linear Search Result: " + (found1 != null ? found1 : "Not found"));

        // --- Sort for Binary Search ---
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // --- Binary Search ---
        Product found2 = binarySearch(products, "Tablet");
        System.out.println("Binary Search Result: " + (found2 != null ? found2 : "Not found"));
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(targetName);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}