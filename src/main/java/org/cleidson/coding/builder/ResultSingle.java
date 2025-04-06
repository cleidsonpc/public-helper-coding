package org.cleidson.coding.builder;

import java.io.Serializable;
import java.util.Objects;

public class ResultSingle implements Serializable {

	private static final long serialVersionUID = 1L;
	private final boolean valid;
	private final String internalLogMessage;
	private final String resultMessageKey;
    private final DataDto result;

    private ResultSingle(Builder builder) {
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

	public DataDto getResult() {
        return result;
    }

    public static Builder builder(boolean valid, String resultMessageKey) {
        return new Builder(valid, resultMessageKey);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultSingle resultSingle1 = (ResultSingle) o;
        return valid == resultSingle1.valid && Objects.equals(internalLogMessage, resultSingle1.internalLogMessage) && Objects.equals(resultMessageKey, resultSingle1.resultMessageKey) && Objects.equals(result, resultSingle1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valid, internalLogMessage, resultMessageKey, result);
    }

    @Override
    public String toString() {
        return "Result{" +
                "valid=" + valid +
                ", internalLogMessage='" + internalLogMessage + '\'' +
                ", resultMessageKey='" + resultMessageKey + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Builder {
        private final boolean valid;
        private final String resultMessageKey;
        private String internalLogMessage;
        private DataDto result;

        private Builder(boolean valid, String resultMessageKey) {
        	this.valid = valid;
        	this.resultMessageKey = resultMessageKey;
        }

        public Builder internalLogMessage(String internalLogMessage) {
            this.internalLogMessage = internalLogMessage;
            return this;
        }

        public Builder result(DataDto result) {
            this.result = result;
            return this;
        }

        public ResultSingle build() {
            return new ResultSingle(this);
        }
    }
}
