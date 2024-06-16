package shopping.mall.domain.generator;

public interface TokenGenerator {
    String generate(long userId,long expireMs);
}
