import java.util.*;
import java.util.function.Function;

enum AssetType { BOND, STOCK }

class Asset {
  public final String symbol;
  public final AssetType type;
  public final double amount;
  
  public Asset(String theSymbol, AssetType theType, double theAmount) {
    symbol = theSymbol;
    type = theType;
    amount = theAmount;
  }
}

public class Sample { 
  public static void main(String[] args) {
    List<Asset> assets = Arrays.asList(
      new Asset("A", AssetType.BOND, 10.0),
      new Asset("B", AssetType.STOCK, 20.0),
      new Asset("C", AssetType.BOND, 30.0),
      new Asset("D", AssetType.STOCK, 40.0)
    );
    
    System.out.println(
      assets.stream()
            .map(asset -> asset.amount)
            .reduce(0.0, (total, amount) -> total + amount));
            
    System.out.println(
      assets.stream()
            .filter(asset -> asset.type == AssetType.BOND)
            .map(asset -> asset.amount)
            .reduce(0.0, (total, amount) -> total + amount));
            
    System.out.println(
      assets.stream()
            .filter(asset -> asset.type == AssetType.BOND)
            .filter(asset -> asset.amount > 20)
            .map(asset -> asset.amount)
            .reduce(0.0, (total, amount) -> total + amount));
  }
}









