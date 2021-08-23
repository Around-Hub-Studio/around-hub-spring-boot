package studio.thinkground.aroundhub.common;

public class Constants {

  public enum ExceptionClass {

    PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");

    private String exceptionClass;

    ExceptionClass(String exceptionClass) {
      this.exceptionClass = exceptionClass;
    }

    public String getExceptionClass() {
      return exceptionClass;
    }

    @Override
    public String toString() {
      return getExceptionClass() + " Exception. ";
    }

  }

}
