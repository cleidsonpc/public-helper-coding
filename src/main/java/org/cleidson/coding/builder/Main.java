package org.cleidson.coding.builder;

public class Main {
    public static void main(String[] args) {
        DataDto dataDto = new DataDto();
        dataDto.setId(1L);
        dataDto.setValue("value");

        useResultWithGenerics(dataDto);
        useResult(dataDto);
    }

    private static void useResultWithGenerics(DataDto dataDto) {
        ResultWithGenerics<?> resultWithGenerics = ResultWithGenerics.builder(true, "message.key")
                .internalLogMessage("Just testing")
                .result(dataDto)
                .build();
        System.out.println("Result with Generics 1, data: " + resultWithGenerics);


        ResultWithGenerics<DataDto> resultWithGenerics2 = ResultWithGenerics.<DataDto>builder(true, "message.key")
                .internalLogMessage("Just testing")
                .result(dataDto)
                .build();
        System.out.println("Result with Generics 2, data: " + resultWithGenerics2);
    }

    private static void useResult(DataDto dataDto) {
        ResultSingle resultSingle = ResultSingle.builder(true, "message.key")
                .internalLogMessage("Just testing")
                .result(dataDto)
                .build();

        System.out.println("Result single, data: " + resultSingle);
    }
}
