package org.cleidson.coding.builder;

import java.io.Serializable;
import java.util.Objects;

public class ResultWithGenerics<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private final boolean valid;
	private final String internalLogMessage;
	private final String resultMessageKey;
    private final T result;

    private ResultWithGenerics(Builder<T> builder) {
        this.valid = builder.valid;
        this.resultMessageKey = builder.resultMessageKey;
        this.internalLogMessage = builder.internalLogMessage;
        this.result = builder.result;
    }

    public boolean isValid() {
        return valid;
    }

    public String getResultMessageKey() {
        return resultMessageKey;
    }

    public String getInternalLogMessage() {
		return internalLogMessage;
	}

	public T getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultWithGenerics<?> that = (ResultWithGenerics<?>) o;
        return valid == that.valid && Objects.equals(internalLogMessage, that.internalLogMessage) && Objects.equals(resultMessageKey, that.resultMessageKey) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valid, internalLogMessage, resultMessageKey, result);
    }

    @Override
    public String toString() {
        return "ResultWithGenerics{" +
                "valid=" + valid +
                ", internalLogMessage='" + internalLogMessage + '\'' +
                ", resultMessageKey='" + resultMessageKey + '\'' +
                ", result=" + result +
                '}';
    }

    public static <T> Builder<T> builder(boolean valid, String resultMessageKey) {
        return new Builder<>(valid, resultMessageKey);
    }

    public static class Builder<T> {
        private final boolean valid;
        private final String resultMessageKey;
        private String internalLogMessage;
        private T result;

        private Builder(boolean valid, String resultMessageKey) {
        	this.valid = valid;
        	this.resultMessageKey = resultMessageKey;
        }

        public Builder<T> internalLogMessage(String internalLogMessage) {
            this.internalLogMessage = internalLogMessage;
            return this;
        }

        public Builder<T> result(T result) {
            this.result = result;
            return this;
        }

        public ResultWithGenerics<T> build() {
            return new ResultWithGenerics<>(this);
        }
    }
}
