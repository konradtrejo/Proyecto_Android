package interfaces;

public interface Mapper<From, To> {
    To map(From from);
}
