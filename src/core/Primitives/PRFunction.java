package core.primitives;

public interface PRFunction {
  int arity();
  int apply(int... args);
}
