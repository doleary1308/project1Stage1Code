import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductList implements Serializable {
  private static final long serialVersionUID = 1L;
  private List products = new LinkedList();
  private static ProductList productList;
  private ProductList() {
  }
  public static ProductList instance() {
    if (productList == null) {
      return (productList = new ProductList());
    } else {
      return productList;
    }
  }
  public Product search(String productId) {
    for (Iterator iterator = products.iterator(); iterator.hasNext(); ) {
      Product product = (Product) iterator.next();
      if (product.getId().equals(productId)) {
        return product;
      }
    }
    return null;
  }
  public boolean removeProduct(String productId) {
    Product product = search(productId);
    if (product == null) {
      return false;
    } else {
      return products.remove(product);
    }
  }
  public boolean insertProduct(Product product) {
    products.add(product);
    return true;
  }
  public Iterator getProducts() {
    return products.iterator();
  }
  private void writeObject(ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(productList);
    } catch(IOException ioe) {
      System.out.println(ioe);
    }
  }
  private void readObject(ObjectInputStream input) {
    try {
      if (productList != null) {
        return;
      } else {
        input.defaultReadObject();
        if (productList == null) {
          productList = (ProductList) input.readObject();
        } else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      System.out.println("in ProductList readObject \n" + ioe);
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
  public String toString() {
    return products.toString();
  }
}
