# Sorveteria

Métodos toString para cada uma das classes:

## Doce

```java
@Override
public String toString() {
  return String.format("%.2f g @ %s /kg\n%-25s %6s", getPeso(), 
    Sorveteria.centavos2ReaisECentavos(precoPorQuilo), getNome(), Sorveteria.centavos2ReaisECentavos(getCusto()));
}
```

## Cookie
```java
@Override
public String toString() {
  return String.format("%d @ %s /dz\n%-25s %6s", getNumero(), 
    Sorveteria.centavos2ReaisECentavos(getPrecoPorDuzia()), getNome(), Sorveteria.centavos2ReaisECentavos(getCusto()));
}
```

## Sorvete
```java
@Override
public String toString() {
  return String.format("%-25s %6s", getNome(), Sorveteria.centavos2ReaisECentavos(getCusto()));
}
```

## Sundae
```java
@Override
public String toString() {
  return String.format("Sundae de %s com\n%-25s %6s", getCobertura(), 
    getNome(), Sorveteria.centavos2ReaisECentavos(getCusto()));
}
```
